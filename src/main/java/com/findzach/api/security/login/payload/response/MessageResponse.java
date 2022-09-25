package com.findzach.api.security.login.payload.response;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/25/2022
 */
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
