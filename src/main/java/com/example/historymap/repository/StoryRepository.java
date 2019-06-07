package com.example.historymap.repository;

import com.example.historymap.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Integer> {

}
