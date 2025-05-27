package com.example.animalapp.repository;

import com.example.animalapp.model.AnimalPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalPictureRepository extends JpaRepository<AnimalPicture, Long> {
    Optional<AnimalPicture> findTopByAnimalTypeOrderBySavedAtDesc(String animalType);
}