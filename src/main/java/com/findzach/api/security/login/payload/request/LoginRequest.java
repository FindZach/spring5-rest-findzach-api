package com.findzach.api.security.login.payload.request;

import javax.validation.constraints.NotBlank;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/25/2022
 */
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
