/**
 *
 */
package com.ivoslabs.mail.comp.impl;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ivoslabs.mail.comp.EmailComp;

/**
 * Component to send emails
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@Component
public class EmailCompImpl implements EmailComp {

    /** The constant logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailCompImpl.class);

    /** The constant 0 */
    private static final int ZERO = 0;

    /** Flag that indicates whether is active the mail component */
    @Value("${spring.mail.active}")
    private boolean active;

    /** The sender of this message */
    @Value("${spring.mail.from}")
    private String from;

    /** Addresses to which replies should be directed */
    @Value("${spring.mail.reply:}")
    private String reply;

    /** Map of mailing lists */
    @Autowired
    @Qualifier("mailingLists")
    private Map<String, String[]> lists;

    /** Java Mail Sender */
    @Autowired
    private JavaMailSender emailSender;

    /**
     * Creates an EmailCompImpl instance
     */
    public EmailCompImpl() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String, java.lang.String, java.lang.String)
     */

    @Override
    public boolean sendEmail(String to, String subject, String text) {
        return this.sendEmail(to, null, null, null, null, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(String[] to, String subject, String text) {
        return this.sendEmail(null, to, null, null, null, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(String to, String cc, String subject, String text) {
        return this.sendEmail(to, null, cc, null, null, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String, java.lang.String[], java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(String to, String[] cc, String subject, String text) {
        return this.sendEmail(to, null, null, cc, null, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(String[] to, String cc, String subject, String text) {
        return this.sendEmail(null, to, cc, null, null, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String[], java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(String[] to, String[] cc, String subject, String text) {
        return this.sendEmail(null, to, null, cc, null, subject, text, null);
    }

    /*
     *
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(String[] to, String[] cc, String[] bc, String subject, String text) {
        return this.sendEmail(null, to, null, cc, bc, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(com.ivoslabs.mail.comp.DistList, java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(Enum<?> distList, String subject, String text) {
        return this.sendEmail(null, this.getEmails(distList), null, null, null, subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(com.ivoslabs.mail.comp.DistList, com.ivoslabs.mail.comp.DistList, java.lang.String, java.lang.String)
     */
    @Override
    public boolean sendEmail(Enum<?> distList, Enum<?> distListCC, String subject, String text) {
        return this.sendEmail(null, this.getEmails(distList), null, this.getEmails(distListCC), null, subject, text, null);
    }

    /*
     *
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.Enum, java.lang.Enum, java.lang.Enum, java.lang.String, java.lang.String)
     */
    public boolean sendEmail(Enum<?> distList, Enum<?> distListCC, Enum<?> distListBC, String subject, String text) {
        return this.sendEmail(null, this.getEmails(distList), null, this.getEmails(distListCC), this.getEmails(distListBC), subject, text, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String, java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String to, String subject, String text, File attachment) {
        return this.sendEmail(to, null, null, null, null, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String[] to, String subject, String text, File attachment) {
        return this.sendEmail(null, to, null, null, null, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String to, String cc, String subject, String text, File attachment) {
        return this.sendEmail(to, null, cc, null, null, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String to, String[] cc, String subject, String text, File attachment) {
        return this.sendEmail(to, null, null, cc, null, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String[] to, String cc, String subject, String text, File attachment) {
        return this.sendEmail(null, to, cc, null, null, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String[], java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String[] to, String[] cc, String subject, String text, File attachment) {
        return this.sendEmail(null, to, null, cc, null, subject, text, attachment);
    }

    /*
     *
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(String[] to, String[] cc, String[] bc, String subject, String text, File attachment) {
        return this.sendEmail(null, to, null, cc, bc, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(com.ivoslabs.mail.comp.DistList, java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(Enum<?> distList, String subject, String text, File attachment) {
        return this.sendEmail(null, this.getEmails(distList), null, null, null, subject, text, attachment);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(com.ivoslabs.mail.comp.DistList, com.ivoslabs.mail.comp.DistList, java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(Enum<?> distList, Enum<?> distListCC, String subject, String text, File attachment) {
        return this.sendEmail(null, this.getEmails(distList), null, this.getEmails(distListCC), null, subject, text, attachment);
    }

    /*
     *
     * (non-Javadoc)
     *
     * @see com.ivoslabs.mail.comp.EmailComp#sendEmail(java.lang.Enum, java.lang.Enum, java.lang.Enum, java.lang.String, java.lang.String, java.io.File)
     */
    @Override
    public boolean sendEmail(Enum<?> distList, Enum<?> distListCC, Enum<?> distListBC, String subject, String text, File attachment) {
        return this.sendEmail(null, this.getEmails(distList), null, this.getEmails(distListCC), this.getEmails(distListBC), subject, text, attachment);
    }

    /**
     * Gets the array of emails asociated to the enum
     *
     * @param the distribution list enum
     * @return the emails
     * @since 1.0.0
     * @author www.ivoslabs.com
     *
     */
    private String[] getEmails(Enum<?> dl) {
        return this.lists.get(dl.name().toLowerCase());
    }

    /**
     * Send email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param tos        the recipient email addresses, Indicates primary recipients (multiple allowed), for secondary recipients see Cc: and Bcc: below
     * @param cc         carbon copy; secondary recipient addres
     * @param ccs        carbon copy; secondary recipients addreses
     * @param bcs        blind carbon copy; addresses are usually only specified during SMTP delivery, and not usually listed in the message header.
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author www.ivoslabs.com
     *
     */
    private boolean sendEmail(String to, String[] tos, String cc, String[] ccs, String[] bcs, String subject, String text, File attachment) {

        boolean success;

        try {

            // valid if is active the component
            if (this.active) {

                // valid if is ther any recipients
                if (to != null || (tos != null && tos.length > ZERO)) {

                    MimeMessage message = this.emailSender.createMimeMessage();

                    MimeMessageHelper helper = new MimeMessageHelper(message, Boolean.TRUE);

                    helper.setFrom(this.from);

                    // add recipients
                    if (to != null) {
                        helper.setTo(to);
                    } else {
                        helper.setTo(tos);
                    }

                    // add carbo copy
                    if (cc != null) {
                        helper.setCc(cc);
                    } else if (ccs != null && tos.length > ZERO) {
                        helper.setCc(ccs);
                    }

                    // add blind carbon cpopy
                    if (bcs != null && tos.length > ZERO) {
                        helper.setBcc(bcs);
                    }

                    helper.setSubject(subject);

                    // set html text
                    helper.setText(text, Boolean.TRUE);

                    if (StringUtils.hasText(this.reply)) {
                        helper.setReplyTo(this.reply);
                    }

                    if (attachment != null) {
                        FileSystemResource file = new FileSystemResource(attachment);
                        helper.addAttachment(attachment.getName(), file);
                    }

                    this.emailSender.send(message);

                } else {
                    LOGGER.warn("Email without recipients. Subject: {};", subject);
                    success = Boolean.FALSE;
                }

            } else if (LOGGER.isWarnEnabled()) {
                Object[] args = new Object[] { to != null ? to : Arrays.asList(tos), cc != null ? cc : (ccs != null ? Arrays.asList(ccs) : null), bcs != null ? Arrays.asList(bcs) : null, subject, text, attachment };
                LOGGER.warn("spring.mail.active is disabled. \n   to:        {};  \n   cc:        {};  \n   bcs:       {}; \n   subject:   {}; \n   text:      {}; \n   attachment:{}", args);
            }

            success = Boolean.TRUE;

        } catch (MessagingException e) {
            LOGGER.error(e.getMessage(), e);
            success = Boolean.FALSE;
        }

        return success;

    }

}
