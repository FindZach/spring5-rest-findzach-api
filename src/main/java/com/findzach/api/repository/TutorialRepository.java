package com.findzach.api.repository;

import com.findzach.api.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zach <zach@findzach.com>
 * @since 5/7/2021
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
