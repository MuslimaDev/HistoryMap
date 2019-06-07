package com.example.historymap.bootstrap;

import com.example.historymap.entity.Account;
import com.example.historymap.entity.Story;
import com.example.historymap.entity.UserRegistration;
import com.example.historymap.repository.AccountRepository;
import com.example.historymap.repository.StoryRepository;
import com.example.historymap.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account("Muslima","Sadykova", "Student of IT Academy", "Drawing");
        accountRepository.save(account);

        UserRegistration userRegistration = new UserRegistration("Sadykova", "Muslima", "muslima22", "muslima1322@gmail.com", true);
        userRegistrationRepository.save(userRegistration);

        Story story = new Story("Birthday Party", "Sierra Coffee", userRegistration,  "I invited a friend for my birthday. We had fun", 125);
        storyRepository.save(story);
    }
}
