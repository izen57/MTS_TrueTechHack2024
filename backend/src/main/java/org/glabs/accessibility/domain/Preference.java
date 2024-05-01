package org.glabs.accessibility.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.w3c.dom.css.RGBColor;

import java.util.UUID;

@Data
public class Preference {
    @NotNull private UUID id;
    @NotNull private int fontSize;
    @NotNull private RGBColor fontColor;
    @NotNull private RGBColor selectorColor;
}
