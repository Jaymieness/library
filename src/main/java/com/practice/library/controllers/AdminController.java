package com.practice.library.controllers;

import com.practice.library.entity.Admin;
import com.practice.library.services.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;

    @GetMapping("{/id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        return new ResponseEntity<>(adminService.getAdmin(id).getName(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
