package org.glabs.accessibility.repositories.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EventDB {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private ZonedDateTime beginZonedDateTime;
    @NotNull
    private ZonedDateTime endZonedDateTime;

    @OneToMany(mappedBy = "event", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private List<EventConstraintDB> constraintDBList;
}
