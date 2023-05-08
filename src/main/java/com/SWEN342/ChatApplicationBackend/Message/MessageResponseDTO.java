package com.SWEN342.ChatApplicationBackend.Message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

/**
 * A Data Transfer Object that represents the format for messages returned from the system
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponseDTO {
  private Long id;
  private Long senderId;
  private LocalDateTime sentAt;
  private String message;

  public MessageResponseDTO(Long id, Long senderId, LocalDateTime sentAt, String message) {
    this.id = id;
    this.senderId = senderId;
    this.sentAt = sentAt;
    this.message = message;
  }
}