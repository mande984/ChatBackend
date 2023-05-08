package com.SWEN342.ChatApplicationBackend.Conversation;

import com.SWEN342.ChatApplicationBackend.User.User;
import com.SWEN342.ChatApplicationBackend.User.UserRepository;
import com.SWEN342.ChatApplicationBackend.UserConversation.UserConversation;
import com.SWEN342.ChatApplicationBackend.UserConversation.UserConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service for Conversation to make modifications to the backend.
 */
@Service
public class ConversationService {

  @Autowired
  private ConversationRepository conversationRepository;

  @Autowired
  private UserConversationRepository userConversationRepository;

  @Autowired
  private UserRepository userRepository;

  /**
   * Retrieve all of the {@link Conversation}s that exist in the database
   *
   * @return A list of the conversations
   */
  public List<Conversation> getAllConversations(){
    Iterable<Conversation> temp = conversationRepository.findAll();
    List<Conversation> result = new ArrayList<>();
    temp.forEach(result::add);
    return result;
  }

  /**
   * Retrieve the {@link Conversation} with the specified id
   *
   * @param conversationId The id of the conversation to be retrieved
   * @return The conversation with the id specified
   */
  public Conversation getConversationById(long conversationId) {
    Optional<Conversation> result = conversationRepository.findById(conversationId);
    return result.orElse(null);
  }

  /**
   * Start a {@link Conversation} between two {@link User}s that exist in the application
   *
   * @param user1Id The id of one of the users
   * @param user2Id The id of the other user
   * @return The id of the created conversation
   */
  public Long createConversation(String name, long user1Id, long user2Id) {
    Conversation conversation = new Conversation(name);

    Optional<User> user1 = userRepository.findById(user1Id);
    Optional<User> user2 = userRepository.findById(user2Id);

    // Checking that both userId's exist in the system
    if (user1.isPresent() && user2.isPresent()) {
      Conversation newConversation = conversationRepository.save(conversation);
      userConversationRepository.save(new UserConversation(newConversation, user1.get()));
      userConversationRepository.save(new UserConversation(newConversation, user2.get()));
      return conversation.getId();
    }

    return null;
  }
}
