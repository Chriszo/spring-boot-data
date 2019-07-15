package com.spring.boot.tutorial.springbootdata.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        this.topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        Topic topic = this.topicRepository.findById(id).get();
        return topic;
    }

    public void addTopic(Topic topic){
        this.topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        this.topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        this.topicRepository.deleteById(id);
    }
}
