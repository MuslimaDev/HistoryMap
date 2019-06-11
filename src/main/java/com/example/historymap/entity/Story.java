package com.example.historymap.entity;

import javax.persistence.*;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String story_title;
    private String location;
    @ManyToOne
    private UserRegistration user;
    private String story;
    private int likes;

    public Story() {
    }

    public Story(String story_title, String location, UserRegistration user, String story, int likes) {
        this.story_title = story_title;
        this.location = location;
        this.user = user;
        this.story = story;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory_title() {
        return story_title;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserRegistration getUser() {
        return user;
    }

    public void setUser(UserRegistration user) {
        this.user = user;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
