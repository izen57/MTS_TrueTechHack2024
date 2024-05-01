package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.awt.*;
import java.util.UUID;

@Data
public class UserPreference {
    @NonNull private UUID id;
    @NonNull private int fontSize;
    @NonNull private Color fontColor;
    @NonNull private Color selectorColor;
}
