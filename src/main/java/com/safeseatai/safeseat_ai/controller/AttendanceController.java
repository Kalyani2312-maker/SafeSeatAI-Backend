package com.safeseatai.safeseat_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeseatai.safeseat_ai.model.Attendance;
import com.safeseatai.safeseat_ai.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance saveAttendance(
            @RequestBody Attendance attendance) {

        return attendanceService.saveAttendance(attendance);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {

        return attendanceService.getAllAttendance();
    }

    @GetMapping("/bus/{busId}")
    public List<Attendance> getAttendanceByBus(
            @PathVariable Long busId) {

        return attendanceService.getAttendanceByBus(busId);
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendanceByStudent(
            @PathVariable Long studentId) {

        return attendanceService.getAttendanceByStudent(studentId);
    }
}