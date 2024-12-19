package com.example.user_microservice.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "tb_users")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", unique = true, nullable = false)
  @Email
  private String email;

  public UserModel(UUID id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  protected UserModel() {
    super();
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    UserModel userModel = (UserModel) o;

    return new EqualsBuilder()
        .append(id, userModel.id)
        .append(name, userModel.name)
        .append(email, userModel.email)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(id).append(name).append(email).toHashCode();
  }
}
