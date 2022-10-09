package com.findzach.api.controller.v1;

import com.findzach.api.service.QuoteService;
import com.findzach.api.v1.model.quote.QuoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 *
 * Simple, and fun way to add quotes, retrieve random quotes, we will let users submit quotes
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true", allowedHeaders = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,
                RequestMethod.DELETE, RequestMethod.PUT,
                RequestMethod.PATCH, RequestMethod.OPTIONS,
                RequestMethod.HEAD, RequestMethod.TRACE})
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
    @GetMapping("/random")
    public QuoteDTO getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<QuoteDTO> submitQuote(@RequestBody QuoteDTO quoteDTO) {

        if (quoteDTO != null) {

            System.out.println("Creating Quote!");
            System.out.println("Quote: " + quoteDTO.getQuote());
            System.out.println("Author:" + quoteDTO.getAuthor());



            return ResponseEntity.ok(quoteService.create(quoteDTO));

        } else return ResponseEntity.badRequest().build();
    }
}
