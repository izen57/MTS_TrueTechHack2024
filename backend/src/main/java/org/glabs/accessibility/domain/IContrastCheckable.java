package org.glabs.accessibility.domain;

public interface IContrastCheckable {
    boolean evaluateContrast(float contrastStandard, float contrast);

    float calculateContrast();
}