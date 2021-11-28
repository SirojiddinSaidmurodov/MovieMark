package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.ActorDto;
import edu.keepeasy.moviemark.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorDto toDto(Actor actor);

    Actor toEntity(ActorDto dto);
}
