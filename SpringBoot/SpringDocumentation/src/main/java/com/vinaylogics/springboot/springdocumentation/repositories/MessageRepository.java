package com.vinaylogics.springboot.springdocumentation.repositories;


import com.vinaylogics.springboot.springdocumentation.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
