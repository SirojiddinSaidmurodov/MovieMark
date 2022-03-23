package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.dto.ArtistDto;
import edu.keepeasy.moviemark.service.ArtistService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Artist")
@RestController
@RequestMapping(path = "artists")
public class ArtistController implements EntityController<ArtistDto, Long> {
    private final ArtistService service;

    @Autowired
    public ArtistController(ArtistService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<ArtistDto> save(@RequestBody ArtistDto artistDto) {
        return ResponseEntity.ok(service.save(artistDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ArtistDto> getById(@PathVariable Long id) {
        if (service.isPresent(id)) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ArtistDto> edit(Long id, ArtistDto artistDto) {
        if (service.isPresent(id)) {
            artistDto.setId(id);
            return ResponseEntity.ok(service.updateById(artistDto));
        }
        return ResponseEntity.notFound().build();
    }
}
