package org.metadatacenter.redcap.api;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public enum FixedChoiceType {

    YESNO,

    TRUEFALSE;

    public RedcapFieldType getRedcapFieldType() {
        if(this.equals(YESNO)) {
            return RedcapFieldType.YesNo;
        }
        else {
            return RedcapFieldType.TrueFalse;
        }
    }
}
