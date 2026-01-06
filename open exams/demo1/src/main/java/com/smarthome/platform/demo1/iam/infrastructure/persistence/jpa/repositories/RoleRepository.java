package com.smarthome.platform.demo1.iam.infrastructure.persistence.jpa.repositories;

import com.smarthome.platform.demo1.iam.domain.model.entities.Role;
import com.smarthome.platform.demo1.iam.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the Role entity related operations.
 * It extends the JpaRepository interface.
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    /**
     * This method is responsible for finding the role by name.
     * @param name The role name.
     * @return The role object.
     */
    Optional<Role> findByName(Roles name);

    /**
     * This method is responsible for checking if the role exists by name.
     * @param name The role name.
     * @return True if the role exists, false otherwise.
     */
    boolean existsByName(Roles name);
}
