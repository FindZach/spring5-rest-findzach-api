package com.findzach.api.bootstrap;

import com.findzach.api.domain.Tutorial;
import com.findzach.api.domain.User;
import com.findzach.api.repository.TutorialRepository;
import com.findzach.api.repository.UserRepository;
import com.findzach.api.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
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
        System.out.println("Calling bootstrap!");

        User zach = new User();
        zach.setId(1L);
        zach.setFirstname("Zachary");
        zach.setLastname("Smith");
        zach.setEmail("zach@findzach.com");
        zach.setUsername("Zach");
        zach.setToken("findzach");
        userRepository.save(zach);

        System.out.println("Successfully saved Zach to the User Repository");

        Tutorial newTutorial = new Tutorial();

        newTutorial.setTitle("How to link hibernate to MySQL");
        newTutorial.setDescription("We have a description here");
        newTutorial.setTutorialContent("YEEEEE");
        newTutorial.setUser(zach);
        tutorialRepository.save(newTutorial);

        System.out.println("Successfully saved our first Tutorial to the Tutorial Repository");
    }
}