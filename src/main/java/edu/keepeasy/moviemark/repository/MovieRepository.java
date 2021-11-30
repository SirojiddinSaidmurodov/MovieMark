package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByNameContains(String name);
}