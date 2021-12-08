package com.adidas.email.service.impl;

import com.adidas.email.dto.Email;
import com.adidas.email.service.IEmailService;
import org.apache.commons.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Mock service implementation for IEmailService.
 * It doesn't send real emails, just Logs messages in the log file with email data.
 */
@Service
public class MockEmailService implements IEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);


    /**
     * Sends the creation email to the provided address
     * @param email Email DTO with information for email sending
     * @return true for sent email, false for invalid email address.
     */
    @Override
    public boolean sendCreationEmail(Email email) {
        boolean sent;
        if (EmailValidator.getInstance().isValid(email.getTo())) {
            LOGGER.info("Sent creation email to {} for Mr/Ms {}", email.getTo(), email.getName());
            sent = true;
        } else {
            LOGGER.info("Invalid email {}", email.getTo());
            sent = false;
        }

        return sent;
    }

    /**
     * Sends the cancellation email to the provided address
     * @param email Email DTO with information for email sending
     * @return true for sent email, false for invalid email address.
     */
    @Override
    public boolean sendCancellationEmail(Email email) {
        boolean sent;
        if (EmailValidator.getInstance().isValid(email.getTo())) {
            LOGGER.info("Sent cancellation email to {} for Mr/Ms {}", email.getTo(), email.getName());
            sent = true;
        } else {
            LOGGER.info("Invalid email {}", email.getTo());
            sent = false;
        }

        return sent;
    }
}
