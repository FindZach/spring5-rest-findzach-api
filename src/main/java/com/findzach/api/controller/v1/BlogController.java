package com.findzach.api.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 */
@RestController
@RequestMapping("api/blog")
public class BlogController {


    @GetMapping("/posts/{slug}")
    public void getBlogFromSlug(@PathVariable String slug) {

    }

}
