package com.findzach.api.domain.addon;

import java.util.List;

/**
 * @author Zach <zach@findzach.com>
 * @since 10/2/2022
 */
public interface Metadata {

    /**
     * Tags to reference the parent data
     */
    List<String> getTags();
    void setTags(String... tags);

    /**
     * Will be put in the HTML Header for SEO
     */
    void setContentDescription(String description);
    String getContentDescription();
}
