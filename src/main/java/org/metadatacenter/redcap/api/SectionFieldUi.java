package org.metadatacenter.redcap.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.metadatacenter.redcap.api.Cardinality;
import org.metadatacenter.redcap.api.FormFieldUi;
import org.metadatacenter.redcap.api.RedcapFieldType;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-15
 */
public record SectionFieldUi() implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return RedcapFieldType.Section;
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
