package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}