package com.findzach.api.domain;

import com.findzach.api.domain.role.UserRole;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * TODO: Add more annotations to these - Will have checks on FrontEnd
     */
    private String username;
    private String password;
    private String email;

    private String token;

    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Tutorial> tutorials;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.UNVERIFIED;
}
