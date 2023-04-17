package org.metadatacenter.redcap.parser;

import org.metadatacenter.redcap.api.Choice;
import org.metadatacenter.redcap.api.Choices;

import java.util.Arrays;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class ChoicesParser {

    private final ChoiceParser choiceParser;

    public ChoicesParser() {
        this(new ChoiceParser());
    }

    public ChoicesParser(ChoiceParser choiceParser) {
        this.choiceParser = choiceParser;
    }

    public Choices parseChoices(String choices) {
        var parsedChoices = Arrays.stream(choices.split(getSeparator(choices)))
                .map(String::trim)
                .map(choiceParser::parseChoice)
                .toList();
        return new Choices(parsedChoices);
    }

    private String getSeparator(String choices) {
        if(choices.contains("|")) {
            return "\\|";
        }
        else {
            return ";";
        }
    }

}
