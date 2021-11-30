package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.ArtistDto;
import edu.keepeasy.moviemark.mapper.ArtistMapper;
import edu.keepeasy.moviemark.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService implements EntityService<ArtistDto, Long> {

    private final ArtistMapper mapper = ArtistMapper.INSTANCE;
    private final ArtistRepository repository;

    @Autowired
    public ArtistService(ArtistRepository repository) {
        this.repository = repository;
    }


    @Override
    public ArtistDto save(ArtistDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public ArtistDto findById(Long id) {
        return mapper.toDto(
                repository.getById(id)
        );
    }

    @Override
    public ArtistDto updateById(ArtistDto dto) {
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
