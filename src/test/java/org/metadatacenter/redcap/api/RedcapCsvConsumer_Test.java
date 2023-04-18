package org.metadatacenter.redcap.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.metadatacenter.redcap.csv.RedcapCsvConsumer;
import org.metadatacenter.redcap.parser.RedcapDataDictionaryCsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-17
 */
public class RedcapCsvConsumer_Test {

    @BeforeEach
    public void setup() throws IOException {

    }

    @Test
    void shouldProcessDictionary() throws IOException {
        var is = getClass().getResourceAsStream("/test-dictionary.csv");
        RedcapDataDictionaryCsvParser parser = new RedcapDataDictionaryCsvParser();
        var csv =parser.parse(is);
        RedcapCsvConsumer consumer = new RedcapCsvConsumer();
        var forms = consumer.getForms(csv);
        assertThat(forms).hasSize(1);

        var form = forms.get(0);
        assertThat(form.formName()).isEqualTo("demographics");

        var sections = form.sections();
        assertThat(sections).hasSize(1);

        var section = sections.get(0);
        assertThat(section.sectionHeader()).isEmpty();

        var fields = section.fields();
        assertThat(fields).hasSize(9);

        shouldParseField0(fields);
        shouldParseField1(fields);
        shouldParseField2(fields);
        shouldParseField3(fields);
        shouldParseField4(fields);
    }

    private void shouldParseField4(List<FormField> fields) {
        shouldParseRadio(fields.get(4), "gender", "Gender", Optionality.OPTIONAL,
                         new Choice("1", "Male"), new Choice("2", "Female"));
    }

    private void shouldParseRadio(FormField field, String expectedId, String expectedLabel, Optionality expectedOptionality,
                                  Choice ... choices) {
        assertThat(field.fieldId()).isEqualTo(expectedId);
        assertThat(field.label()).isEqualTo(expectedLabel);
        assertThat(field.optionality()).isEqualTo(expectedOptionality);
        assertThat(field.formFieldUi()).isInstanceOf(UserDefinedChoiceFieldUi.class);
        var ui = (UserDefinedChoiceFieldUi) field.formFieldUi();
        assertThat(ui.choiceFieldType()).isEqualTo(ChoiceFieldType.RADIO);
        var parsedChoices = ui.choices().choices();
        assertThat(parsedChoices).contains(choices);
    }

    private void shouldParseField3(List<FormField> fields) {
        shouldParseTextField(fields.get(3),
                             "age",
                             "Age at enrollment",
                             Optionality.OPTIONAL,
                             TextValidationPattern.integer);
    }

    private void shouldParseField2(List<FormField> fields) {
        shouldParseTextField(fields.get(2),
                             "initials",
                             "Initials",
                             Optionality.OPTIONAL,
                             TextValidationPattern.alpha_only);
    }

    private void shouldParseField1(List<FormField> fields) {
        shouldParseTextField(fields.get(1), "sid", "Study ID", Optionality.REQUIRED, null);
    }

    private void shouldParseField0(List<FormField> fields) {
        shouldParseTextField(fields.get(0), "record_id", "Record ID", Optionality.OPTIONAL, null);
    }

    private void shouldParseTextField(FormField field, String expectedId, String expectedLabel, Optionality expectedOptionality, TextValidationPattern expectedPattern) {
        assertThat(field.fieldId()).isEqualTo(expectedId);
        assertThat(field.label()).isEqualTo(expectedLabel);
        assertThat(field.optionality()).isEqualTo(expectedOptionality);
        var fieldUi = field.formFieldUi();
        assertThat(fieldUi).isInstanceOf(TextFieldUi.class);
        var textFieldUi = (TextFieldUi) fieldUi;
        var optionallyExpectedPattern = Optional.ofNullable(expectedPattern);
        assertThat(textFieldUi.getTextValidationPattern()).isEqualTo(optionallyExpectedPattern);
    }
}
