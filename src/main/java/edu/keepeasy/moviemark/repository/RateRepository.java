package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Rate;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

@Api
public interface RateRepository extends JpaRepository<Rate, Long> {
}