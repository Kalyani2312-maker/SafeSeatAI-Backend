package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.Alert;
import com.safeseatai.safeseat_ai.repository.AlertRepository;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // Create Alert
    public Alert createAlert(Alert alert) {

        // Save alert in database
        Alert savedAlert = alertRepository.save(alert);

        System.out.println("=================================");
        System.out.println("SafeSeat AI ALERT");
        System.out.println("Alert Type : " + alert.getAlertType());
        System.out.println("Message    : " + alert.getMessage());
        System.out.println("Student ID : " + alert.getStudentId());
        System.out.println("Bus ID     : " + alert.getBusId());
        System.out.println("Status     : " + alert.getStatus());
        System.out.println("=================================");

        return savedAlert;
    }

    // Get all Alerts
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Get Alert by ID
    public Alert getAlertById(Long id) {
        return alertRepository
                .findById(id)
                .orElse(null);
    }

    // Resolve Alert
    public Alert resolveAlert(Long id) {

        Alert alert = alertRepository
                .findById(id)
                .orElse(null);

        if (alert != null) {

            alert.setStatus("RESOLVED");

            return alertRepository.save(alert);
        }

        return null;
    }
}