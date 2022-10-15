package com.example.AlkemyChallenge.controller;

import com.example.AlkemyChallenge.entity.Role;
import com.example.AlkemyChallenge.security.UserPrinciple;
import com.example.AlkemyChallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple, @PathVariable Role role) {
        userService.changeRole(role, userPrinciple.getUsername());
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
