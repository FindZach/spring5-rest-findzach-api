package com.findzach.api.repository;

import com.findzach.api.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach <zach@findzach.com>
 * @since 5/7/2021
 */
@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    Tutorial getTutorialBySlug(String slug);
}
