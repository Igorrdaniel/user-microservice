package com.example.user_microservice.domain.repositories;

import com.example.user_microservice.domain.models.UserModel;

import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByEmail(String email);
}
