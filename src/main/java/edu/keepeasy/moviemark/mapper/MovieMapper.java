package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.MovieDto;
import edu.keepeasy.moviemark.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto toDto(Movie movie);
    
    Movie toEntity(MovieDto dto);
}
