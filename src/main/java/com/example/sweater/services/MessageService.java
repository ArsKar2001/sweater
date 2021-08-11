package com.example.sweater.services;

import com.example.sweater.domaine.Message;
import com.example.sweater.repositries.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    /**
     * @param filter
     * @return
     */
    public List<Message> findByTextOrTag(String filter) {
        return messageRepository.findByTextContainsOrTagContains(filter, filter);
    }
}
