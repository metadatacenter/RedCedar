package org.metadatacenter.redcap.parser;

import org.metadatacenter.redcap.api.Choice;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class ChoiceParser {

    public Choice parseChoice(String choice) throws ChoiceParseException {
        var trimmedChoice = choice.trim();
        var sepIndex = trimmedChoice.indexOf(",");
        if(sepIndex == -1) {
            throw new ChoiceParseException(choice, "Missing value/label comma separator");
        }
        if(sepIndex == 0) {
            throw new ChoiceParseException(choice, "Missing value");
        }
        if(sepIndex == trimmedChoice.length() - 1) {
            throw new ChoiceParseException(choice, "Missing label");
        }
        var value = trimmedChoice.substring(0, sepIndex).trim();
        var label = trimmedChoice.substring(sepIndex + 1).trim();
        return new Choice(value, label);
    }

}
