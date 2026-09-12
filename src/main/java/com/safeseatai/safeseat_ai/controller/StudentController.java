package com.safeseatai.safeseat_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.safeseatai.safeseat_ai.model.Student;
import com.safeseatai.safeseat_ai.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ADD STUDENT
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        // New student automatically becomes ACTIVE
        if (student.getBusStatus() == null || student.getBusStatus().isEmpty()) {
            student.setBusStatus("ACTIVE");
        }

        return studentService.addStudent(student);
    }

    // GET ALL STUDENTS
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET STUDENT BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student updatedStudent) {

        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setRollNo(updatedStudent.getRollNo());
        existingStudent.setClassName(updatedStudent.getClassName());
        existingStudent.setBusId(updatedStudent.getBusId());

        // Existing parent ID सुरक्षित ठेवतो
        if (updatedStudent.getParentId() != null) {
            existingStudent.setParentId(updatedStudent.getParentId());
        }

        // Existing bus status सुरक्षित ठेवतो
        if (updatedStudent.getBusStatus() != null &&
            !updatedStudent.getBusStatus().isEmpty()) {

            existingStudent.setBusStatus(updatedStudent.getBusStatus());

        }

        // Existing bus start date सुरक्षित ठेवतो
        if (updatedStudent.getBusStartDate() != null) {
            existingStudent.setBusStartDate(
                updatedStudent.getBusStartDate()
            );
        }

        return studentService.addStudent(existingStudent);
    }

    // ACTIVATE BUS SERVICE
    @PutMapping("/{id}/activate-bus")
    public Student activateBus(@PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return null;
        }

        student.setBusStatus("ACTIVE");

        return studentService.addStudent(student);
    }

    // DEACTIVATE BUS SERVICE
    @PutMapping("/{id}/deactivate-bus")
    public Student deactivateBus(@PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return null;
        }

        student.setBusStatus("INACTIVE");

        return studentService.addStudent(student);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}