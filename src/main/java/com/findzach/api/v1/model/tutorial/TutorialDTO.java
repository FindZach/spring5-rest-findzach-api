package com.findzach.api.v1.model.tutorial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDTO {

    private Long id;

    private String title;
    private String slug;
    private String description;
    private String content;

    private String username;
    private String creationDate;

    private String tags;
    private String thumbnailImageUrl;

}
