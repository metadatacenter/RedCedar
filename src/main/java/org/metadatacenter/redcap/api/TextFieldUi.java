package org.metadatacenter.redcap.api;

import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public record TextFieldUi(TextValidationPattern textValidationPattern, String textValidationMin, String textValidationMax) implements FormFieldUi {

    public Optional<TextValidationPattern> getTextValidationPattern() {
        return Optional.ofNullable(textValidationPattern);
    }

    @Override
    public RedcapFieldType fieldType() {
        return RedcapFieldType.Text;
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
