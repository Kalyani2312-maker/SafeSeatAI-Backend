package com.safeseatai.safeseat_ai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.Student;
import com.safeseatai.safeseat_ai.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ADD / SAVE STUDENT
    public Student addStudent(Student student) {

        // New student
        if (student.getId() == null) {

            // Generate next Student ID
            String nextStudentId = generateNextStudentId();

            student.setRollNo(nextStudentId);

            // Default status
            if (student.getBusStatus() == null ||
                student.getBusStatus().trim().isEmpty()) {

                student.setBusStatus("ACTIVE");
            }

            // Default start date
            if (student.getBusStartDate() == null ||
                student.getBusStartDate().trim().isEmpty()) {

                student.setBusStartDate(LocalDate.now().toString());
            }

            return studentRepository.save(student);
        }

        // Existing student update
        return studentRepository.save(student);
    }

    // GENERATE NEXT STUDENT ID
    private String generateNextStudentId() {

        List<Student> students = studentRepository.findAll();

        int maxNumber = 0;

        for (Student student : students) {

            String rollNo = student.getRollNo();

            if (rollNo == null || rollNo.trim().isEmpty()) {
                continue;
            }

            try {

                if (rollNo.toUpperCase().startsWith("S")) {

                    String numberPart =
                            rollNo.substring(1).trim();

                    int number =
                            Integer.parseInt(numberPart);

                    if (number > maxNumber) {
                        maxNumber = number;
                    }
                }

            } catch (NumberFormatException e) {

                // Ignore invalid Student ID
            }
        }

        int nextNumber = maxNumber + 1;

        String nextStudentId =
                String.format("S%03d", nextNumber);

        // Safety check for duplicate ID
        while (studentRepository.existsByRollNo(nextStudentId)) {

            nextNumber++;

            nextStudentId =
                    String.format("S%03d", nextNumber);
        }

        return nextStudentId;
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET STUDENT BY ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // DELETE STUDENT
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}