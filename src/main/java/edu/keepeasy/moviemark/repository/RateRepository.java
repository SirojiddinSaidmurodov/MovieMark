package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Rate;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@Api
@PreAuthorize("hasAuthority('Rate:r')")
public interface RateRepository extends JpaRepository<Rate, Long> {
}