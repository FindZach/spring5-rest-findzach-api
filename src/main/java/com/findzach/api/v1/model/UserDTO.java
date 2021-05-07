package com.findzach.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String firstname;

    private String lastname;

    @JsonProperty("customer_url")
    private String customerUrl;
}