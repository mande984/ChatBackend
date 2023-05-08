package com.SWEN342.ChatApplicationBackend.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to handle message-related endpoints.
 * To create a new message in a conversation, see {@linkplain com.SWEN342.ChatApplicationBackend.Conversation.ConversationController ConversationController}
 */
@Controller
@RequestMapping(path="/message")
public class MessageController {

  @Autowired
  private MessageService messageService;

  /**
   * Retrieve all the messages that exist in the application.
   *
   * @return A list of all of the {@link Message}s
   */
  @GetMapping
  public @ResponseBody List<MessageResponseDTO> getAllMessages() {
    return messageService.getAllMessages();
  }
}
