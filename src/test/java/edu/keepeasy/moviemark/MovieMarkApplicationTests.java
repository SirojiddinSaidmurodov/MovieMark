package edu.keepeasy.moviemark;

import edu.keepeasy.moviemark.dto.*;
import edu.keepeasy.moviemark.mapper.ActorMapper;
import edu.keepeasy.moviemark.mapper.CountryMapper;
import edu.keepeasy.moviemark.mapper.MovieMapper;
import edu.keepeasy.moviemark.mapper.PersonMapper;
import edu.keepeasy.moviemark.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieMarkApplicationTests {
    final static Country usa = new Country(12L, "США");
    final static Person samuelLJackson = new Person(
            12L,
            "Сэмюэл Л. Джексон",
            "Samuel L. Jackson",
            Sex.MAN,
            LocalDate.of(1948, 12, 21),
            "Вашингтон, округ Колумбия, США");
    final static Person jonFavreau = new Person(
            50L,
            "Джон Фавро",
            "Jon Favreau",
            Sex.MAN,
            LocalDate.of(1966, 10, 19),
            "Нью-Йорк, США"
    );
    final static Actor nickFury = new Actor(
            10L,
            "Nick Fury",
            false,
            samuelLJackson
    );
    final static Artist ironManDirector = new Artist(
            423L,
            "Director",
            jonFavreau);
    final static Movie ironMan2 = new Movie(
            124124L,
            "Iron Man 2",
            LocalDate.of(2010, 4, 26),
            Set.of(usa),
            Set.of(ironManDirector),
            Set.of(nickFury),
            200000000L,
            623933331L,
            Duration.ofMinutes(119),
            3.0F
    );

    @Test
    void personMapperTest() {
        PersonDto personDto = PersonMapper.INSTANCE.toDto(samuelLJackson);

        assertEquals(samuelLJackson.getFullName(), personDto.getFullName());
        assertEquals(samuelLJackson.getOriginalName(), personDto.getOriginalName());
        assertEquals(samuelLJackson.getBirthDate(), personDto.getBirthDate());
        assertEquals("MAN", personDto.getSex());
        assertEquals(samuelLJackson.getId(), personDto.getId());
    }

    @Test
    void actorMapperTest() {
        ActorDto actorDto = ActorMapper.INSTANCE.toDto(nickFury);
        assertEquals(samuelLJackson.getFullName(), actorDto.getPerson().getFullName());
    }

    @Test
    void countryMapperTest() {
        CountryDto dto = CountryMapper.INSTANCE.toDto(usa);
        assertEquals(usa.getId(), dto.getId());
        assertEquals(usa.getName(), dto.getName());
    }

    @Test
    void movieMapperTest() {
        MovieDto movieDto = MovieMapper.INSTANCE.toDto(ironMan2);
        assertEquals(
                ironMan2.getCountries().toArray(new Country[0])[0].getName(),
                movieDto.getCountries().toArray(new CountryDto[0])[0].getName());
        assertEquals(ironMan2.getActors().toArray(new Actor[0])[0].getId(),
                movieDto.getActors().toArray(new ActorDto[0])[0].getId());
        assertEquals(
                ironMan2.getArtists().toArray(new Artist[0])[0].getId(),
                movieDto.getArtists().toArray(new ArtistDto[0])[0].getId());
    }

}
