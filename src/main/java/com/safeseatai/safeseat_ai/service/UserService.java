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

    // =====================================================
    // REGISTER / ADD USER
    // =====================================================

    public User registerUser(User user) {

        if (user.getName() == null ||
            user.getName().trim().isEmpty()) {

            throw new RuntimeException("Name is required.");
        }

        if (user.getEmail() == null ||
            user.getEmail().trim().isEmpty()) {

            throw new RuntimeException("Email is required.");
        }

        if (user.getPassword() == null ||
            user.getPassword().isEmpty()) {

            throw new RuntimeException("Password is required.");
        }

        String email = user.getEmail().trim();

        User existingUser =
                userRepository.findByEmail(email);

        if (existingUser != null) {
            throw new RuntimeException(
                    "Email already registered."
            );
        }

        user.setEmail(email);

        // Role automatic
        if (user.getRole() == null ||
            user.getRole().trim().isEmpty()) {

            user.setRole("PARENT");

        } else {

            user.setRole(
                    user.getRole()
                         .trim()
                         .toUpperCase()
            );
        }

        // Mobile number cleanup
        if (user.getMobileNumber() != null) {

            user.setMobileNumber(
                    user.getMobileNumber().trim()
            );
        }

        return userRepository.save(user);
    }

    // =====================================================
    // LOGIN
    // =====================================================

    public User loginUser(
            String email,
            String password) {

        if (email == null || password == null) {

            throw new RuntimeException(
                    "Invalid email or password."
            );
        }

        email = email.trim();

        System.out.println(
                "LOGIN EMAIL = " + email
        );

        User user =
                userRepository.findByEmail(email);

        System.out.println(
                "FOUND USER = " + user
        );

        if (user == null) {

            throw new RuntimeException(
                    "Invalid email or password."
            );
        }

        if (user.getPassword() == null ||
            !user.getPassword().equals(password)) {

            throw new RuntimeException(
                    "Invalid email or password."
            );
        }

        // Role standard format
        if (user.getRole() != null) {

            user.setRole(
                    user.getRole()
                         .trim()
                         .toUpperCase()
            );
        }

        return user;
    }

    // =====================================================
    // GET ALL USERS
    // =====================================================

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // =====================================================
    // GET USER BY ID
    // =====================================================

    public User getUserById(Long id) {

        return userRepository
                .findById(id)
                .orElse(null);
    }

    // =====================================================
    // UPDATE USER
    // =====================================================

    public User updateUser(
            Long id,
            User updatedUser) {

        User existingUser =
                userRepository
                        .findById(id)
                        .orElse(null);

        if (existingUser == null) {

            return null;
        }

        // Name
        if (updatedUser.getName() != null &&
            !updatedUser.getName()
                       .trim()
                       .isEmpty()) {

            existingUser.setName(
                    updatedUser.getName().trim()
            );
        }

        // Email
        if (updatedUser.getEmail() != null &&
            !updatedUser.getEmail()
                       .trim()
                       .isEmpty()) {

            String newEmail =
                    updatedUser.getEmail().trim();

            User emailUser =
                    userRepository.findByEmail(newEmail);

            // Email belongs to another user
            if (emailUser != null &&
                !emailUser.getId().equals(id)) {

                throw new RuntimeException(
                        "Email already registered."
                );
            }

            existingUser.setEmail(newEmail);
        }

        // Role
        if (updatedUser.getRole() != null &&
            !updatedUser.getRole()
                       .trim()
                       .isEmpty()) {

            existingUser.setRole(
                    updatedUser.getRole()
                               .trim()
                               .toUpperCase()
            );
        }

        // Mobile Number
        if (updatedUser.getMobileNumber() != null) {

            existingUser.setMobileNumber(
                    updatedUser.getMobileNumber()
                               .trim()
            );
        }

        /*
         * IMPORTANT:
         * Admin Dashboard edit form password पाठवत नाही.
         * त्यामुळे existing password change होणार नाही.
         *
         * जर नवीन password पाठवला असेल तरच update करा.
         */

        if (updatedUser.getPassword() != null &&
            !updatedUser.getPassword().isEmpty()) {

            existingUser.setPassword(
                    updatedUser.getPassword()
            );
        }

        return userRepository.save(existingUser);
    }

    // =====================================================
    // DELETE USER
    // =====================================================

    public void deleteUser(Long id) {

        User user =
                userRepository
                        .findById(id)
                        .orElse(null);

        if (user == null) {

            throw new RuntimeException(
                    "User not found."
            );
        }

        userRepository.deleteById(id);
    }
}