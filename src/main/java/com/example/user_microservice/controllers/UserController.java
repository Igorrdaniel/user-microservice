package com.example.user_microservice.controllers;

import com.example.user_microservice.dtos.UserDto;
import com.example.user_microservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/incluir")
  public ResponseEntity<UserDto> criarUsuario(@Valid @RequestBody UserDto userDto) {
    UserDto userCriado = userService.incluir(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(userCriado);
  }
}
