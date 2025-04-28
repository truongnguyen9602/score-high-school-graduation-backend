package org.truongnc.graduation.service.impl;

import com.sun.jdi.InternalException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.truongnc.graduation.dto.Email;
import org.truongnc.graduation.dto.SendEmailRequest;
import org.truongnc.graduation.service.EmailService;
import org.truongnc.graduation.type.EmailType;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Slf4j
@Service
@Transactional
public class EmailServiceImpl implements EmailService {
    //    private final JavaMailSenderImpl mailSender;
    private final Configuration freemarkerConfig;

    public EmailServiceImpl( Configuration freemarkerConfig) {
//        this.mailSender = mailSender;
        this.freemarkerConfig = freemarkerConfig;
    }

    public JavaMailSenderImpl getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("viellasolutions@gmail.com");
        mailSender.setPassword("vkpvmzszprcqeuqe");
//        vkpv mzsz prcq euqe

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Override
    public void sendHtmlMail(Email email) {
        try {
            MimeMessage message = getMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            Template template = freemarkerConfig.getTemplate(email.getTemplate());
            String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, email.getVariables());

            helper.setTo(email.getMailTo());
            helper.setSubject(email.getSubject());
            helper.setText(htmlContent, true);

            getMailSender().send(message);
        } catch (Exception e) {
            log.warn("{}: Exception --> ", getClass().getSimpleName(), e);
            throw new InternalException();
        }
    }


    @Override
    public void requestSendMail(SendEmailRequest request) {
        log.info("{}: requestSendMail with request --> {}", getClass().getSimpleName(), request);

        String subject = EmailType.DOWNLOAD_SCORE.getSubjectEn();
        String template = EmailType.DOWNLOAD_SCORE.getTemplateVi();

        Email email = Email.builder()
                .mailTo(request.getMailTo())
                .subject(subject)
                .template(template)
                .variables(request.getVariables())
                .build();
        sendHtmlMail(email);
    }
}
