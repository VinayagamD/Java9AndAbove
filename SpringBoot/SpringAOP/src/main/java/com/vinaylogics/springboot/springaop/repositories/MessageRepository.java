package com.vinaylogics.springboot.springaop.repositories;


import com.vinaylogics.springboot.springaop.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
