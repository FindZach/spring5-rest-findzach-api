package com.findzach.api.v1.mapper;

import com.findzach.api.domain.Quote;
import com.findzach.api.v1.model.quote.QuoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Zach <zach@findzach.com>
 * @since 10/2/2022
 */
@Mapper
public interface QuoteMapper extends ConvertMapper<QuoteDTO, Quote> {
    QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);
}
