package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.repositories.data.UserPreferenceDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPreferenceJpaRepository extends JpaRepository<UserPreferenceDB, UUID> {
}
