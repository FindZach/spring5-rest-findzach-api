package com.findzach.api.v1.mapper;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import org.mapstruct.factory.Mappers;

/**
 * @author Zach <zach@findzach.com>
 * @since 10/2/2022
 */
public interface ConvertMapper<DTO, POJO> {

    DTO pojoToDTO(POJO pojo);

    POJO DTOtoPojo(DTO dto);
}
