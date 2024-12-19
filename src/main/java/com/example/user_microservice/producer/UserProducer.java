package com.example.user_microservice.producer;

import com.example.user_microservice.domain.models.UserModel;
import com.example.user_microservice.dtos.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

  private final RabbitTemplate rabbitTemplate;

  public UserProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value(value = "${broker.exchange.user.name}")
  private String routingKey;

  public void sendEmailToQueue(UserModel userModel) {
    EmailDto emailDto = EmailDto.map(userModel);

    rabbitTemplate.convertAndSend("", routingKey, emailDto);
  }
}
