package org.metadatacenter.redcap.csv;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.metadatacenter.redcap.api.RedcapFieldType;

import java.util.Objects;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 *
 * Represents the information stored in a field record in REDCap data dictionary CSV
 */
public record RedcapDataDictionaryCsvRecord(@JsonProperty(value = "Variable / Field Name", required = true) @JsonAlias("Variable") String variableFieldName,
                                            @JsonProperty(value = "Form Name", required = true) String formName,
                                            @JsonProperty(value = "Section Header") String sectionHeader,
                                            @JsonProperty(value = "Field Type", required = true) RedcapFieldType fieldType,
                                            @JsonProperty(value = "Field Label", required = true) String fieldLabel,
                                            @JsonProperty("Choices, Calculations, OR Slider Labels") @JsonAlias("Choices") String choicesOrCalculationsOrSliderLabels,
                                            @JsonProperty("Field Note") String fieldNote,
                                            @JsonProperty("Text Validation Type OR Show Slider Number") @JsonAlias("Text Validation Type") String textValidationTypeOrShowSliderNumber,
                                            @JsonProperty("Text Validation Min") String textValidationMin,
                                            @JsonProperty("Text Validation Max") String textValidationMax,
                                            @JsonProperty("Identifier?") String identifier,
                                            @JsonProperty("Branching Logic (Show field only if...)") @JsonAlias("Branching Logic") String branchingLogic,
                                            @JsonProperty("Required Field?") String requiredField,
                                            @JsonProperty("Custom Alignment") String customAlignment,
                                            @JsonProperty("Question Number (surveys only)") String questionNumber,
                                            @JsonProperty("Matrix Group Name") String matrixGroupName,
                                            @JsonProperty("Matrix Ranking?") String matrixRanking,
                                            @JsonProperty("Field Annotation") String fieldAnnotation) {

    public RedcapDataDictionaryCsvRecord {
        variableFieldName = Objects.requireNonNullElse(variableFieldName, "");
        formName = Objects.requireNonNullElse(formName, "");
        sectionHeader = Objects.requireNonNullElse(sectionHeader, "");
        fieldType = Objects.requireNonNullElse(fieldType, RedcapFieldType.Text);
        fieldLabel = Objects.requireNonNullElse(fieldLabel, "");
        choicesOrCalculationsOrSliderLabels = Objects.requireNonNullElse(choicesOrCalculationsOrSliderLabels, "");
        fieldNote = Objects.requireNonNullElse(fieldNote, "");
        textValidationMin = Objects.requireNonNullElse(textValidationMin, "");
        textValidationMax = Objects.requireNonNullElse(textValidationMax, "");
        identifier = Objects.requireNonNullElse(identifier, "");
        branchingLogic = Objects.requireNonNullElse(branchingLogic, "");
        requiredField = Objects.requireNonNullElse(requiredField, "");
        customAlignment = Objects.requireNonNullElse(customAlignment, "");
        questionNumber = Objects.requireNonNullElse(questionNumber, "");
        matrixGroupName = Objects.requireNonNullElse(matrixGroupName, "");
        matrixRanking = Objects.requireNonNullElse(matrixRanking, "");
        fieldAnnotation = Objects.requireNonNullElse(fieldAnnotation, "");
    }
}
