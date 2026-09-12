package com.safeseatai.safeseat_ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeseatai.safeseat_ai.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByRole(String role);
}