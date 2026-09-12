package com.safeseatai.safeseat_ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeseatai.safeseat_ai.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByBusId(Long busId);

    List<Attendance> findByStudentId(Long studentId);

}
