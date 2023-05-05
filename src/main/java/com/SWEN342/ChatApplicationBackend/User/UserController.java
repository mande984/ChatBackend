package com.SWEN342.ChatApplicationBackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
