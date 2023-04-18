package org.metadatacenter.redcap.api;

import org.metadatacenter.redcap.api.Cardinality;
import org.metadatacenter.redcap.api.FormFieldUi;
import org.metadatacenter.redcap.api.RedcapFieldType;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-15
 */
public class NotesFieldUi implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return RedcapFieldType.Notes;
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
