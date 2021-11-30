package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.MovieDto;
import edu.keepeasy.moviemark.mapper.MovieMapper;
import edu.keepeasy.moviemark.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements EntityService<MovieDto, Long> {
    private final MovieMapper mapper = MovieMapper.INSTANCE;
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    @Override
    public MovieDto save(MovieDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public MovieDto findById(Long id) {
        return mapper.toDto(
                repository.getById(id)
        );
    }

    @Override
    public MovieDto updateById(MovieDto dto) {
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

    public List<MovieDto> findByName(String name) {
        return repository
                .findAllByNameContains(name)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
