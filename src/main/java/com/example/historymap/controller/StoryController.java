package com.example.historymap.controller;

import com.example.historymap.entity.Story;
import com.example.historymap.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {
    @Autowired
    private StoryService storyService;

    @GetMapping()
    public List<Story> getAll() {
        return storyService.getAll();
    }

    @GetMapping("/{id}")
    public Story getById(@PathVariable Integer id) {
        return storyService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Story story) {
        return storyService.create(story);
    }

    @PutMapping
    public String update(@RequestBody Story story) {
        return storyService.update(story);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id){
        return storyService.deleteById(id);
    }
}
