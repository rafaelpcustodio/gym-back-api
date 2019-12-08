package com.dextra.spending.configuration.security.user.repository;

import com.dextra.spending.configuration.security.user.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
    ApplicationUser findByEmail(String email);
    boolean existsUsersByEmail(String email);
}
