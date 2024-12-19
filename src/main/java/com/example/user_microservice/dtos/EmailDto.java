package com.example.user_microservice.dtos;

import com.example.user_microservice.domain.models.UserModel;

import java.util.UUID;

public class EmailDto {
    private UUID id;
    private String emailTo;
    private String subject;
    private String text;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static EmailDto map(UserModel userModel) {
        EmailDto emailDto = new EmailDto();

        emailDto.setId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Bem-vindo");
        emailDto.setText("Olá, " + userModel.getName() + "! Seja bem-vindo ao nosso sistema.");

        return emailDto;
    }
}
