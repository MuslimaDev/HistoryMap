package com.example.historymap.service;

import com.example.historymap.entity.Account;
import com.example.historymap.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private Account account;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> create(Account account) {
        accountRepository.save(account);
        return new ResponseEntity<>("First Name: " + account.getFirst_name() + ". Last Name: " + account.getLast_name() + " (added)", HttpStatus.OK);
    }

    @Override
    public String update(Account account) {
        for (Account account1 : accountRepository.findAll()) {
            if (account1.getId() == (account.getId())) {
                account.setId(account1.getId());
                account1.setFirst_name(account1.getFirst_name());
                account1.setLast_name(account1.getLast_name());
                account1.setAbout(account1.getAbout());
                account1.setInterests(account1.getInterests());
                return "Account is updated";
            }
        }
        return "Account with id " + account.getId() + " does not exist";
    }

    @Override
    public ResponseEntity<String> deleteById(Integer id) {
        accountRepository.delete(account);
        return new ResponseEntity<>("First Name: " + account.getFirst_name() + ". Last Name: " + account.getLast_name() + " (deleted)", HttpStatus.OK);
    }
}
