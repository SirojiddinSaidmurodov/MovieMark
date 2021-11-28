package edu.keepeasy.moviemark.dto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

public class MovieDto extends EntityResource {
    private String name;
    private LocalDate releaseDate;
    private Set<CountryDto> countries;
    private Set<ArtistDto> artists;
    private Set<ActorDto> actors;
    private Long budget;
    private Long box;
    private Duration duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<CountryDto> getCountries() {
        return countries;
    }

    public void setCountries(Set<CountryDto> countries) {
        this.countries = countries;
    }

    public Set<ArtistDto> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistDto> artists) {
        this.artists = artists;
    }

    public Set<ActorDto> getActors() {
        return actors;
    }

    public void setActors(Set<ActorDto> actors) {
        this.actors = actors;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getBox() {
        return box;
    }

    public void setBox(Long box) {
        this.box = box;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", countries=" + countries +
                ", artists=" + artists +
                ", actors=" + actors +
                ", budget=" + budget +
                ", box=" + box +
                ", duration=" + duration +
                '}';
    }
}
