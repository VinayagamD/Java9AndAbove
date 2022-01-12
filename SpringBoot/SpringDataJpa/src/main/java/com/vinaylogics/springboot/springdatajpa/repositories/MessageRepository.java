package com.vinaylogics.springboot.springdatajpa.repositories;

import com.vinaylogics.springboot.springdatajpa.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query(value = "SELECT COUNT(m) FROM Message m")
    Long getCount();

    @Query(name = "findById")
    Optional<Message> findSingleMessage(@Param("id") Long id);

}
