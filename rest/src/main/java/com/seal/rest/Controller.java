package com.seal.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalTime;

@RestController
public class Controller {

    @GetMapping("/intro")
    public Message message() {
        return new Message("test message.");
    }

    @PostMapping("/intro")
    public Message2 message2(Message2 message2) {
        message2.setName(message2.getName() + " " + LocalTime.now());
        return message2;
    }
}
