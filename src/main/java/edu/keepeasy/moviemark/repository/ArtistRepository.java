package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Artist;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@Api
@PreAuthorize("hasAuthority('Artist:r')")
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}