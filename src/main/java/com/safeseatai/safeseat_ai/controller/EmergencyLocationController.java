package com.safeseatai.safeseat_ai.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.EmergencyLocation;
import com.safeseatai.safeseat_ai.service.EmergencyLocationService;

@RestController
@RequestMapping("/api/emergency-location")
@CrossOrigin(origins = "*")
public class EmergencyLocationController {

    @Autowired
    private EmergencyLocationService service;

    @PostMapping
    public EmergencyLocation saveLocation(
            @RequestBody EmergencyLocation location) {

        // Automatically set current date and time
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        location.setTimestamp(
                LocalDateTime.now().format(formatter)
        );

        return service.saveLocation(location);
    }

    @GetMapping
    public List<EmergencyLocation> getAllLocations() {

        return service.getAllLocations();
    }

    @GetMapping("/latest")
    public EmergencyLocation getLatestLocation() {

        return service.getLatestLocation();
    }
}