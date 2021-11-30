package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.RateDto;
import edu.keepeasy.moviemark.mapper.RateMapper;
import edu.keepeasy.moviemark.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateService implements EntityService<RateDto, Long> {
    private final RateMapper mapper = RateMapper.INSTANCE;
    private final RateRepository repository;

    @Autowired
    public RateService(RateRepository repository) {
        this.repository = repository;
    }

    @Override
    public RateDto save(RateDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public RateDto findById(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public RateDto updateById(RateDto dto) {
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
