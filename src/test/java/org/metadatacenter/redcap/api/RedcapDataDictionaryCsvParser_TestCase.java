package org.metadatacenter.redcap.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.metadatacenter.redcap.parser.RedcapDataDictionaryCsvParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class RedcapDataDictionaryCsvParser_TestCase {

    private RedcapDataDictionaryCsvParser parser;

    @BeforeEach
    public void setup() {
        parser = new RedcapDataDictionaryCsvParser();
    }

    @Test
    public void shouldParseDataDictionaryWithAllColumns() throws IOException {
        var csv = """
                "Variable / Field Name","Form Name","Section Header","Field Type","Field Label","Choices, Calculations, OR Slider Labels","Field Note","Text Validation Type OR Show Slider Number","Text Validation Min","Text Validation Max",Identifier?,"Branching Logic (Show field only if...)","Required Field?","Custom Alignment","Question Number (surveys only)","Matrix Group Name","Matrix Ranking?","Field Annotation"
                record_id,demographics,,text,"Study ID","The Label",,,,,,,y,,,,,
                """;
        parseAndCheck(csv);
    }

    private void parseAndCheck(String csv) {
        try {
            var parsed = parser.parse(new ByteArrayInputStream(csv.getBytes()));
            assertThat(parsed.fields()).hasSize(1);
            var field = parsed.fields().get(0);
            assertThat(field.variableFieldName()).isEqualTo("record_id");
            assertThat(field.formName()).isEqualTo("demographics");
            assertThat(field.sectionHeader()).isEqualTo("");
            assertThat(field.fieldType()).isEqualTo(RedcapFieldType.Text);
            assertThat(field.fieldLabel()).isEqualTo("Study ID");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    @Test
    public void shouldParseDataDictionaryWithOnlyRequiredColumns() {
        var csv = """
                "Variable / Field Name","Form Name","Field Type","Field Label"
                record_id,demographics,text,"Study ID"
                """;
        parseAndCheck(csv);
    }
    @Test
    public void shouldParseDataDictionaryWithExtraColumns() {

    }
}
