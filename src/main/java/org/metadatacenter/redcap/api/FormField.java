package org.metadatacenter.redcap.api;

public record FormField(String label, String note, Optionality optionality, Privacy privacy, String annotation, BranchingLogic branchingLogic, FormFieldUi formFieldUi) {

}
