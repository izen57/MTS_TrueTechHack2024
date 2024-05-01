package org.glabs.accessibility.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class User {
    @NotNull private UUID id;
    @NotNull private String username;
}
