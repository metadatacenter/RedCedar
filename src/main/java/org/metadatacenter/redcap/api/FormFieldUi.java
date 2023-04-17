package org.metadatacenter.redcap.api;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public interface FormFieldUi {

    RedcapFieldType fieldType();

    Cardinality cardinality();
}
