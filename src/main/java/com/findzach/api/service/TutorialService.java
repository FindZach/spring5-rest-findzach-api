package com.findzach.api.service;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.v1.model.UserDTO;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Zach <zach@findzach.com>
 * @since 5/7/2021
 */
public interface TutorialService extends CrudRepository<Tutorial, Long> {

    Tutorial getTutorialBySlug(String slug);


    List<TutorialDTO> getAllTutorials();


    TutorialDTO transferToTutorial(Tutorial tutorial);
    TutorialDTO getTutorialById(Long id);

    TutorialDTO createTutorial(TutorialDTO tutorialDTO);

    TutorialDTO saveTutorialByDTO(Long id, TutorialDTO tutorialDTO);

    TutorialDTO patchTutorial(Long id, TutorialDTO tutorialDTO);

}
