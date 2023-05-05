package com.SWEN342.ChatApplicationBackend.Conversation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Conversation {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  protected Conversation() {

  }
  public Conversation(String name) {
    this.name = name;
  }
}
