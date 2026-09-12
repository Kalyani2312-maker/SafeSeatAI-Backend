package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.Alert;
import com.safeseatai.safeseat_ai.model.Student;
import com.safeseatai.safeseat_ai.model.User;
import com.safeseatai.safeseat_ai.repository.AlertRepository;
import com.safeseatai.safeseat_ai.repository.StudentRepository;
import com.safeseatai.safeseat_ai.repository.UserRepository;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SmsService smsService;

    // Create Alert
    public Alert createAlert(Alert alert) {

        // Save alert in database
        Alert savedAlert = alertRepository.save(alert);

        try {

            // Find student
            Student student =
                    studentRepository.findById(alert.getStudentId())
                    .orElse(null);

            if (student == null) {
                System.out.println("Student not found for SMS.");
                return savedAlert;
            }

            String studentName = student.getStudentName();

            String busNumber =
                    "MH12AB1001";

            // -----------------------------
            // 1. SEND SMS TO PARENT
            // -----------------------------

            if (student.getParentId() != null) {

                User parent =
                        userRepository
                        .findById(student.getParentId())
                        .orElse(null);

                if (parent != null &&
                    parent.getMobileNumber() != null &&
                    !parent.getMobileNumber().trim().isEmpty()) {

                    smsService.sendSms(
                            parent.getMobileNumber(),
                            studentName,
                            busNumber,
                            alert.getMessage()
                    );

                    System.out.println(
                            "Parent SMS sent/requested for: "
                            + studentName
                    );
                }
            }

            // -----------------------------
            // 2. SEND SMS TO ALL TEACHERS
            // -----------------------------

            List<User> teachers =
                    userRepository.findByRole("TEACHER");

            for (User teacher : teachers) {

                if (teacher.getMobileNumber() != null &&
                    !teacher.getMobileNumber().trim().isEmpty()) {

                    smsService.sendSms(
                            teacher.getMobileNumber(),
                            studentName,
                            busNumber,
                            alert.getMessage()
                    );

                    System.out.println(
                            "Teacher SMS sent/requested to: "
                            + teacher.getName()
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "SMS processing error: "
                    + e.getMessage()
            );
        }

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

        Alert alert =
                alertRepository
                .findById(id)
                .orElse(null);

        if (alert != null) {

            alert.setStatus("RESOLVED");

            return alertRepository.save(alert);
        }

        return null;
    }
}