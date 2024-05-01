package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
public class User {
    @NonNull private UUID id;
    @NonNull private String username;
    @NonNull private List<Comment> comments = new LinkedList<>();
    @NonNull private UserPreference preference;
    @NonNull private CustomUserDetails credentials;
}
