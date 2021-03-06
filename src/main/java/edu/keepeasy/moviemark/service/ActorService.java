package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.ActorDto;
import edu.keepeasy.moviemark.mapper.ActorMapper;
import edu.keepeasy.moviemark.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService implements EntityService<ActorDto, Long> {
    private final ActorRepository repository;
    private final ActorMapper mapper = ActorMapper.INSTANCE;

    @Autowired
    public ActorService(ActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActorDto save(ActorDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public ActorDto findById(Long id) {
        return mapper.toDto(
                repository.getById(id)
        );
    }

    @Override
    public ActorDto updateById(ActorDto dto) {
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
        return repository.findById(id).isPresent();
    }
}
