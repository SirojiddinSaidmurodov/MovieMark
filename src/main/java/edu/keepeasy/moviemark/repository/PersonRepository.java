package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Person;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

@Api
public interface PersonRepository extends JpaRepository<Person, Long> {
}