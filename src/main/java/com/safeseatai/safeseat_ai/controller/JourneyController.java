package com.safeseatai.safeseat_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.Journey;
import com.safeseatai.safeseat_ai.service.JourneyService;

@RestController
@RequestMapping("/api/journeys")
@CrossOrigin(origins = "*")
public class JourneyController {
	   @Autowired
	    private JourneyService journeyService;

	    @PostMapping
	    public Journey createJourney(@RequestBody Journey journey) {
	        return journeyService.createJourney(journey);
	    }

	    @GetMapping
	    public List<Journey> getAllJourneys() {
	        return journeyService.getAllJourneys();
	    }
	    @PutMapping("/{id}")
	    public Journey updateJourney(
	            @PathVariable Long id,
	            @RequestBody Journey journey) {

	        journey.setId(id);
	        return journeyService.createJourney(journey);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteJourney(@PathVariable Long id) {
	        journeyService.deleteJourney(id);
	    }
	    @GetMapping("/{id}")
	    public Journey getJourneyById(@PathVariable Long id) {
	        return journeyService.getJourneyById(id);
	    }
}
