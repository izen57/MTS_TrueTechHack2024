package org.glabs.accessibility.repositories.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
public class EventConstraintDB {
    @Id
    @Column(unique = true)
    private String name;

    @NotNull private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private EventDB event;

    @NotNull private ZonedDateTime beginZonedDateTime;
    @NotNull private ZonedDateTime endZonedDateTime;
}
