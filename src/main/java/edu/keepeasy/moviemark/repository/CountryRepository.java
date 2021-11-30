package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Long> {
}