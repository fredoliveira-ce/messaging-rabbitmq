package com.fredoliveira;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Runner(
        RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override public void run(String... args) {
        System.out.println("Sendin message...");
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", "Hello from RabbitMQ");
    }

}
