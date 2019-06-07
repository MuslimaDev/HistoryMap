package com.example.historymap.service;

import com.example.historymap.entity.UserRegistration;
import com.example.historymap.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;
    private UserRegistration userRegistration;

    @Override
    public List<UserRegistration> getAll() {
        return userRegistrationRepository.findAll();
    }

    @Override
    public UserRegistration getById(Integer id) {
        return userRegistrationRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> create(UserRegistration userRegistration) {
        userRegistrationRepository.save(userRegistration);
        return new ResponseEntity<>("User: " + userRegistration.getFirst_name() + " " + userRegistration.getLast_name() + " (added)", HttpStatus.OK);
    }

    @Override
    public String update(UserRegistration userRegistration) {
        for(UserRegistration user : userRegistrationRepository.findAll()){
            if(user.getId() == (userRegistration.getId())){
                user.setId(user.getId());
                user.setFirst_name(user.getFirst_name());
                user.setLast_name(user.getLast_name());
                user.setActive(true);
                user.setEmail(user.getEmail());
                user.setLogin(user.getLogin());
                return "User is updated";
            }
        }
        return "User with id " + userRegistration.getId() + " does not exist";
    }

    @Override
    public String deleteById(Integer id) {
        for(UserRegistration user : userRegistrationRepository.findAll()){
            if(user.getId() == (id)){
                userRegistrationRepository.delete(user);
                return "User is deleted";
            }
        }
        return "User with id " + id + " does not exist";
    }
}
