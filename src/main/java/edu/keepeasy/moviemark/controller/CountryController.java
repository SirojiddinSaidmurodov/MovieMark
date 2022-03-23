package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.dto.CountryDto;
import org.springframework.http.ResponseEntity;

public class CountryController implements EntityController<CountryDto, Long> {
    @Override
    public ResponseEntity<CountryDto> save(CountryDto countryDto) {
        return null;
    }

    @Override
    public ResponseEntity<CountryDto> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<CountryDto> edit(Long aLong, CountryDto countryDto) {
        return null;
    }
}
