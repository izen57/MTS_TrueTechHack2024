package org.glabs.accessibility.domain;

public enum AccessibilityFeatureFabric {
    INSTANCE;

    public EventAccessibilityFeature createAccessibiltyFeature(AccessibiltyFeatureName name) {
        EventAccessibilityFeature feature = null;
        switch (name) {
            case BRAIL -> feature = createBrailTextFeature();
            case RAMP -> feature = createWheelChairRampFeature();
            case SURDOINTERPRETOR -> feature = createDeafInterpreterFeature();
            case SUBTITlES -> feature = createSubtitlesFeature();
        }
        return feature;
    }

    private EventAccessibilityFeature createWheelChairRampFeature() {
        return EventAccessibilityFeature.builder()
                .name("WheelChairRamp")
                .description("Helps people with moving disabilities").build();
    }

    private EventAccessibilityFeature createDeafInterpreterFeature() {
        return EventAccessibilityFeature.builder()
                .name("DeafInterpreter")
                .description("Helps deaf people").build();
    }

    private EventAccessibilityFeature createBrailTextFeature() {
        return EventAccessibilityFeature.builder()
                .name("BrailText")
                .description("Helps blind people").build();
    }

    private EventAccessibilityFeature createSubtitlesFeature() {
        return EventAccessibilityFeature.builder()
                .name("Subtitles")
                .description("Helps people with bad hearing and speakers of foreign language").build();
    }
}
