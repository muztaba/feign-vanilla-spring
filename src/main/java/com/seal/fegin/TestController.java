package com.seal.fegin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final MessageClient messageClient;
    private final AnotherMessageClient anotherMessageClient;

    public TestController(MessageClient messageClient, AnotherMessageClient anotherMessageClient) {
        this.messageClient = messageClient;
        this.anotherMessageClient = anotherMessageClient;
    }

    @GetMapping
    public String message() {
        Message message = messageClient.getMessage();
        System.out.println(message);
        return message.getMessage();
    }

    @GetMapping("/post")
    public String message2() {
        Message2 message2 = new Message2();
        message2.setName("TestName");
        message2.setAge(60);
        Message2 res = messageClient.postMessage(message2);
        System.out.println(res);
        return res.getName();
    }

    @GetMapping("/post2")
    public String message3() {
        Message2 message2 = new Message2();
        message2.setName("TestName another message client");
        message2.setAge(60);
        Message2 res = anotherMessageClient.postMessage(message2);
        System.out.println(res);
        return res.getName();
    }

    @GetMapping("/post4")
    public String message4() {
        Message2 message2 = new Message2();
        message2.setName("TestName another message with param ");
        message2.setAge(60);
        Message2 res = anotherMessageClient.postMessageWithParam("1", message2);
        System.out.println(res);
        return res.getName();
    }

    @GetMapping("/put")
    public String messagePUT() {
        Message2 message2 = new Message2();
        message2.setName("TestName another message with param put ");
        message2.setAge(60);
        Message2 res = anotherMessageClient.postMessageWithParamPut("1", message2);
        System.out.println(res);
        return res.getName();
    }

    @GetMapping("/patch")
    public String messagePatch() {
        Message2 message2 = new Message2();
        message2.setName("TestName another message with param patch");
        message2.setAge(60);
        Message2 res = anotherMessageClient.postMessageWithParamPatch("1", message2);
        System.out.println(res);
        return res.getName();
    }

    @GetMapping("/list")
    public String list() {
        List<Message2> res = anotherMessageClient.getList();
        System.out.println(res);
        return res.toString();
    }
}
