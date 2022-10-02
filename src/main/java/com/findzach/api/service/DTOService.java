package com.findzach.api.service;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.v1.model.tutorial.TutorialDTO;

import java.util.List;

/**
 * @author Zach <zach@findzach.com>
 * @since 10/2/2022
 */
public interface DTOService<DTO, POJO> {


    List<DTO> getAll();

    DTO transferToDTO(POJO pojo);
    DTO getPojoById(Long id);

    DTO create(DTO dto);

    DTO save(Long id, DTO dto);

    DTO update(Long id, DTO dto);
}
