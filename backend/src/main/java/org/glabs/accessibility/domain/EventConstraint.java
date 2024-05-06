package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Data
public class EventConstraint {
    @NonNull private String name;
    @NonNull private String description;
    @NonNull private Event event;
    @NonNull private ZonedDateTime beginZonedDateTime;
    @NonNull private ZonedDateTime endZonedDateTime;
}
