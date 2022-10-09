package com.findzach.api.v1.model.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDTO {

    private long id;

    private String quote;
    private String author;

}
