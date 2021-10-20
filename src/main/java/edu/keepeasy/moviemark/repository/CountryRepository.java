package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Country;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

@Api
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>, JpaSpecificationExecutor<Country> {
}