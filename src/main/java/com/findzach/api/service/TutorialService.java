package com.findzach.api.service;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Zach <zach@findzach.com>
 * @since 5/7/2021
 */
public interface TutorialService extends CrudRepository<Tutorial, Long>, DTOService<TutorialDTO, Tutorial> {

    Tutorial getTutorialBySlug(String slug);
}
