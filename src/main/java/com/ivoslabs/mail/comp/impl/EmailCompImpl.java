/**
 *
 */
package com.ivoslabs.mail.comp.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ivoslabs.mail.comp.EmailComp;

/**
 * @since
 * @author www.ivoslabs.com
 *
 */
@Component
public class EmailCompImpl implements EmailComp {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailCompImpl.class);

    @Value("${spring.mail.from}")
    private String from;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public boolean sendEmail(String to, String subject, String text) {
        return this.sendEmail(to, null, subject, text, null);
    }

    public boolean sendEmail(String[] to, String subject, String text) {
        return this.sendEmail(null, to, subject, text, null);
    }

    public boolean sendEmail(String[] to, String cc, String subject, String text) {
        return this.sendEmail(null, to, subject, text, null);
    }

    private boolean sendEmail(String to, String[] tos, String subject, String text, String pathToAttachment) {

        boolean success;

        try {

            MimeMessage message = this.emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(this.from);

            if (to != null) {
                helper.setTo(to);
            } else {
                helper.setTo(tos);
            }

            helper.setSubject(subject);
            helper.setText(text, Boolean.TRUE);

            if (pathToAttachment != null) {
                FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
                helper.addAttachment("Invoice", file);
            }

            this.emailSender.send(message);

            success = Boolean.TRUE;
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage(), e);
            success = Boolean.FALSE;
        }

        return success;

    }

}