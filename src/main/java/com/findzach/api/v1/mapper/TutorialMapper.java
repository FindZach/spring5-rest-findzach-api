package com.findzach.api.v1.mapper;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/24/2022
 */
@Mapper
public interface TutorialMapper extends ConvertMapper<TutorialDTO, Tutorial> {
    TutorialMapper INSTANCE = Mappers.getMapper(TutorialMapper.class);
}
