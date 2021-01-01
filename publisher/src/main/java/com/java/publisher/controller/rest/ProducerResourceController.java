package com.java.publisher.controller.rest;

import com.java.publisher.service.MessageOperationService;
import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/publish")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Api(tags = "Publish")
public class ProducerResourceController {

    MessageOperationService messageOperationService;

    @PostMapping("/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String publishQueue(@PathVariable("message") String message) {

        messageOperationService.sendMessageQueue(message);
        return "Published Queue";
    }

    @PostMapping("/topic/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String publishTopic(@PathVariable("message") String message) {

        messageOperationService.sendMessageTopic(message);
        return "Published Topic";
    }
}
