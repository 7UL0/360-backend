package com.example.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @PreAuthorize("@permissionService.hasPermission(authentication, 'VIEW_TEAMMATE_CONTENT')")
    @GetMapping("/dashboard/teammate")
    public String getTeamMate() {
        return "Teammate Dashboard";
    }

    @PreAuthorize("@permissionService.hasPermission(authentication, 'VIEW_TEAMLEADER_CONTENT')")
    @GetMapping("/dashboard/teamleader")
    public String getTeamLeader() {
        return "Team Leader Dashboard";
    }

    @PreAuthorize("@permissionService.hasPermission(authentication, 'VIEW_HR_CONTENT')")
    @GetMapping("/dashboard/hr")
    public String getHR() {
        return "HR Dashboard";
    }
}