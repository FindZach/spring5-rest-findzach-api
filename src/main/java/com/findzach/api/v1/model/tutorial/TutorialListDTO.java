package com.findzach.api.v1.model.tutorial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialListDTO {

    List<TutorialDTO> tutorials;

}
