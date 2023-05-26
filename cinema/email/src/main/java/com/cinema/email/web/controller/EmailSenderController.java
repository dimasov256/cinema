package com.cinema.email.web.controller;

import com.cinema.email.resource.EmailMessage;
import com.cinema.email.services.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/sendEmail")
    public ResponseEntity sentEmail(@RequestBody EmailMessage emailMessage) {
        this.emailSenderService.sensEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("success");
    }
}
