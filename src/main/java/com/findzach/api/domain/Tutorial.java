package com.findzach.api.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
