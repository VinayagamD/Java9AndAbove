package com.vinaylogics.springboot.springdatamongo.repository;

import com.vinaylogics.springboot.springdatamongo.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
