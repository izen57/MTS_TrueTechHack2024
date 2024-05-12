package org.glabs.accessibility.repositories.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EventConstraintDB {
    @Id
    @Column(unique = true)
    private String name;

    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private EventDB event;
}
