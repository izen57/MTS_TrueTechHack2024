package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.repositories.data.EventDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IJpaEventsDBRepositoryExtension extends JpaRepository<EventDB, UUID> {
    int deleteByID(UUID id);
}
