package com.findzach.api.service.impl;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.repository.TutorialRepository;
import com.findzach.api.service.TutorialService;
import com.findzach.api.v1.mapper.TutorialMapper;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Slf4j
@Service
public class TutorialServiceImpl implements TutorialService {

    private TutorialRepository tutorialRepository;

    private TutorialMapper tutorialMapper;

    @Autowired
    public TutorialServiceImpl(TutorialRepository tutorialRepository, TutorialMapper tutorialMapper) {
        this.tutorialRepository = tutorialRepository;
        this.tutorialMapper = tutorialMapper;
    }

    @Override
    public <S extends Tutorial> S save(S s) {
        return tutorialRepository.save(s);
    }

    @Override
    public <S extends Tutorial> Iterable<S> saveAll(Iterable<S> iterable) {
        return tutorialRepository.saveAll(iterable);
    }

    @Override
    public Optional<Tutorial> findById(Long aLong) {
        return tutorialRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return tutorialRepository.existsById(aLong);
    }

    @Override
    public Iterable<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public Iterable<Tutorial> findAllById(Iterable<Long> iterable) {
        return tutorialRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return tutorialRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
            tutorialRepository.deleteById(aLong);
    }

    @Override
    public void delete(Tutorial tutorial) {
        tutorialRepository.delete(tutorial);
    }

    @Override
    public void deleteAll(Iterable<? extends Tutorial> iterable) {
        tutorialRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    @Override
    public Tutorial getTutorialBySlug(String slug) {
        return tutorialRepository.getTutorialBySlug(slug);
    }

    @Override
    public List<TutorialDTO> getAll() {
        return tutorialRepository.findAll()
                .stream()
                .map(tutorial -> {
                    TutorialDTO tutorialDTO = tutorialMapper.pojoToDTO(tutorial);
                    return tutorialDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * Takes Tutorial Object and Maps it to DTO
     * @param tutorial - The tutorial to map to DTO
     * @return - {@link TutorialDTO}
     */
    @Override
    public TutorialDTO transferToDTO(Tutorial tutorial) {
        return tutorialMapper.pojoToDTO(tutorial);
    }

    @Override
    public TutorialDTO getPojoById(Long id) {
        return null;
    }

    @Override
    public TutorialDTO create(TutorialDTO tutorialDTO) {

        log.info("Tutorial Content: " + tutorialDTO.getContent());

        Tutorial tutorial = tutorialMapper.DTOtoPojo(tutorialDTO);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        tutorial.setCreationDate(formatter.format(date));

        tutorialRepository.save(tutorial);

        TutorialDTO updatedDTO = tutorialMapper.pojoToDTO(tutorial);

        return updatedDTO;
    }

    @Override
    public TutorialDTO save(Long id, TutorialDTO tutorialDTO) {
        Tutorial updatedTutorial = tutorialMapper.DTOtoPojo(tutorialDTO);
        TutorialDTO tutorialDTOUpdated = tutorialMapper.pojoToDTO(tutorialRepository.save(updatedTutorial));
        return tutorialDTOUpdated;
    }

    @Override
    public TutorialDTO update(Long id, TutorialDTO tutorialDTO) {

        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);

        if (tutorialOptional.isPresent()) {

            Tutorial updatedTutorial = tutorialOptional.get();

            updatedTutorial.setSlug(tutorialDTO.getSlug());
            updatedTutorial.setTitle(tutorialDTO.getTitle());
            updatedTutorial.setContent(tutorialDTO.getContent());
            updatedTutorial.setDescription(tutorialDTO.getDescription());
            updatedTutorial.setTags(tutorialDTO.getTags());
            updatedTutorial.setThumbnailImageUrl(tutorialDTO.getThumbnailImageUrl());

            tutorialRepository.save(updatedTutorial);

            TutorialDTO updatedTutorialDTO = tutorialMapper.pojoToDTO(updatedTutorial);

            return updatedTutorialDTO;
        } else {
            return null;
        }
    }

}
