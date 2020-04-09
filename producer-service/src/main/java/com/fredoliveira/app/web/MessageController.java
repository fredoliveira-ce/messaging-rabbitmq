package com.fredoliveira.app.web;

import java.util.concurrent.atomic.AtomicLong;

import com.fredoliveira.domain.entity.Greeting;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public MessageController(
        RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", String.format(template, name));

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody String message) {
        if(isNull(message)) {
            return ResponseEntity.badRequest().build();
        }

        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", message);

        return ResponseEntity.status(ACCEPTED).build();
    }



}
