package com.example.animalapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AnimalPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animalType;
    private String url;
    private LocalDateTime savedAt;

    public AnimalPicture() {}

    public AnimalPicture(String animalType, String url, LocalDateTime savedAt) {
        this.animalType = animalType;
        this.url = url;
        this.savedAt = savedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAnimalType() { return animalType; }
    public void setAnimalType(String animalType) { this.animalType = animalType; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public LocalDateTime getSavedAt() { return savedAt; }
    public void setSavedAt(LocalDateTime savedAt) { this.savedAt = savedAt; }
}