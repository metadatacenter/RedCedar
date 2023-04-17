package org.metadatacenter.redcap.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.metadatacenter.redcap.parser.ChoiceParseException;
import org.metadatacenter.redcap.parser.ChoiceParser;
import org.metadatacenter.redcap.parser.ChoicesParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class ChoicesParser_TestCase {

    private ChoiceParser choiceParser;

    private ChoicesParser parser;


    @BeforeEach
    public void setup() {
        choiceParser = new ChoiceParser();
        parser = new ChoicesParser(choiceParser);
    }

    @Test
    public void shouldParseChoicesWithPipeSeparator() {
        var choices = "1, A | 2, B";
        var parsed = parser.parseChoices(choices);
        assertThat(parsed.choices()).hasSize(2);
        assertThat(parsed.choices().get(0).value()).isEqualTo("1");
        assertThat(parsed.choices().get(0).label()).isEqualTo("A");
        assertThat(parsed.choices().get(1).value()).isEqualTo("2");
        assertThat(parsed.choices().get(1).label()).isEqualTo("B");
    }

    @Test
    public void shouldParseChoicesWithSemiColonSeparator() {
        var choices = "1, A ; 2, B";
        var parsed = parser.parseChoices(choices);
        assertThat(parsed.choices()).hasSize(2);
        assertThat(parsed.choices().get(0).value()).isEqualTo("1");
        assertThat(parsed.choices().get(0).label()).isEqualTo("A");
        assertThat(parsed.choices().get(1).value()).isEqualTo("2");
        assertThat(parsed.choices().get(1).label()).isEqualTo("B");
    }

    @Test
    public void shouldPropagateException() {
        assertThrows(ChoiceParseException.class, () -> {
            var choices = "A | B";
            parser.parseChoices(choices);
        });
    }
}
