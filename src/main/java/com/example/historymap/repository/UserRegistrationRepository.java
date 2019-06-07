package com.example.historymap.repository;

import com.example.historymap.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {
}
