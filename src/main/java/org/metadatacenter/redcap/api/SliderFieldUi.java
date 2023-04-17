package org.metadatacenter.redcap.api;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public class SliderFieldUi implements FormFieldUi {

    @Override
    public RedcapFieldType fieldType() {
        return RedcapFieldType.Slider;
    }

    @Override
    public Cardinality cardinality() {
        return Cardinality.SINGLE;
    }
}
