package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActorRepository extends JpaRepository<Actor, Long> {
}