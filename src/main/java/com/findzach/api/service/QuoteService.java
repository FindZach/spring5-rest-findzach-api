package com.findzach.api.service;

import com.findzach.api.domain.Quote;
import com.findzach.api.v1.model.quote.QuoteDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Zach <zach@findzach.com>
 * @since 10/2/2022
 */
public interface QuoteService extends CrudRepository<Quote, Long>, DTOService<QuoteDTO, Quote> {

    /**
     * Grabs a random quote from the list
     * @return A {@link Quote}
     */
    QuoteDTO getRandomQuote();
}
