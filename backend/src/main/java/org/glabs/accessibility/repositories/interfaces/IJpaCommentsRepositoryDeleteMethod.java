package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.repositories.data.CommentDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IJpaCommentsRepositoryDeleteMethod extends JpaRepository<CommentDB, UUID> {
    int deleteByID(UUID id);
}
