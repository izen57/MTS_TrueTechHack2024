package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
public class UserOut {
    @NonNull
    private UUID id;
    @NonNull
    private String username;
    @NonNull
    private List<Comment> comments;
    @NonNull
    private UserPreference preference;
    @NonNull
    private CustomUserDetails credentials;

    public UserOut() {
    }

    public UserOut(UUID id, String username) {
        this.id = id;
        this.username = username;
        comments = new LinkedList<>();
        preference = new UserPreference();
        credentials = new CustomUserDetails();
    }

    public UserOut(UUID id, String username, UserPreference preference, CustomUserDetails customUserDetails) {
        this.id = id;
        this.username = username;
        comments = new LinkedList<>();
        this.preference = preference;
        this.credentials = customUserDetails;
    }

    public UserOut(UUID id, String username, List<Comment> comments, UserPreference preference, CustomUserDetails customUserDetails) {
        this.id = id;
        this.username = username;
        this.comments = comments;
        this.preference = preference;
        this.credentials = customUserDetails;
    }
}
