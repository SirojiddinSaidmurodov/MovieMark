package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.UserDto;
import edu.keepeasy.moviemark.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
