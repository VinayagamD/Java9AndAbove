package com.vinaylogics.springboot.springweb.repositories;

import com.vinaylogics.springboot.springweb.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
