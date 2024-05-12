package org.glabs.accessibility.controllers.dto;

import lombok.Builder;
import lombok.Data;
import org.w3c.dom.css.RGBColor;

@Data
@Builder
public class ContrastControllerDTO {
    RGBColor c1;
    RGBColor c2;
    char alpha1;
    char alpha2;
    boolean AANormal;
    boolean AAANormal;
    boolean AALarge;
    boolean AAALarge;
}
