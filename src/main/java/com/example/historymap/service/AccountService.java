package com.example.historymap.service;

import com.example.historymap.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account getById(Integer id);
    ResponseEntity<String> create(Account account);
    String update(Account account);
    ResponseEntity<String> deleteById(Integer id);
}
