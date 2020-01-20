package com.dextra.gymapp.domain.repository;

import com.dextra.gymapp.domain.enums.EntityName;
import com.dextra.gymapp.domain.model.access.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntityRepository extends JpaRepository<Entity, Long> {
    Optional<Entity> findByName(EntityName entityName);
}
