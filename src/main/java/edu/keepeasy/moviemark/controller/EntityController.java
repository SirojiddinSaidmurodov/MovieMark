package edu.keepeasy.moviemark.controller;

import org.springframework.http.ResponseEntity;

public interface EntityController<Dto, Id extends Number> {
    ResponseEntity<Dto> save(Dto dto);

    ResponseEntity<Dto> getById(Id id);

    ResponseEntity<Dto> edit(Id id, Dto dto);
}
