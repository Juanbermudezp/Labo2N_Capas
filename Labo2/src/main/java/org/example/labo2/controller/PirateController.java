package org.example.labo2.controller;

import lombok.AllArgsConstructor;
import org.example.labo2.domain.entity.Pirate;
import org.example.labo2.service.PirateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
@AllArgsConstructor
public class PirateController {
    private final PirateService pirateService;

    @PostMapping
    public ResponseEntity<Pirate> createPirate(@RequestBody Pirate pirate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pirateService.save(pirate));
    }

    @GetMapping
    public ResponseEntity<List<Pirate>> getAllPirates() {
        return ResponseEntity.ok(pirateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirate> getPirateById(@PathVariable UUID id) {
        return ResponseEntity.ok(pirateService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pirate> updatePirate(@PathVariable UUID id, @RequestBody Pirate pirate) {
        return ResponseEntity.ok(pirateService.update(id, pirate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirate(@PathVariable UUID id) {
        pirateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}