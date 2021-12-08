package com.adidas.email.service;

import com.adidas.email.dto.Email;

/**
 * Interface for email service operations on the subscription system
 */
public interface IEmailService {

    /**
     * Sends the email for the subscription creation
     * @param email Email DTO with information for email sending
     * @return true for sent email, false for email not sent
     */
    boolean sendCreationEmail(Email email);

    /**
     * Sends the email for the subscription creation
     * @param email Email DTO with information for email sending
     * @return true for sent email, false for email not sent
     */
    boolean sendCancellationEmail( Email email);
}
