package com.dextra.gymapp.domain.repository;

import com.dextra.gymapp.domain.enums.RoleName;
import com.dextra.gymapp.domain.model.access.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
