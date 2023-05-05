package com.SWEN342.ChatApplicationBackend.UserConversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user-conversation")
public class UserConversationController {

  @Autowired
  private UserConversationRepository userConversationRepository;

  @GetMapping
  public @ResponseBody Iterable<UserConversation> getAllUserConversation() {
    return userConversationRepository.findAll();
  }
}
