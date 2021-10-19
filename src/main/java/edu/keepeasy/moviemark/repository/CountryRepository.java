package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.Country;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long>, JpaSpecificationExecutor<Country> {
}