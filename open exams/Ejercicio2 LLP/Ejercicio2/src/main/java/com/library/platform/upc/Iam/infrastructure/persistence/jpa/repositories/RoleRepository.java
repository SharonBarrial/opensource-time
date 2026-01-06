package com.library.platform.upc.Iam.infrastructure.persistence.jpa.repositories;

import com.library.platform.upc.Iam.domain.model.entities.Role;
import com.library.platform.upc.Iam.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
    boolean existsByName(Roles name);
}
