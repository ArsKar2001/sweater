package com.example.sweater.controllers;

import com.example.sweater.domaine.Message;
import com.example.sweater.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    private final MessageService messageService;

    public GreetingController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        return "home";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        List<Message> messages = messageService.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(Map<String, Object> model,
                             @RequestParam String text,
                             @RequestParam String tag) {
        messageService.save(Message.builder()
                .text(text)
                .tag(tag)
                .build());
        List<Message> messages = messageService.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam(name = "filter") String text, Map<String, Object> model) {
        List<Message> messages = messageService.findByTextOrTag(text);
        model.put("messages", messages);
        return "main";
    }
}
