package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Data
public class CommentEdit {
    @NonNull private User user;
    @NonNull private String text;
    @NonNull private ZonedDateTime zonedDateTime;
}
