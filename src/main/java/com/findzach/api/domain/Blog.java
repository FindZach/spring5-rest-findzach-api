package com.findzach.api.domain;

import com.findzach.api.domain.addon.Metadata;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 */
@Entity
@Table(name = "blogs")
@Data
public class Blog implements Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String date;

    private String[] tags;
    private String metadataContent;


    @Override
    public List<String> getTags() {
        return Arrays.asList(tags);
    }

    @Override
    public void setTags(String... tags) {
        this.tags = tags;
    }

    @Override
    public void setContentDescription(String description) {
        this.metadataContent = description;
    }

    @Override
    public String getContentDescription() {
        return this.metadataContent;
    }
}
