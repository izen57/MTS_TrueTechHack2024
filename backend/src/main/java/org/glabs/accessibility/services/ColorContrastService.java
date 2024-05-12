package org.glabs.accessibility.services;

import org.glabs.accessibility.domain.IContrastCheckable;
import org.glabs.accessibility.domain.RGBAContrast;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.RGBColor;

@Service
public class ColorContrastService {
    private final float normalAA = 4.5f;
    private final float largeAA = 3f;
    private final float normalAAA = 7f;
    private final float largeAAA = 4.5f;
    private IContrastCheckable rgbaColorsCheck;

    public ColorContrastService() {
        rgbaColorsCheck = new RGBAContrast();
    }

    public ColorContrastService(RGBColor c1, RGBColor c2) {
        rgbaColorsCheck = new RGBAContrast(c1, c2);
    }

    public ColorContrastService(RGBColor c1, char a1, RGBColor c2, char a2) {
        rgbaColorsCheck = new RGBAContrast(c1, a1, c2, a2);
    }

    public void replaceColorsRGB(RGBColor c1, RGBColor c2) {
        rgbaColorsCheck = new RGBAContrast(c1, c2);
    }

    public void replaceColorsRGB(RGBColor c1, char a1, RGBColor c2, char a2) {
        rgbaColorsCheck = new RGBAContrast(c1, a1, c2, a2);
    }

    public boolean normalTextAAContrastCheck() {
        float contrast = rgbaColorsCheck.calculateContrast();
        return contrast > normalAA;
    }

    public boolean normalTextAAAContrastCheck() {
        float contrast = rgbaColorsCheck.calculateContrast();
        return contrast > normalAAA;
    }

    public boolean largeTextAAContrastCheck() {
        float contrast = rgbaColorsCheck.calculateContrast();
        return contrast > largeAA;
    }

    public boolean largeTextAAAContrastCheck() {
        float contrast = rgbaColorsCheck.calculateContrast();
        return contrast > largeAAA;
    }
}
