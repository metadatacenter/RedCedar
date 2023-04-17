package org.metadatacenter.redcap.api;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public record UserDefinedChoiceFieldUi(Choices choices, ChoiceFieldType choiceFieldType) implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return choiceFieldType.getRedcapFieldType();
    }

    @Override
    public Cardinality cardinality() {
        return choiceFieldType.getCardinality();
    }
}
