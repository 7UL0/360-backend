package com.example.backend.service;

// Import necessary classes
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service // Marks this class as a Spring service component
@RequiredArgsConstructor // Generates a constructor with required (final) fields
public class PermissionService {

    private final UserRepository userRepository; // Declares a final field for the user repository

    // Method to check if the authenticated user has the specified permission
    public boolean hasPermission(Authentication authentication, String permission) {
        // Extracts the username from the authentication object
        String username = authentication.getName();
        // Retrieves the user object from the repository by username
        User user = userRepository.findByUsername(username).orElse(null);

        // If the user is not found, returns false (no permission)
        if (user == null) {
            return false;
        }

        // Checks if the user's permissions contain the specified permission
        return user.getPermissions().contains(permission);
    }
}
