package com.SWEN342.ChatApplicationBackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service for {@link User} to make modifications to the backend
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  /**
   * Create a new {@link User} for the application.
   *
   * @param user The user to add to the database
   * @return Whether the action succeeded
   */
  public boolean saveUser(User user) {
    User result = userRepository.save(user);
    return result.getId() != null;
  }

  /**
   * Retrieve all the {@link User}s that exist in the system
   *
   * @return A list of all the users
   */
  public List<User> getAllUsers() {
    Iterable<User> temp = userRepository.findAll();
    List<User> result = new ArrayList<>();
    temp.forEach(result::add);
    return result;
  }

  /**
   * Retrieve a {@link User} that has a specific id
   *
   * @param id The id that the user has
   * @return The user entity
   */
  public User getUserById(long id) {
    Optional<User> result = userRepository.findById(id);
    return result.orElse(null);
  }
}
