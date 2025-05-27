package com.example.animalapp.controller;

import com.example.animalapp.model.AnimalPicture;
import com.example.animalapp.service.AnimalPictureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pictures")
public class AnimalPictureController {
    private final AnimalPictureService service;

    public AnimalPictureController(AnimalPictureService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public List<AnimalPicture> savePictures(
            @RequestParam String animal,
            @RequestParam(defaultValue = "1") int count) {
        return service.fetchAndSave(animal, count);
    }

    @GetMapping("/last")
    public ResponseEntity<AnimalPicture> getLastPicture(@RequestParam String animal) {
        return service.getLastPicture(animal)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}