package org.glabs.accessibility.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class UserIn {
    @NonNull private UUID id;
    @NonNull private String username;
}
