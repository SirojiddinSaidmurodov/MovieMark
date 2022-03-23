package edu.keepeasy.moviemark.controller;

import edu.keepeasy.moviemark.dto.RateDto;
import edu.keepeasy.moviemark.service.RateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("rates")
public class RateController implements EntityController<RateDto, Long> {
    private final RateService service;

    @Autowired
    public RateController(RateService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<RateDto> save(@RequestBody RateDto rateDto) {
        return ResponseEntity.ok(service.save(rateDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RateDto> getById(@PathVariable Long id) {
        if (service.isPresent(id)) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<RateDto> edit(@PathVariable Long id, @RequestBody RateDto rateDto) {
        if (service.isPresent(id)) {
            rateDto.setId(id);
            return ResponseEntity.ok(service.save(rateDto));
        }
        return ResponseEntity.notFound().build();
    }
}
