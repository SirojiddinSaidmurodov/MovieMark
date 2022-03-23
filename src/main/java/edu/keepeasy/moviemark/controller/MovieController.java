package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.dto.MovieDto;
import edu.keepeasy.moviemark.service.MovieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/movies")
public class MovieController implements EntityController<MovieDto, Long> {
    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(service.save(movieDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id) {
        if (service.isPresent(id)) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> edit(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        if (service.isPresent(id)) {
            movieDto.setId(id);
            return ResponseEntity.ok(service.save(movieDto));
        }
        return ResponseEntity.notFound().build();
    }
}
