package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Country;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@Api
@PreAuthorize("hasAuthority('Country:r')")
public interface CountryRepository extends JpaRepository<Country, Long> {
}