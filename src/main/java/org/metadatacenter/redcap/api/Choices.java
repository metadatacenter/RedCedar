package org.metadatacenter.redcap.api;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public record Choices(List<Choice> choices) {

    public static Choices empty() {
        return new Choices(List.of());
    }
}
