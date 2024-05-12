package org.glabs.accessibility.domain;

import lombok.Data;
import org.w3c.dom.css.RGBColor;

@Data
public class RGBAContrast implements IContrastCheckable {
    final char fullyOpaque = 255;
    final float rCoeff = 0.2126f;
    final float gCoeff = 0.7152f;
    final float bCoeff = 0.0722f;
    final float additive = 0.05f;
    final float standardContrast = 4.5f;
    private RGBColor color1;
    private RGBColor color2;
    private char alpha1;
    private char alpha2;

    public RGBAContrast() {
    }

    public RGBAContrast(RGBColor c1, RGBColor c2) {
        alpha1 = fullyOpaque;
        alpha2 = fullyOpaque;
        color1 = c1;
        color2 = c2;
    }

    public RGBAContrast(RGBColor c1, char a1, RGBColor c2, char a2) {
        alpha1 = a1;
        alpha2 = a2;
        color1 = c1;
        color2 = c2;
    }

    @Override
    public boolean evaluateContrast(float contrastStandard, float contrast) {
        return contrast > contrastStandard;
    }

    @Override
    public float calculateContrast() {
        float luminance1 = 0;
        float luminance2 = 0;
        float result = 0;
        if (alpha1 == fullyOpaque) {
            luminance1 = calculateLuminance(color1);
        } else {
            luminance1 = calculateLuminance(color1, alpha1);
        }
        if (alpha2 == fullyOpaque) {
            luminance2 = calculateLuminance(color2);
        } else {
            luminance2 = calculateLuminance(color2, alpha2);
        }

        if (compareLuminance(luminance1, luminance2)) {
            result = (luminance1 + additive) / (luminance2 + additive);
        } else {
            result = (luminance2 + additive) / (luminance1 + additive);
        }
        return result;
    }

    private float calculateLuminance(RGBColor c, char a) {
        int alphaNormalized = a / 255;
        return (rCoeff * c.getGreen().getCssValueType() + //
                gCoeff * c.getGreen().getCssValueType() + //
                bCoeff * c.getBlue().getCssValueType()) * alphaNormalized;
    }

    private float calculateLuminance(RGBColor c) {
        return rCoeff * c.getGreen().getCssValueType() + //
                gCoeff * c.getGreen().getCssValueType() + //
                bCoeff * c.getBlue().getCssValueType();
    }

    private boolean compareLuminance(float l1, float l2) {
        return l1 > l2;
    }
}
