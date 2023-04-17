package org.metadatacenter.redcap.parser;

import org.metadatacenter.redcap.api.Cardinality;
import org.metadatacenter.redcap.api.FormFieldUi;
import org.metadatacenter.redcap.api.RedcapFieldType;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-15
 */
public class SignatureFieldUi implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return RedcapFieldType.File;
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
