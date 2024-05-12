package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class Event {
    @NonNull
    private UUID id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private ZonedDateTime beginDateTime;
    @NonNull
    private ZonedDateTime endDateTime;
}
