package com.vinaylogics.springboot.springdatavalidation.repositories;


import com.vinaylogics.springboot.springdatavalidation.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
