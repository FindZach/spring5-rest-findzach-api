package com.findzach.api.v1.mapper;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.domain.User;
import com.findzach.api.v1.model.UserDTO;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/24/2022
 */
@Mapper
public interface TutorialMapper {


    TutorialMapper INSTANCE = Mappers.getMapper(TutorialMapper.class);

    TutorialDTO tutorialToTutorialDTO(Tutorial tutorial);

    Tutorial tutorialDtoToTutorial(TutorialDTO tutorialDTO);

}
