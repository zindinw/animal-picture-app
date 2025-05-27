package com.example.animalapp.service;

import com.example.animalapp.model.AnimalPicture;
import com.example.animalapp.repository.AnimalPictureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalPictureService {
    private final AnimalPictureRepository repo;

    public AnimalPictureService(AnimalPictureRepository repo) {
        this.repo = repo;
    }

    public List<AnimalPicture> fetchAndSave(String animal, int count) {
        List<AnimalPicture> saved = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String url = getAnimalUrl(animal);
            if (url == null) continue;
            AnimalPicture pic = new AnimalPicture(animal.toLowerCase(), url, LocalDateTime.now());
            saved.add(repo.save(pic));
        }
        return saved;
    }

    public Optional<AnimalPicture> getLastPicture(String animal) {
        return repo.findTopByAnimalTypeOrderBySavedAtDesc(animal.toLowerCase());
    }

    private String getAnimalUrl(String animal) {
        switch (animal.toLowerCase()) {
            case "cat":
            case "cats":
                int catSize = 200 + (int)(Math.random() * 100);
                return "https://placekitten.com/" + catSize + "/" + (catSize + 50);
            case "dog":
            case "dogs":
                return "https://place.dog/300/200";
            case "bear":
            case "bears":
                int bearSize = 200 + (int)(Math.random() * 100);
                return "https://placebear.com/" + bearSize + "/" + (bearSize + 50);
            default:
                return null;
        }
    }
}