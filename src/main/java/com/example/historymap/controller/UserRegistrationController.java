package com.example.historymap.controller;

import com.example.historymap.entity.UserRegistration;
import com.example.historymap.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {
    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping()
    public List<UserRegistration> getAll() {
        return userRegistrationService.getAll();
    }

    @GetMapping("/{id}")
    public UserRegistration getById(@PathVariable Integer id) {
        return userRegistrationService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UserRegistration UserRegistration) {
        return userRegistrationService.create(UserRegistration);
    }

    @PutMapping
    public String update(@RequestBody UserRegistration userRegistration) {
        return userRegistrationService.update(userRegistration);
    }

    @DeleteMapping
    public String delete(  @RequestParam Integer id){
        return userRegistrationService.deleteById(id);
    }
}