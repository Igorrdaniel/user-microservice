package com.example.user_microservice.dtos;

import com.example.user_microservice.domain.models.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public class UserDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;

  @NotBlank(message = "O nome do usuário não pode ser nulo")
  private String name;

  @NotBlank(message = "O email do usuário não pode ser nulo")
  @Email
  private String email;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public static UserDto map(UserModel user) {

    UserDto userDto = new UserDto();

    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());

    return userDto;
  }
}
