package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RateRepository extends JpaRepository<Rate, Long> {
}