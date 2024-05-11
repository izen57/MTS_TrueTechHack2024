package org.glabs.accessibility.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class EventAccessibilityFeature {
    @NonNull
    private String name;
    @NonNull
    private String description;
}
