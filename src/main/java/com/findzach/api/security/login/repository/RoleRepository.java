package com.findzach.api.security.login.repository;

import com.findzach.api.security.login.model.ERole;
import com.findzach.api.security.login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/25/2022
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
