package com.findzach.api.security.login.repository;

import java.util.Optional;

import com.findzach.api.security.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/25/2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
