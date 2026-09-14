package com.safeseatai.safeseat_ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeseatai.safeseat_ai.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByRollNo(String rollNo);

    List<Student> findByParentId(Long parentId);
}