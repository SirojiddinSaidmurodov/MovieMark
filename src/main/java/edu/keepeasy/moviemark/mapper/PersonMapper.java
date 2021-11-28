package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.PersonDto;
import edu.keepeasy.moviemark.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target = "birthDate", source = "person.birthDate")
    })
    PersonDto toDto(Person person);

    @Mappings({
            @Mapping(target = "birthDate", source = "dto.birthDate")
    })
    Person toEntity(PersonDto dto);
}
