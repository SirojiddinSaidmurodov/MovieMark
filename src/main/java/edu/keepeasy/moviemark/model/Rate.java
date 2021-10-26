package edu.keepeasy.moviemark.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rate {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer value;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime timeOfChange;
    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDateTime getTimeOfChange() {
        return timeOfChange;
    }

    public void setTimeOfChange(LocalDateTime timeOfChange) {
        this.timeOfChange = timeOfChange;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
