package com.findzach.api.controller.v1;

import com.findzach.api.domain.Quote;
import com.findzach.api.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 *
 * Simple, and fun way to add quotes, retrieve random quotes, we will let users submit quotes
 */

@RestController
@RequestMapping("api/quote/")
public class QuoteController {

    private QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    /**
     * Request for a random quote
     * @return - A random quote in JSON format
     */
    @GetMapping("random")
    public Quote getRandomQuote() {
        return new Quote();
    }
}
