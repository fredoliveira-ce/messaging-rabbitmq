package com.fredoliveira.data.repository;

import com.fredoliveira.domain.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
