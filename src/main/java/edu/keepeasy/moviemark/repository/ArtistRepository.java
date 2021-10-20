package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Artist;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

@Api
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}