package edu.keepeasy.moviemark.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private LocalDate releaseDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Country> countries;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Artist> artists;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Actor> actors;
    private Long budget;
    private Long box;
    private Duration duration;
    @Formula("(SELECT AVG(rate.value) FROM rate WHERE rate.movie_id = id)")
    private Float rating;

    public Movie(Long id, String name, LocalDate releaseDate, Set<Country> countries, Set<Artist> artists, Set<Actor> actors, Long budget, Long box, Duration duration, Float rating) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.countries = countries;
        this.artists = artists;
        this.actors = actors;
        this.budget = budget;
        this.box = box;
        this.duration = duration;
        this.rating = rating;
    }

    public Movie() {
    }

    public Float getRating() {
        return rating;
    }

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

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
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

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> counties) {
        this.countries = counties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
