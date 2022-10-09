package com.findzach.api.service.impl;

import com.findzach.api.domain.Quote;
import com.findzach.api.repository.QuoteRepository;
import com.findzach.api.service.QuoteService;
import com.findzach.api.v1.mapper.QuoteMapper;
import com.findzach.api.v1.mapper.TutorialMapper;
import com.findzach.api.v1.model.quote.QuoteDTO;
import com.findzach.api.v1.model.tutorial.TutorialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    private QuoteMapper quoteMapper;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository, QuoteMapper quoteMapper) {
        this.quoteRepository = quoteRepository;
        this.quoteMapper = quoteMapper;
    }

    @Override
    public List<QuoteDTO> getAll() {
        return quoteRepository.findAll()
                .stream()
                .map(quote -> {
                    QuoteDTO quoteDTO = quoteMapper.pojoToDTO(quote);
                    return quoteDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public QuoteDTO transferToDTO(Quote quote) {
        return quoteMapper.pojoToDTO(quote);
    }

    @Override
    public QuoteDTO getPojoById(Long id) {
        //TODO: Should add null check - We will assume its a valid ID being passed for now...
        return quoteMapper.pojoToDTO(quoteRepository.findById(id).get());
    }

    @Override
    public QuoteDTO create(QuoteDTO quoteDTO) {
        Quote newQuote = quoteMapper.DTOtoPojo(quoteDTO);

        System.out.println("Saving new Quote " + newQuote.getQuote());

        return quoteMapper.pojoToDTO(quoteRepository.save(newQuote));
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
    public QuoteDTO getRandomQuote() {
        Random randomizer = new Random();

        List<QuoteDTO> quoteList = getAll();

        return quoteList
                .get(randomizer.nextInt(quoteList.size()));
    }

    @Override
    public <S extends Quote> S save(S s) {
        return quoteRepository.save(s);
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
