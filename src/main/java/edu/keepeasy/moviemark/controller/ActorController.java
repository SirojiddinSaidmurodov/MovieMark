package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.dto.ActorDto;
import edu.keepeasy.moviemark.service.ActorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Actors")
@RestController
@RequestMapping(path = "actors")
public class ActorController implements EntityController<ActorDto, Long> {
    private final ActorService service;

    @Autowired
    public ActorController(ActorService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<ActorDto> save(@RequestBody ActorDto actorDto) {
        return ResponseEntity.ok(service.save(actorDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getById(Long id) {
        if (service.isPresent(id)) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ActorDto> edit(Long id, ActorDto actorDto) {
        if (service.isPresent(id)) {
            actorDto.setId(id);
            return ResponseEntity.ok(service.save(actorDto));
        }
        return ResponseEntity.notFound().build();
    }
}
