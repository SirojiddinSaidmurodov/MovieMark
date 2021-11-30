package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}