package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.RateDto;
import edu.keepeasy.moviemark.model.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RateMapper {
    RateMapper INSTANCE = Mappers.getMapper(RateMapper.class);

    RateDto toDto(Rate rate);

    Rate toEntity(RateDto dto);

}
