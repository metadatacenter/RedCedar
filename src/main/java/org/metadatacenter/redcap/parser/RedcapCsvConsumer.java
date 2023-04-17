package org.metadatacenter.redcap.parser;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import org.metadatacenter.redcap.api.*;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public class RedcapCsvConsumer {

    public List<Form> getForms(RedcapDataDictionaryCsv csv) {
        var formNames2SectionNames = LinkedHashMultimap.<String, String>create();
        var sectionNames2Fields = ArrayListMultimap.<String, FormField>create();
        csv.fields().forEach(f -> {
            var fieldUi = processField(f);
            var formField = new FormField(f.fieldLabel(),
                                          f.fieldNote(),
                                          getOptionality(f),
                                          getPrivacy(f),
                                          f.fieldAnnotation(),
                                          new BranchingLogic(f.branchingLogic()),
                                          fieldUi);
            sectionNames2Fields.put(f.sectionHeader(), formField);
            formNames2SectionNames.put(f.formName(), f.sectionHeader());
        });
        return formNames2SectionNames.keySet().stream().map(formName -> {
            var formSectionNames = formNames2SectionNames.get(formName);
            var sections = formSectionNames.stream().map(formSectionName -> {
                var formFields = sectionNames2Fields.get(formName);
                return new FormSection(formSectionName, formFields);
            }).toList();
            return new Form(formName, sections);
        }).toList();
    }

    private Privacy getPrivacy(RedcapFieldRecord f) {
        return f.identifier()
                .equals("y") ? Privacy.CONTAINS_PHI : Privacy.DOES_NOT_CONTAIN_PHI;
    }

    private Optionality getOptionality(RedcapFieldRecord f) {
        return f.requiredField().equals("y") ? Optionality.REQUIRED : Optionality.OPTIONAL;
    }

    private FormFieldUi processField(RedcapFieldRecord f) {
        return switch (f.fieldType()) {
            case Text -> processTextField(f);
            case Dropdown -> processChoicesField(f, ChoiceFieldType.DROPDOWN);
            case Radio -> processChoicesField(f, ChoiceFieldType.RADIO);
            case Checkbox -> processChoicesField(f, ChoiceFieldType.CHECKBOX);
            case YesNo -> processYesNoField(f);
            case TrueFalse -> processTrueFalseField(f);
            case Slider -> processSliderField(f);
            case Calc -> processCalcFieldUi(f);
            case Descriptive -> processDescriptiveField(f);
            case File -> processFileField(f);
            case Notes -> processNotesField(f);
            case Section -> processSectionField(f);
        };
    }

    private FormFieldUi processSectionField(RedcapFieldRecord f) {
        return new SectionFieldUi();
    }

    private FormFieldUi processNotesField(RedcapFieldRecord f) {
        return new NotesFieldUi();
    }

    private FormFieldUi processFileField(RedcapFieldRecord fieldRecord) {
        if (fieldRecord.textValidationTypeOrShowSliderNumber().trim().equals("signature")) {
            return new SignatureFieldUi();
        }
        else {
            return new FileFieldUi();
        }
    }

    private FormFieldUi processDescriptiveField(RedcapFieldRecord f) {
        return new DescriptiveFieldUi();
    }

    private FormFieldUi processCalcFieldUi(RedcapFieldRecord f) {
        return new CalcFieldUi();
    }

    private FormFieldUi processSliderField(RedcapFieldRecord f) {
        return new SliderFieldUi();
    }

    private FormFieldUi processTrueFalseField(RedcapFieldRecord f) {
        return new FixedChoiceFieldUi(FixedChoiceType.TRUEFALSE);
    }

    private FormFieldUi processYesNoField(RedcapFieldRecord f) {
        return new FixedChoiceFieldUi(FixedChoiceType.YESNO);
    }

    private FormFieldUi processChoicesField(RedcapFieldRecord f, ChoiceFieldType choiceFieldType) {
        var choices = getChoices(f);
        return new UserDefinedChoiceFieldUi(choices, choiceFieldType);
    }


    private Choices getChoices(RedcapFieldRecord f) {
        var choicesSpec = f.choicesOrCalculationsOrSliderLabels();
        if (choicesSpec.isBlank()) {
            return Choices.empty();
        }
        var choicesParser = new ChoicesParser();
        return choicesParser.parseChoices(choicesSpec);
    }

    private TextFieldUi processTextField(RedcapFieldRecord f) {
        var textValidationType = f.textValidationTypeOrShowSliderNumber().trim();
        var textValidationMin = f.textValidationMin().trim();
        var textValidationMax = f.textValidationMax().trim();
        var pattern = TextValidationPattern.getTextValidationPattern(textValidationType).orElse(null);
        return new TextFieldUi(pattern, textValidationMin, textValidationMax);
    }
}
