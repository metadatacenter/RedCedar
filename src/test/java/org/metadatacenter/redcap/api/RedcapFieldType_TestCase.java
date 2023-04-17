package org.metadatacenter.redcap.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class RedcapFieldType_TestCase {

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldParseText() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"text\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Text);
    }

    @Test
    public void shouldParseNotes() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"notes\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Notes);
    }

    @Test
    public void shouldParseCalc() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"calc\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Calc);
    }

    @Test
    public void shouldParseDropdown() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"dropdown\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Dropdown);
    }

    @Test
    public void shouldParseRadio() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"radio\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Radio);
    }

    @Test
    public void shouldParseCheckbox() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"checkbox\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Checkbox);
    }

    @Test
    public void shouldParseYesNo() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"yesno\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.YesNo);
    }

    @Test
    public void shouldParseTrueFalse() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"truefalse\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.TrueFalse);
    }

    @Test
    public void shouldParseFile() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"file\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.File);
    }

    @Test
    public void shouldParseSlider() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"slider\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Slider);
    }

    @Test
    public void shouldParseDescriptive() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"descriptive\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Descriptive);
    }

    @Test
    public void shouldParseSection() throws JsonProcessingException {
        var parsed = objectMapper.readValue("\"section\"", RedcapFieldType.class);
        assertThat(parsed).isEqualTo(RedcapFieldType.Section);
    }

    /*

    text
notes
calc
dropdown
radio
checkbox
yesno
truefalse
file
file
slider
descriptive

     */

}
