package by.raufpayzov.controllers;

import by.raufpayzov.entity.Piggy;
import by.raufpayzov.services.PiggyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/piggies")
public class PiggyController {
    @Autowired
    private PiggyService piggyService;

    @GetMapping
    public ResponseEntity<List<Piggy>> getAllPiggies() {
        List<Piggy> piggies = piggyService.getAllPiggies();
        return ResponseEntity.ok(piggies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piggy> getPiggyById(@PathVariable Long id) {
        Optional<Piggy> piggy = piggyService.getPiggyById(id);
        return piggy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Piggy> createPiggy(@RequestBody Piggy piggy) {
        Piggy createdPiggy = piggyService.createPiggy(piggy);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPiggy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Piggy> updatePiggy(@PathVariable Long id, @RequestBody Piggy piggy) {
        Piggy updatedPiggy = piggyService.updatePiggy(id, piggy);
        if (updatedPiggy != null) {
            return ResponseEntity.ok(updatedPiggy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/{balance}")
    public ResponseEntity<Piggy> addBalance(@PathVariable Long id, @PathVariable double balance) {
        Piggy updatePiggyBalance = piggyService.topUpBalance(id, balance);
        if (updatePiggyBalance != null) {
            return ResponseEntity.ok(updatePiggyBalance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePiggy(@PathVariable Long id) {
        piggyService.deletePiggy(id);
        return ResponseEntity.noContent().build();
    }
}