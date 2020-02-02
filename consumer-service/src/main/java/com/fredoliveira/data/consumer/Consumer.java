package com.fredoliveira.data.consumer;

import com.fredoliveira.domain.entity.Message;
import com.fredoliveira.domain.service.MessageService;
import org.springframework.stereotype.Component;

@Component public class Consumer {

    private final MessageService messageService;

    public Consumer(MessageService messageService) {
        this.messageService = messageService;
    }

    public void receiverMessage(String message) {
        System.out.println("Received <" + message + ">");

        Message objMessage = new Message();
        objMessage.setDescription(message);
        messageService.save(objMessage);
    }

}
