package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController implements EntityController<Person, Long> {
    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getOne(Long id) {
        return null;
    }

    @Override
    public Person edit(Long id, Person person) {
        return null;
    }

    @Override
    public Person delete(Long id) {
        return null;
    }

    @Override
    public Person create(Person person) {
        return null;
    }
}
