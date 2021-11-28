package edu.keepeasy.moviemark.mapper;

import edu.keepeasy.moviemark.dto.ArtistDto;
import edu.keepeasy.moviemark.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    ArtistDto toDto(Artist artist);

    Artist toEntity(ArtistDto dto);

}
