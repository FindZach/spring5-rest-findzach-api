package com.findzach.api.repository;

import com.findzach.api.domain.UserLegacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Repository
public interface UserLegacyRepository extends JpaRepository<UserLegacy, Long> {
}