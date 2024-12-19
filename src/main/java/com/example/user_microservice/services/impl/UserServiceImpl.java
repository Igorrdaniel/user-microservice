package com.example.user_microservice.services.impl;

import com.example.user_microservice.domain.models.UserModel;
import com.example.user_microservice.domain.repositories.UserRepository;
import com.example.user_microservice.dtos.UserDto;
import com.example.user_microservice.producer.UserProducer;
import com.example.user_microservice.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserProducer userProducer;

  public UserServiceImpl(UserRepository userRepository, UserProducer userProducer) {
    this.userRepository = userRepository;
      this.userProducer = userProducer;
  }

  @Override
  @Transactional
  public UserDto incluir(UserDto userDto) {
    UserModel user = new UserModel(userDto.getId(), userDto.getName(), userDto.getEmail());

    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new MessagingException("Usúario já esta cadastrado com esse email");
    }

    userRepository.save(user);

    userProducer.sendEmailToQueue(user);

    return UserDto.map(user);
  }
}
