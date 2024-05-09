package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Data
public class EventEdit {
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private ZonedDateTime beginDateTime;
    @NonNull
    private ZonedDateTime endDateTime;
}
