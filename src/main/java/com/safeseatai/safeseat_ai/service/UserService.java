package com.safeseatai.safeseat_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeseatai.safeseat_ai.model.User;
import com.safeseatai.safeseat_ai.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // =========================
    // REGISTER / ADD USER
    // =========================
    public User registerUser(User user) {
        return userRepository.save(user);
    }

//    // =========================
//    // LOGIN
//    // =========================
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }

        if (user.getPassword() == null) {
            return null;
        }

        if (!user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }
    // =========================
    // GET ALL USERS
    // =========================
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // =========================
    // GET USER BY ID
    // =========================
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // =========================
    // UPDATE USER
    // =========================
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // =========================
    // DELETE USER
    // =========================
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}