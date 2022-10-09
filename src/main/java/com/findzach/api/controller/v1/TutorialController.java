package com.findzach.api.controller.v1;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.service.TutorialService;
import com.findzach.api.v1.mapper.TutorialMapper;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true", allowedHeaders = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,
                RequestMethod.DELETE, RequestMethod.PUT,
                RequestMethod.PATCH, RequestMethod.OPTIONS,
                RequestMethod.HEAD, RequestMethod.TRACE})
@RequestMapping("api")
public class TutorialController {

    private TutorialService tutorialService;
    private TutorialMapper tutorialMapper;

    @Autowired
    public TutorialController(TutorialService tutorialService, TutorialMapper tutorialMapper) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tutorials/all")
    public ResponseEntity<List<TutorialDTO>> getAllTutorials() {
        return ResponseEntity.ok(tutorialService.getAll());
    }

    @PutMapping("/tutorial/{slug}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TutorialDTO> updateTutorial(@PathVariable String slug, @RequestBody TutorialDTO tutorialDTO) {

        String currentSlug = slug;
        String newSlug = tutorialDTO.getSlug();

        log.info("Updated tutorial! " + slug);
        log.info("Updated tutorial! " + tutorialDTO.getTitle());
        log.info("Updated tutorial! " + tutorialDTO.getSlug());

        Tutorial tutorial = tutorialService.getTutorialBySlug(currentSlug);
        if (tutorial != null) {
            long id = tutorial.getId();

            log.info("Found tutorial: " + id);

            TutorialDTO updatedDTO = tutorialService.update(id, tutorialDTO);
            if (updatedDTO != null) {
                log.info("TutorialDTO updated!");
            }
            return ResponseEntity.ok().body(updatedDTO);
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tutorial/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TutorialDTO> deleteTutorial(@PathVariable long id) {

        if (tutorialService.findById(id).isPresent()) {
            tutorialService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @GetMapping("/tutorial/{slug}")
    public ResponseEntity<TutorialDTO> getTutorialBySlug(@PathVariable String slug) {
        log.info("Slug read: " + slug);

        Optional<Tutorial> possibleTutorial = Optional.ofNullable(tutorialService.getTutorialBySlug(slug));

        if (possibleTutorial.isPresent()) {
            log.info("Found " + possibleTutorial.get().getTitle());
        } else {
            log.info("Unable to find tutorial by the slug");
        }


        TutorialDTO newTut = new TutorialDTO();
        newTut.setSlug(slug);
        newTut.setTitle(possibleTutorial.get().getTitle());
        newTut.setDescription(possibleTutorial.get().getDescription());
        newTut.setContent(possibleTutorial.get().getContent());
        //newTut.setUse(String.valueOf(possibleTutorial.get().getUser().getId()));
        newTut.setCreationDate(possibleTutorial.get().getCreationDate());
        newTut.setTags(possibleTutorial.get().getTags());
        newTut.setThumbnailImageUrl(possibleTutorial.get().getThumbnailImageUrl());

        return ResponseEntity.ok().body(newTut);
    }

    @PostMapping("/tutorial/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TutorialDTO> submitTutorial(@RequestBody TutorialDTO tutorialDTO) {

        if (tutorialService.getTutorialBySlug(tutorialDTO.getSlug()) == null) {
            log.info("Tutorial Submitted: " + tutorialDTO.getTitle());
            return ResponseEntity.ok(tutorialService.create(tutorialDTO));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

}
