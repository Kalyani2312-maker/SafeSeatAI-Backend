package com.safeseatai.safeseat_ai.controller;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.Alert;
import com.safeseatai.safeseat_ai.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "*")
public class AlertController {
	 @Autowired
	    private AlertService alertService;

	    @PostMapping
	    public Alert createAlert(@RequestBody Alert alert) {
	        return alertService.createAlert(alert);
	    }

	    @GetMapping
	    public List<Alert> getAllAlerts() {
	        return alertService.getAllAlerts();
	    }

	    @GetMapping("/{id}")
	    public Alert getAlertById(@PathVariable Long id) {
	        return alertService.getAlertById(id);
	    }
	    @PutMapping("/{id}/resolve")
	    public Alert resolveAlert(@PathVariable Long id) {
	        return alertService.resolveAlert(id);
	    }
}
