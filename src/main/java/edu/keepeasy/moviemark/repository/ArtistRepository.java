package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}