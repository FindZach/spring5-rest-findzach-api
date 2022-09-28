package com.findzach.api.bootstrap;

import com.findzach.api.security.login.controller.AuthController;
import com.findzach.api.security.login.model.ERole;
import com.findzach.api.security.login.model.Role;
import com.findzach.api.security.login.model.User;
import com.findzach.api.security.login.repository.RoleRepository;
import com.findzach.api.security.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/25/2022
 *
 * Auth Boostrap Data
 */
@Slf4j
public class AuthBootstrap implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder encoder;

    @Autowired
    public AuthBootstrap(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Loading Authentication Bootstrap.");

        Role userRole = new Role();
        Role modRole = new Role();
        Role adminRole = new Role();

        userRole.setName(ERole.ROLE_USER);
        modRole.setName(ERole.ROLE_MODERATOR);
        adminRole.setName(ERole.ROLE_ADMIN);

        roleRepository.save(userRole);
        roleRepository.save(modRole);
        roleRepository.save(adminRole);

        User zach = new User();
        User noah = new User();
        User shea = new User();

        zach.setUsername("Zach");
        noah.setUsername("Noah");
        shea.setUsername("Shea");

        zach.setEmail("zach@findzach.com");
        noah.setEmail("noah@findzach.com");
        shea.setEmail("shea@findzach.com");

        zach.setPassword(encoder.encode("passwords"));
        noah.setPassword(encoder.encode("passwords"));
        shea.setPassword(encoder.encode("passwords"));

        zach.setRoles(Set.of(adminRole, userRole));
        noah.setRoles(Set.of(modRole, userRole));
        shea.setRoles(Set.of(userRole, modRole));

        userRepository.save(zach);
        userRepository.save(noah);
        userRepository.save(shea);

        log.info("Loaded Authentication Bootstrap.");


    }
}
