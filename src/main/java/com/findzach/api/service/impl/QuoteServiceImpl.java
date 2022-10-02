package com.findzach.api.service.impl;

import com.findzach.api.domain.Quote;
import com.findzach.api.service.QuoteService;
import com.findzach.api.v1.model.quote.QuoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    @Override
    public List<QuoteDTO> getAll() {
        return null;
    }

    @Override
    public QuoteDTO transferToDTO(Quote quote) {
        return null;
    }

    @Override
    public QuoteDTO getPojoById(Long id) {
        return null;
    }

    @Override
    public QuoteDTO create(QuoteDTO quoteDTO) {
        return null;
    }

    @Override
    public QuoteDTO save(Long id, QuoteDTO quoteDTO) {
        return null;
    }

    @Override
    public QuoteDTO update(Long id, QuoteDTO quoteDTO) {
        return null;
    }

    @Override
    public Quote getRandomQuote() {
        return null;
    }

    @Override
    public <S extends Quote> S save(S s) {
        return null;
    }

    @Override
    public <S extends Quote> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Quote> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Quote> findAll() {
        return null;
    }

    @Override
    public Iterable<Quote> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Quote quote) {

    }

    @Override
    public void deleteAll(Iterable<? extends Quote> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
