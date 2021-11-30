package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.ActorDto;

public class ActorService implements EntityService<ActorDto, Long> {
    @Override
    public ActorDto save(ActorDto dto) {
        return null;
    }

    @Override
    public ActorDto findById(Long id) {
        return null;
    }

    @Override
    public ActorDto updateById(ActorDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean isPresent(Long id) {
        return false;
    }
}
