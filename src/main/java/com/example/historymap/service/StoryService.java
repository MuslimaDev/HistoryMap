package com.example.historymap.service;

import com.example.historymap.entity.Story;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoryService {
    List<Story> getAll();
    Story getById(Integer id);
    ResponseEntity<String> create(Story story);
    String update(Story story);
    ResponseEntity<String> deleteById(Integer id);
}
