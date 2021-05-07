package com.findzach.api.repository;

import com.findzach.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}