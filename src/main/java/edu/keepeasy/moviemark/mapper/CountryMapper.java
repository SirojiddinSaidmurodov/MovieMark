package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.CountryDto;
import edu.keepeasy.moviemark.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDto toDto(Country country);

    Country toEntity(CountryDto dto);
}
