package com.SWEN342.ChatApplicationBackend.User;

/**
 * A Data Transfer Object that represents what users look like.
 */
public class UserDTO {
  /**
   * The first name of the user
   */
  private String firstName;
  /**
   * The last name of the user
   */
  private String lastName;
  /**
   * The username of the user
   */
  private String userName;
  /**
   * The socket id that the user is currently attached to
   */
  private String socketId;

  public UserDTO(String firstName, String lastName, String userName, String socketId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.socketId = socketId;
  }

  public UserDTO() {

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUserName() {
    return userName;
  }

  public String getSocketId() {
    return socketId;
  }
}
