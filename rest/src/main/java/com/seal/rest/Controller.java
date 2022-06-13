package com.seal.rest;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/intro")
    public Message message() {
        return new Message("test message.");
    }

    @PostMapping("/intro")
    public Message2 message2(@RequestBody Message2 message2) {
        message2.setName(message2.getName() + " " + LocalTime.now());
        return message2;
    }

    @PostMapping("/intro/{id}")
    public Message2 message2(@PathVariable("id")String id, @RequestBody Message2 message2) {
        message2.setName(message2.getName() + " " + id);
        return message2;
    }

    @PatchMapping("/intro/{id}")
    public Message2 message3(@PathVariable("id")String id, @RequestBody Message2 message2) {
        message2.setName(message2.getName() + " " + id);
        return message2;
    }

    @PutMapping("/intro/{id}")
    public Message2 message4(@PathVariable("id")String id, @RequestBody Message2 message2) {
        message2.setName(message2.getName() + " " + id);
        return message2;
    }

    @GetMapping("/intro/list")
    public List<Message2> getList() {
        return List.of(new Message2("name 1", 1), new Message2("name 2", 2)) ;
    }


}
