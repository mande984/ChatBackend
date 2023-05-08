package com.SWEN342.ChatApplicationBackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to handle user-related endpoints
 *
 */
@Controller
@RequestMapping(path="/user")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Retrieve a list of all the users that exist in the application
   *
   * @return A list of all the {@link User}s
   */
  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  /**
   * Retrieve a {@link User} that has a specific id
   *
   * @param userId The id that the user has
   * @return The user entity
   */
  @GetMapping(path = "/{userId}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
    User user = userService.getUserById(userId);
    return ResponseEntity.ok().body(new UserDTO(user.getFirstName(), user.getLastName(), user.getUsername(), user.getSocketId()));
  }

  /**
   * Create a new user in the database.
   *
   * @param user The user to create
   * @return Whether the creation succeeded
   */
  @PostMapping
  public ResponseEntity<Boolean> createUser(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.saveUser(user));
  }
}
