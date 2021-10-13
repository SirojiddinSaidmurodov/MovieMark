package edu.keepeasy.moviemark.model;

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
    private Set<Country> counties;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Artist> artists;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Actor> actors;
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

    public Set<Country> getCounties() {
        return counties;
    }

    public void setCounties(Set<Country> counties) {
        this.counties = counties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
