package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Actor;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@Api
@PreAuthorize("hasAuthority('Actor:r')")
public interface ActorRepository extends JpaRepository<Actor, Long> {
}