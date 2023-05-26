package com.cinema.email.repository;

import com.cinema.email.domain.EmailContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailContentRepository extends JpaRepository<EmailContent, Long> {
}
