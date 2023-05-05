package com.SWEN342.ChatApplicationBackend.Message;

import com.SWEN342.ChatApplicationBackend.Conversation.Conversation;
import com.SWEN342.ChatApplicationBackend.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "conversation_id", nullable = false, unique = true)
  private Conversation conversation;

  @ManyToOne(optional = false)
  @JoinColumn(name = "sender_id", nullable = false, unique = true)
  private User sender;

  @Column(name = "sent_at", nullable = false)
  private LocalDateTime sentAt;

  @Column(name = "message", nullable = false)
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
