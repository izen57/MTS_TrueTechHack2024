package org.glabs.accessibility.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaRepositoryDeleteMethod<T, ID> extends JpaRepository<T, ID> {
    int deleteByID(ID id);
}
