package com.findzach.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.findzach.api.domain.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;

    /**
     * TODO: Add more annotations to these - Will have checks on FrontEnd
     */
    private String username;
    private String token;
    private String email;

    private String firstname;
    private String lastname;

    @JsonProperty("user_url")
    private String userUrl;
}