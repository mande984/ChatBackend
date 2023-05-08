package com.SWEN342.ChatApplicationBackend.UserConversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller to handle user-conversation related endpoints
 */
@Controller
@RequestMapping(path = "/user-conversation")
public class UserConversationController {

  @Autowired
  private UserConversationRepository userConversationRepository;

  /**
   * Get all the user-conversation pairings in the application
   *
   * @return A list of the user-conversation pairings
   */
  @GetMapping
  public @ResponseBody Iterable<UserConversation> getAllUserConversation() {
    return userConversationRepository.findAll();
  }
}
