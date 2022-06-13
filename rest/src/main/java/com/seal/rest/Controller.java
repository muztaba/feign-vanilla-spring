package com.seal.rest;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

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
}
