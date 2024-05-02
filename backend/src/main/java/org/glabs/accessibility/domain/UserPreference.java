package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.UUID;

@Setter
@Getter
@Data
public class UserPreference {
    private UUID id;
    private int fontSize;
    private Color fontColor;
    private Color selectorColor;

    public UserPreference() { }

    public UserPreference(UUID id, int fontSize, Color fontColor, Color selectorColor) {
        this.id = id;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
        this.selectorColor = selectorColor;
    }
}
