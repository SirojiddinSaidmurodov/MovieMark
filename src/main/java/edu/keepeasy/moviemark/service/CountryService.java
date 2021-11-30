package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.CountryDto;
import edu.keepeasy.moviemark.mapper.CountryMapper;
import edu.keepeasy.moviemark.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements EntityService<CountryDto, Long> {
    private final CountryMapper mapper = CountryMapper.INSTANCE;
    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CountryDto save(CountryDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public CountryDto findById(Long id) {
        return mapper.toDto(
                repository.getById(id)
        );
    }

    @Override
    public CountryDto updateById(CountryDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isPresent(Long id) {
        return repository.existsById(id);
    }
}
