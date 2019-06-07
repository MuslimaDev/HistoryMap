package com.example.historymap.service;

import com.example.historymap.entity.Story;
import com.example.historymap.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoryRepository storyRepository;
    private Story story;


    @Override
    public List<Story> getAll() {
        return storyRepository.findAll();
    }

    @Override
    public Story getById(Integer id) {
        return storyRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> create(Story story) {
        storyRepository.save(story);
        return new ResponseEntity<>("Story: " + story.getStory_title() + " (added)", HttpStatus.OK);
    }

    @Override
    public String update(Story story) {
        for(Story story1 : storyRepository.findAll()){
            if(story1.getId() == (story.getId())){
                story1.setId(story1.getId());
                story1.setUser(story1.getUser());
                story1.setStory_title(story1.getStory_title());
                story1.setStory(story1.getStory());
                story1.setLikes(story1.getLikes());
                story1.setLocation(story1.getLocation());
                return "Story is updated";
            }
        }
        return "Story with id " + story.getId() + " does not exist";
    }

    @Override
    public ResponseEntity<String> deleteById(Integer id) {
        storyRepository.delete(story);
        return new ResponseEntity<>("Story: " + story.getStory_title() + " (deleted)", HttpStatus.OK);
    }
}
