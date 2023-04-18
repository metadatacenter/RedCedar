package org.metadatacenter.redcap.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.metadatacenter.redcap.csv.RedcapDataDictionaryCsvRecord;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class RedcapDataDictionaryCsvRecord_TestCase {

    private RedcapDataDictionaryCsvRecord record;

    @BeforeEach
    public void setUp() {
        record = new RedcapDataDictionaryCsvRecord(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    @Test
    public void shouldHandleNullsInVariableFieldName() {
        assertThat(record.variableFieldName()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInFormName() {
        assertThat(record.formName()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInSectionHeader() {
        assertThat(record.sectionHeader()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInFieldType() {
        assertThat(record.sectionHeader()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInFieldLabel() {
        assertThat(record.fieldLabel()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInChoicesCalculationsOrSliderLabels() {
        assertThat(record.choicesOrCalculationsOrSliderLabels()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInFieldNote() {
        assertThat(record.fieldNote()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInTextValidationMin() {
        assertThat(record.textValidationMin()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInTextValidationMax() {
        assertThat(record.textValidationMax()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInIdentifier() {
        assertThat(record.identifier()).isNotNull();
    }

    @Test
    public void shouldHandleNullsBranchingLogic() {
        assertThat(record.branchingLogic()).isNotNull();
    }

    @Test
    public void shouldHandleNullsRequiredField() {
        assertThat(record.requiredField()).isNotNull();
    }

    @Test
    public void shouldHandleNullsCustomAlignment() {
        assertThat(record.customAlignment()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInQuestionNumber() {
        assertThat(record.questionNumber()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInMatrixGroupName() {
        assertThat(record.matrixGroupName()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInMatrixRanking() {
        assertThat(record.matrixRanking()).isNotNull();
    }

    @Test
    public void shouldHandleNullsInFieldAnnotation() {
        assertThat(record.fieldAnnotation()).isNotNull();
    }


}
