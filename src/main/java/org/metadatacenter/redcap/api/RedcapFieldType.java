package org.metadatacenter.redcap.api;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public enum RedcapFieldType {

    // Text Box (Short Text, Number, Date/Time, ...)
    Text("text", Cardinality.SINGLE),
    // Notes Box (Paragraph Text)
    Notes("notes", Cardinality.SINGLE),
    Calc("calc", Cardinality.SINGLE),
    // Multiple Choice Dropdown List (Single Answer)
    Dropdown("dropdown", Cardinality.SINGLE),
    // Multiple Choice Radio Buttons (Single Answer)
    Radio("radio", Cardinality.SINGLE),
    // Checkboxes (Multiple Answers)
    Checkbox("checkbox", Cardinality.MULTIPLE),
    YesNo("yesno", Cardinality.SINGLE),
    TrueFalse("truefalse", Cardinality.SINGLE),
    // Signature (draw signature with mouse or finger) With the Text Validation Type OR Show Slider Number set to signature
    // File upload (for users to upload files)
    File("file", Cardinality.SINGLE),
    /// Visual Analog Scale
    Slider("slider", Cardinality.SINGLE),
    // Descriptive text (with optional Image/Video/Audio/File Attachment)
    Descriptive("descriptive", Cardinality.SINGLE),
    // Begin new section (with optional text)
    Section("section", Cardinality.SINGLE);

    private String fieldName;

    private Cardinality cardinality;

    RedcapFieldType(String fieldName, Cardinality cardinality) {
        this.fieldName = fieldName;
        this.cardinality = cardinality;
    }

    @JsonValue
    public String getFieldName() {
        return this.fieldName;
    }
}
