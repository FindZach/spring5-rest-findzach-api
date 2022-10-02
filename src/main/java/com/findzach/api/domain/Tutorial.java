package com.findzach.api.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Entity
@Table(name = "tutorials")
@Data
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String slug;
    private String description;

    @Column(length = 100000)
    private String content;
    private String creationDate;
    private String tags;

    @Column(length = 250000)
    private String thumbnailImageUrl;
}
