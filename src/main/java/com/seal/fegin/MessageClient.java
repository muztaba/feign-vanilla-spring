package com.seal.fegin;

import feign.Headers;
import feign.RequestLine;
import org.springframework.stereotype.Component;

@Component
public interface MessageClient {

    @RequestLine("GET /intro")
    Message getMessage();

    @RequestLine("POST /intro")
    @Headers("Content-Type: application/json")
    Message2 postMessage(Message2 message2);


}
