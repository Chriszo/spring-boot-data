package com.spring.boot.tutorial.springbootdata.courses;

import com.spring.boot.tutorial.springbootdata.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        this.courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(Topic topic, String id){
        Course course = this.courseRepository.findByTopicId(topic.getId()).stream().filter(c->c.getId().equals(id)).findFirst().get();
        return course;
    }

    public void addCourse(Course course){
        this.courseRepository.save(course);
    }

    public void updateTopic(Course course, String id){
        this.courseRepository.save(course);
    }

    public void deleteTopic(String id){
        this.courseRepository.deleteById(id);
    }
}
