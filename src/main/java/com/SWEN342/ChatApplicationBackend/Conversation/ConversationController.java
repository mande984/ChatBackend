package com.SWEN342.ChatApplicationBackend.Conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/conversation")
public class ConversationController {

  @Autowired
  private ConversationRepository conversationRepository;

  @GetMapping
  public @ResponseBody Iterable<Conversation> getAllConversations() {
    return conversationRepository.findAll();
  }
}
