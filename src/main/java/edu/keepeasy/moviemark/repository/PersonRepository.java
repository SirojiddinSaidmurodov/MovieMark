package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Person;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@Api
@PreAuthorize("hasAuthority('Person:r')")
public interface PersonRepository extends JpaRepository<Person, Long> {
}