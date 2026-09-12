package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.EmergencyLocation;
import com.safeseatai.safeseat_ai.repository.EmergencyLocationRepository;

@Service
public class EmergencyLocationService {
	  @Autowired
	    private EmergencyLocationRepository repository;

	    public EmergencyLocation saveLocation(
	            EmergencyLocation location) {

	        return repository.save(location);
	    }

	    public List<EmergencyLocation> getAllLocations() {

	        return repository.findAll();
	    }

	    public EmergencyLocation getLatestLocation() {

	        List<EmergencyLocation> locations =
	                repository.findAll();

	        if (locations.isEmpty()) {
	            return null;
	        }

	        return locations.get(locations.size() - 1);
	    }
}
