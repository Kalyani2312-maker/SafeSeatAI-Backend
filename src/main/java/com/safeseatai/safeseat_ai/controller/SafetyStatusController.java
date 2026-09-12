package com.safeseatai.safeseat_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.SafetyStatus;
import com.safeseatai.safeseat_ai.service.SafetyStatusService;

@RestController
@RequestMapping("/api/safety")
@CrossOrigin(origins = "http://localhost:5173")
public class SafetyStatusController {
	 @Autowired
	    private SafetyStatusService safetyService;

	    @PostMapping("/check")
	    public SafetyStatus checkSafety(
	            @RequestBody SafetyStatus status) {

	        return safetyService.checkSafety(status);
	    }

	    @GetMapping
	    public List<SafetyStatus> getAllSafetyStatus() {

	        return safetyService.getAllSafetyStatus();
	    }
}
