package com.vinaylogics.springboot.springmvccore.controllers;

import com.vinaylogics.springboot.springmvccore.dtos.PagingMessageDTO;
import com.vinaylogics.springboot.springmvccore.dtos.ResponseDataDTO;
import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok(greetingService.greeting());
    }


    @GetMapping
    public ResponseEntity<List<Message>> allMessages(){
        return ResponseEntity.ok(greetingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findMessage(@PathVariable("id") Long id){
        return ResponseEntity.ok(greetingService.findById(id));
    }

    @GetMapping("/page")
    public ResponseEntity<PagingMessageDTO<List<Message>>> getPagingMessage(@RequestParam(value = "pageSize", defaultValue = "10") Integer size, @RequestParam(value = "pageNumber",defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageCount", defaultValue = "100") Long pageCount){
        return ResponseEntity.ok(greetingService.getPagingMessage(size, pageNumber, pageCount));
    }

    @PostMapping
    public ResponseEntity<ResponseDataDTO<Message>> createMessage(@RequestBody Message message){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDataDTO.Builder<Message>()
                .success(true)
                .data(greetingService.save(message))
                .message("Message Created")
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDataDTO<Message>> updateMessage(@PathVariable("id") Long id, @RequestBody Message message){
        message.setId(id);
        return ResponseEntity.ok(new ResponseDataDTO.Builder<Message>()
                .success(true)
                .data(greetingService.update(id,message))
                .message("Message Updated")
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDataDTO<?>> deleteMessage(@PathVariable Long id){
        greetingService.deleteById(id);
        return ResponseEntity.ok(new ResponseDataDTO.Builder<String>()
                .success(true)
                .message("Message with id="+id+" removed successful")
                .build());
    }

}
