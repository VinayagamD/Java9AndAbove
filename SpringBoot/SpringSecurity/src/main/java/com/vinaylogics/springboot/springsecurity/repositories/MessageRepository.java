package com.vinaylogics.springboot.springsecurity.repositories;

import com.vinaylogics.springboot.springsecurity.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
