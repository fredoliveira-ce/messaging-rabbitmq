package com.fredoliveira.domain.service;

import com.fredoliveira.data.repository.MessageRepository;
import com.fredoliveira.domain.entity.Message;
import org.springframework.stereotype.Service;

@Service public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message message) {
        messageRepository.save(message);
    }
}
