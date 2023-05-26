package com.cinema.email.services;

public interface EmailSenderService {
    void sensEmail(String to, String subject, String message);
}
