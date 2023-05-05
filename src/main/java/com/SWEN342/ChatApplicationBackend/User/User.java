package com.SWEN342.ChatApplicationBackend.User;

import jakarta.persistence.*;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "user_name", nullable = false)
  private String userName;

  @Column(name = "socket_id")
  private String socketId;

  public User(String firstName, String lastName, String username, String socketId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = username;
    this.socketId = socketId;
  }

  public String getSocketId() {
    return socketId;
  }

  public void setSocketId(String socketId) {
    this.socketId = socketId;
  }

  public String getUsername() {
    return userName;
  }

  public void setUsername(String username) {
    this.userName = username;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  protected User() {

  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
