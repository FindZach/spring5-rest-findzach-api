package com.findzach.api.repository;

import com.findzach.api.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach S <zach@findzach.com>
 * @since 10/2/2022
 */
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
