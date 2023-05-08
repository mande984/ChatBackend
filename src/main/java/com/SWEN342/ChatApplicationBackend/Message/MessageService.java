package com.SWEN342.ChatApplicationBackend.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for {@link Message} to make modifications to the backend.
 */
@Service
public class MessageService {

  @Autowired
  private MessageRepository messageRepository;

  /**
   * Retrieve all the {@link Message}s that exist in the application.
   *
   * @return A list of all the messages as a {@link MessageDTO}
   */
  public List<MessageResponseDTO> getAllMessages() {
    List<MessageResponseDTO> result = new ArrayList<>();
    Iterable<Message> temp = messageRepository.findAll();
    for (Message message : temp) {
      result.add(new MessageResponseDTO(message.getId(), message.getSender().getId(), message.getSentAt(), message.getMessage()));
    }
    return result;
  }

  /**
   * Retrieve all the messages that are related to a conversationId
   *
   * @param conversationId The id of the related conversation
   * @return @return A list of all of the {@link Message}s as a {@link MessageDTO}
   */
  public List<MessageResponseDTO> getMessagesByConversationId(long conversationId) {
    List<Message> messages = messageRepository.findByConversationId(conversationId);
    List<MessageResponseDTO> messageResponses = new ArrayList<>();
    for (Message message : messages) {
      messageResponses.add(new MessageResponseDTO(message.getId(), message.getSender().getId(), message.getSentAt(), message.getMessage()));
    }

    return messageResponses;
  }

  /**
   * Add a {@link Message} to the database
   *
   * @param message The message to be added
   * @return Whether the action succeeded
   */
  public boolean sendMessage(Message message) {
    Message result = messageRepository.save(message);
    return result.getId() != null;
  }
}
