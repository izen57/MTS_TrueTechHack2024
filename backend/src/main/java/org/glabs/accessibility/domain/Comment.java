package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class Comment {
    @NonNull private UUID id;
    @NonNull private User user;
    @NonNull private String text;
    @NonNull private ZonedDateTime zonedDateTime;
}
