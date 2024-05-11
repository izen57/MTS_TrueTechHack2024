package org.glabs.accessibility.domain;

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
