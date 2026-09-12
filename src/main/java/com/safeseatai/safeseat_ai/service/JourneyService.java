package com.safeseatai.safeseat_ai.service;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.Journey;
import com.safeseatai.safeseat_ai.repository.JourneyRepository;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    // Add / Update Journey
    public Journey createJourney(Journey journey) {
        return journeyRepository.save(journey);
    }

    // Get all Journeys
    public List<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }

    // Get Journey by ID
    public Journey getJourneyById(Long id) {
        return journeyRepository.findById(id).orElse(null);
    }

    // Delete Journey
    public void deleteJourney(Long id) {
        journeyRepository.deleteById(id);
    }
}