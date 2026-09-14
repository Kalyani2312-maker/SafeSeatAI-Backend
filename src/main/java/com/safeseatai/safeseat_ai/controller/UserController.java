package com.safeseatai.safeseat_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.safeseatai.safeseat_ai.model.User;
import com.safeseatai.safeseat_ai.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // =====================================================
    // GET ALL USERS
    // =====================================================

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // =====================================================
    // GET USER BY ID
    // =====================================================

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found.");
        }

        return ResponseEntity.ok(user);
    }

    // =====================================================
    // REGISTER / ADD USER
    // =====================================================

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        try {

            User savedUser =
                    userService.registerUser(user);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedUser);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User registration server error.");
        }
    }

    // =====================================================
    // LOGIN
    // =====================================================

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestBody User user) {

        try {

            if (user.getEmail() == null ||
                user.getEmail().trim().isEmpty()) {

                return ResponseEntity
                        .badRequest()
                        .body("Email is required.");
            }

            if (user.getPassword() == null ||
                user.getPassword().isEmpty()) {

                return ResponseEntity
                        .badRequest()
                        .body("Password is required.");
            }

            User loggedInUser =
                    userService.loginUser(
                            user.getEmail().trim(),
                            user.getPassword()
                    );

            return ResponseEntity.ok(loggedInUser);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Login server error: "
                            + e.getMessage());
        }
    }

    // =====================================================
    // UPDATE USER
    // =====================================================

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        try {

            User updated =
                    userService.updateUser(
                            id,
                            updatedUser
                    );

            if (updated == null) {

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("User not found.");
            }

            return ResponseEntity.ok(updated);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User update server error.");
        }
    }

    // =====================================================
    // DELETE USER
    // =====================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable Long id) {

        try {

            User user =
                    userService.getUserById(id);

            if (user == null) {

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("User not found.");
            }

            userService.deleteUser(id);

            return ResponseEntity.ok(
                    "User deleted successfully."
            );

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User delete server error.");
        }
    }
}