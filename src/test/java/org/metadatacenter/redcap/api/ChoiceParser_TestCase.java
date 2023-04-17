package org.metadatacenter.redcap.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.metadatacenter.redcap.parser.ChoiceParseException;
import org.metadatacenter.redcap.parser.ChoiceParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class ChoiceParser_TestCase {

    private ChoiceParser parser;

    @BeforeEach
    public void setup() {
        parser = new ChoiceParser();
    }

    @Test
    public void shouldParseSimpleChoice() {
        var choice = "1,A";
        var result = parser.parseChoice(choice);
        assertThat(result.value()).isEqualTo("1");
        assertThat(result.label()).isEqualTo("A");
    }

    @Test
    public void shouldParseSimpleChoiceSurroundedByWhiteSpace() {
        var choice = " 1,A ";
        var result = parser.parseChoice(choice);
        assertThat(result.value()).isEqualTo("1");
        assertThat(result.label()).isEqualTo("A");
    }

    @Test
    public void shouldParseSimpleChoiceWithWhiteSpaceSurroundingDelimeter() {
        var choice = " 1 , A ";
        var result = parser.parseChoice(choice);
        assertThat(result.value()).isEqualTo("1");
        assertThat(result.label()).isEqualTo("A");
    }

    @Test
    public void shouldParseChoiceWithMultipleDelimeters() {
        var choice = " 1,A, or B";
        var result = parser.parseChoice(choice);
        assertThat(result.value()).isEqualTo("1");
        assertThat(result.label()).isEqualTo("A, or B");
    }

    @Test
    public void shouldNotParseChoiceWithoutValue() {
        var exception = assertThrows(ChoiceParseException.class, () -> {
            var choice = " ,A";
            parser.parseChoice(choice);
        });
        assertThat(exception.getChoice()).isEqualTo(" ,A");
    }

    @Test
    public void shouldNotParseChoiceWithoutLabel() {
        var exception = assertThrows(ChoiceParseException.class, () -> {
            var choice = "1, ";
            parser.parseChoice(choice);
        });
        assertThat(exception.getChoice()).isEqualTo("1, ");
    }

    @Test
    public void shouldNotParseChoiceWithoutDelimeter() {
        var exception = assertThrows(ChoiceParseException.class, () -> {
            var choice = "1 A";
            parser.parseChoice(choice);
        });
        assertThat(exception.getChoice()).isEqualTo("1 A");
    }



}
