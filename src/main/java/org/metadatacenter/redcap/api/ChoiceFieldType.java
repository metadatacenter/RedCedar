package org.metadatacenter.redcap.api;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public enum ChoiceFieldType {

    DROPDOWN,

    CHECKBOX,

    RADIO;

    public RedcapFieldType getRedcapFieldType() {
        return switch (this) {
            case CHECKBOX -> RedcapFieldType.Checkbox;
            case DROPDOWN -> RedcapFieldType.Dropdown;
            case RADIO -> RedcapFieldType.Radio;
        };
    }

    public Cardinality getCardinality() {
        return switch (this) {
            case CHECKBOX -> Cardinality.MULTIPLE;
            case DROPDOWN -> Cardinality.SINGLE;
            case RADIO -> Cardinality.SINGLE;
        };
    }
}
