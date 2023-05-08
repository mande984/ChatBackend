package com.SWEN342.ChatApplicationBackend.UserConversation;

import com.SWEN342.ChatApplicationBackend.Conversation.Conversation;
import com.SWEN342.ChatApplicationBackend.User.User;
import jakarta.persistence.*;

/**
 * Representation of a linking entity that makes a conversation linked to a user
 */
@Entity
@Table(name = "user_conversation")
public class UserConversation {

  /**
   * The id of the user_conversation
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The conversation that the user belongs to
   */
  @ManyToOne
  @JoinColumn(name = "conversation_id")
  private Conversation conversation;

  /**
   * The user that the conversation belongs to
   */
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public UserConversation(Conversation conversation, User user) {
    this.conversation = conversation;
    this.user = user;
  }

  protected UserConversation() {

  }

  public Long getId() {
    return id;
  }
}
