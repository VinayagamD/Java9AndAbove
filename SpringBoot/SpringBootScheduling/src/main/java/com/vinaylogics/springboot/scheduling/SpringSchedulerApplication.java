package com.vinaylogics.springboot.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;

@SpringBootApplication
@Slf4j
public class SpringSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSchedulerApplication.class,args);
    }

    @Scheduled(initialDelay = 1000L,fixedDelayString = "${someJob.delay}")
    void someJob() throws InterruptedException {
        log.info("Now is "+ Instant.now().toString());
        Thread.sleep(1000L);
    }
}
