package com.findzach.api.bootstrap;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.domain.UserLegacy;
import com.findzach.api.repository.TutorialRepository;
import com.findzach.api.repository.UserLegacyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Slf4j
public class Bootstrap implements CommandLineRunner {

    private final UserLegacyRepository userLegacyRepository;
    private final TutorialRepository tutorialRepository;

    @Autowired
    public Bootstrap(UserLegacyRepository userLegacyRepository, TutorialRepository tutorialRepository) {
        this.userLegacyRepository = userLegacyRepository;
        this.tutorialRepository = tutorialRepository;
    }

    /**
     * Will be called when application is ran
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("Starting Bootstrap");

        UserLegacy zach = new UserLegacy();
        zach.setId(1L);
        zach.setFirstname("Zachary");
        zach.setLastname("Smith");
        zach.setEmail("zach@findzach.com");
        zach.setUsername("Zach");
        zach.setToken("findzach");
        userLegacyRepository.save(zach);

        Tutorial newTutorial = new Tutorial();

        newTutorial.setTitle("How to link hibernate to MySQL");
        newTutorial.setDescription("We have a description here");
        newTutorial.setContent("<h2>Hello World!</h2>");
        newTutorial.setSlug("link-hibernate-mysql-2022");
        newTutorial.setUserLegacy(zach);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        newTutorial.setCreationDate(formatter.format(new Date()));
        tutorialRepository.save(newTutorial);

        log.info("Bootstrap initialized");
    }
}