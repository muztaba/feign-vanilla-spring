package com.seal.fegin;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnotherMessageClient {

    @RequestLine("POST /intro")
    @Headers("Content-Type: application/json")
    Message2 postMessage(Message2 message2);

    @RequestLine("POST /intro/{id}")
    @Headers("Content-Type: application/json")
    Message2 postMessageWithParam(@Param("id") String id, Message2 message2);

    @RequestLine("PUT /intro/{id}")
    @Headers("Content-Type: application/json")
    Message2 postMessageWithParamPut(@Param("id") String id, Message2 message2);

    @RequestLine("PATCH /intro/{id}")
    @Headers("Content-Type: application/json")
    Message2 postMessageWithParamPatch(@Param("id") String id, Message2 message2);

    @RequestLine("GET /intro/list")
    List<Message2> getList();
}
