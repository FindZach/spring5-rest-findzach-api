package com.findzach.api.repository;

import com.findzach.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
public interface UserRepository extends JpaRepository<User, Long> {
}