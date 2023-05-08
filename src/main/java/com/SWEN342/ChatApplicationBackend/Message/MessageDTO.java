package com.SWEN342.ChatApplicationBackend.Message;

import com.SWEN342.ChatApplicationBackend.User.User;

/**
 * A Data Transfer Object that represents what incoming messages should look like.
 */
public class MessageDTO {
  /**
   * The id of the conversation the message belongs to.
   */
  private Long conversationId;

  /**
   * The {@link User} id of the sender of the message.
   */
  private Long senderId;

  /**
   * The message to be sent.
   */
  private String message;

  public Long getConversationId() {
    return conversationId;
  }

  public Long getSenderId() {
    return senderId;
  }

  public String getMessage() {
    return message;
  }
}
