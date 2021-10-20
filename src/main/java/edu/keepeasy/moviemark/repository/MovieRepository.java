package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Movie;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

@Api
public interface MovieRepository extends JpaRepository<Movie, Long> {
}