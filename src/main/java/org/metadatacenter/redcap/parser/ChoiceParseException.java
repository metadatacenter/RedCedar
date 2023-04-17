package org.metadatacenter.redcap.parser;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class ChoiceParseException extends ParseException {

    private final String choice;

    public ChoiceParseException(String choice, String errorMessage) {
        super(errorMessage);
        this.choice = choice;
    }

    public String getChoice() {
        return this.choice;
    }
}
