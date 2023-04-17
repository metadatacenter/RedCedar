package org.metadatacenter.redcap.api;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public record FixedChoiceFieldUi(FixedChoiceType fixedChoiceType) implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return fixedChoiceType.getRedcapFieldType();
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
