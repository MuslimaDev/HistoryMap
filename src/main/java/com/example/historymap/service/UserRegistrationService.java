package com.example.historymap.service;

import com.example.historymap.entity.UserRegistration;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRegistrationService {
    List<UserRegistration> getAll();
    UserRegistration getById(Integer id);
    ResponseEntity<String> create(UserRegistration userRegistration);
    String update(UserRegistration userRegistration);
    String deleteById(Integer id);
}
