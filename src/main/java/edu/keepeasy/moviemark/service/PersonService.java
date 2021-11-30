package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.PersonDto;
import edu.keepeasy.moviemark.mapper.PersonMapper;
import edu.keepeasy.moviemark.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PersonService implements EntityService<PersonDto, Long> {
    private final PersonMapper mapper = PersonMapper.INSTANCE;
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDto save(PersonDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)));
    }

    @Override
    public PersonDto findById(Long id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Not found Person with id " + id)));
    }

    @Override
    public PersonDto updateById(PersonDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public boolean isPresent(Long id) {
        return repository.findById(id).isPresent();
    }

}
