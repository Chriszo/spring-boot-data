package com.spring.boot.tutorial.springbootdata.courses;

import com.spring.boot.tutorial.springbootdata.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String topicId, @PathVariable String id)
    {
        Topic topic = new Topic();
        topic.setId(topicId);
        return this.courseService.getCourse(topic,id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        this.courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        this.courseService.updateTopic(course, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String topicId, @PathVariable String id){
        this.courseService.deleteTopic(id);
    }

}
