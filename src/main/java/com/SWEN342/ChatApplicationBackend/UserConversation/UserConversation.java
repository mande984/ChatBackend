package com.SWEN342.ChatApplicationBackend.UserConversation;

import com.SWEN342.ChatApplicationBackend.Conversation.Conversation;
import com.SWEN342.ChatApplicationBackend.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_conversation")
public class UserConversation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "conversation_id")
  private Conversation conversation;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public UserConversation(Conversation conversation, User user) {
    this.conversation = conversation;
    this.user = user;
  }

  protected UserConversation() {

  }
}
