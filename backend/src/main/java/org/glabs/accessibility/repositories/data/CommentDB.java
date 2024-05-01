package org.glabs.accessibility.repositories.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class CommentDB {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDB user;

    @NotNull
    private String text;

    @NotNull
    private ZonedDateTime zonedDateTime;
}
