package com.spring.boot.tutorial.springbootdata.topics;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String> {
}
