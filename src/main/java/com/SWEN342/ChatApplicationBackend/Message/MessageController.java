package com.SWEN342.ChatApplicationBackend.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/message")
public class MessageController {

  @Autowired
  private MessageRepository messageRepository;

  @GetMapping
  public @ResponseBody Iterable<Message> getAllMessages() {
    return messageRepository.findAll();
  }
}
