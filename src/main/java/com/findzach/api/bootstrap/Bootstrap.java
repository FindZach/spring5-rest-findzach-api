package com.findzach.api.bootstrap;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.domain.User;
import com.findzach.api.repository.TutorialRepository;
import com.findzach.api.repository.UserRepository;
import com.findzach.api.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TutorialRepository tutorialRepository;

    @Autowired
    public Bootstrap(UserRepository userRepository, TutorialRepository tutorialRepository) {
        this.userRepository = userRepository;
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

        User zach = new User();
        zach.setId(1L);
        zach.setFirstname("Zachary");
        zach.setLastname("Smith");
        zach.setEmail("zach@findzach.com");
        zach.setUsername("Zach");
        zach.setToken("findzach");
        userRepository.save(zach);

        Tutorial newTutorial = new Tutorial();

        newTutorial.setTitle("How to link hibernate to MySQL");
        newTutorial.setDescription("We have a description here");
        newTutorial.setContent("<h2>Hello World!</h2>");
        newTutorial.setSlug("link-hibernate-mysql-2022");
        newTutorial.setUser(zach);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        newTutorial.setCreationDate(formatter.format(new Date()));
        tutorialRepository.save(newTutorial);

        log.info("Bootstrap initialized");
    }
}