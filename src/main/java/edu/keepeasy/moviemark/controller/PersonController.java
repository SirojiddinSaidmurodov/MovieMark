package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.dto.PersonDto;
import edu.keepeasy.moviemark.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Person")
@RestController
@RequestMapping(path = "persons")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto person) {
        return ResponseEntity.ok(service.save(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Long id) {
        if (service.isPresent(id)) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> edit(@PathVariable Long id, @RequestBody PersonDto person) {
        if (service.isPresent(id)) {
            person.setId(id);
            return ResponseEntity.ok(service.updateById(person));
        }
        return ResponseEntity.notFound().build();
    }
}
