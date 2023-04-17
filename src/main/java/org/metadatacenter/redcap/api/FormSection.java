package org.metadatacenter.redcap.api;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public record FormSection(String sectionHeader, List<FormField> formFields) {

}
