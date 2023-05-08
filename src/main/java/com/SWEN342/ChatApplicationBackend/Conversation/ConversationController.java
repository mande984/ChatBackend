package com.SWEN342.ChatApplicationBackend.Conversation;

import com.SWEN342.ChatApplicationBackend.Message.Message;
import com.SWEN342.ChatApplicationBackend.Message.MessageDTO;
import com.SWEN342.ChatApplicationBackend.Message.MessageResponseDTO;
import com.SWEN342.ChatApplicationBackend.Message.MessageService;
import com.SWEN342.ChatApplicationBackend.User.User;
import com.SWEN342.ChatApplicationBackend.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Controller to handle conversation-related endpoints
 */
@Controller
@RequestMapping(path="/conversation")
public class ConversationController {

  @Autowired
  private ConversationService conversationService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private UserService userService;

  /**
   * Retrieve all of the {@link Conversation}s that exist in the database
   *
   * @return A list of all the conversations
   */
  @GetMapping
  public ResponseEntity<List<Conversation>> getAllConversations() {
    return ResponseEntity.ok().body(conversationService.getAllConversations());
  }

  /**
   * Retrieve the {@link Conversation} with the specified id
   *
   * @param conversationId The id of the conversation to be retrieved
   * @return The conversation with the id specified
   */
  @GetMapping(path = "/{conversationId}")
  public ResponseEntity<Conversation> getConversationById(@PathVariable long conversationId) {
    return ResponseEntity.ok().body(conversationService.getConversationById(conversationId));
  }

  /**
   * Start a {@link Conversation} between two {@link User}s that exist in the application
   *
   * @param conversationName The name of the conversation to create
   * @param user1Id The id of one of the users
   * @param user2Id The id of the other user
   * @return The id of the created conversation
   */
  @PostMapping
  public ResponseEntity<Long> startConversation(@RequestParam String conversationName, @RequestParam long user1Id, @RequestParam long user2Id) {
    return ResponseEntity.ok().body(conversationService.createConversation(conversationName, user1Id, user2Id));
  }


  /**
   * Retrieve all the messages that exist for a specific {@link Conversation}
   * @param conversationId The id of the conversation to look for
   * @return The list of messages in the form of {@link MessageResponseDTO}
   */
  @GetMapping(path = "/{conversationId}/messages")
  public ResponseEntity<List<MessageResponseDTO>> getMessagesByConversationId(@PathVariable long conversationId) {
    return ResponseEntity.ok().body(messageService.getMessagesByConversationId(conversationId));
  }

  /**
   * Create new {@link Message} in a {@link Conversation}
   *
   * @param messageDTO {@link MessageDTO} to send
   * @return A boolean marking whether the message was created
   */
  @PostMapping(path = "/{conversationId}/messages")
  public ResponseEntity<Boolean> sendMessage(@RequestBody MessageDTO messageDTO) {
    Conversation conversation = conversationService.getConversationById(messageDTO.getConversationId());

    User sender = userService.getUserById(messageDTO.getSenderId());

    Message message = new Message(conversation, sender, LocalDateTime.now(), messageDTO.getMessage());

    return ResponseEntity.ok().body(messageService.sendMessage(message));
  }
}
