package org.truongnc.graduation.service;

import org.truongnc.graduation.dto.Email;
import org.truongnc.graduation.dto.SendEmailRequest;

public interface EmailService {
    void sendHtmlMail(Email email);

    void requestSendMail(SendEmailRequest sendEmailRequest);

}