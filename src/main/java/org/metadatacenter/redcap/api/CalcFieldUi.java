package org.metadatacenter.redcap.api;

import org.metadatacenter.redcap.api.Cardinality;
import org.metadatacenter.redcap.api.FormFieldUi;
import org.metadatacenter.redcap.api.RedcapFieldType;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public class CalcFieldUi implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return RedcapFieldType.Calc;
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
