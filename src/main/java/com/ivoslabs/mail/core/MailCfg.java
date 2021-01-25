/**
 *
 */
package com.ivoslabs.mail.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@Configuration
@EnableAutoConfiguration
public class MailCfg {

    /** The constant logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(MailCfg.class);

    /** The mail server host, typically an SMTP host */
    @Value("${spring.mail.host}")
    private String host;

    /** The mail server port */
    @Value("${spring.mail.port}")
    private int port;

    /** The username for the account at the mail host */
    @Value("${spring.mail.username}")
    private String username;

    /** The password for the account at the mail host */
    @Value("${spring.mail.password}")
    private String password;

    /**
     * Creates ans MailCfg instance
     */
    public MailCfg() {
        super();
    }

    @Bean("mailingLists")
    @ConfigurationProperties(prefix = "spring.mailing.lists")
    public Map<String, String[]> getMailingLists() {
        return new HashMap<>();
    }

    @Bean("mailProperties")
    @ConfigurationProperties(prefix = "spring.mail.properties")
    public Map<String, String> getMailProperties() {
        return new HashMap<>();
    }

    @Bean
    public JavaMailSender getJavaMailSender(@Autowired @Qualifier("mailProperties") Map<String, String> mailProperties) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.host);
        mailSender.setPort(this.port);

        mailSender.setUsername(this.username);
        mailSender.setPassword(this.password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");

        props.put("mail.smtp.auth", Boolean.TRUE);
        props.put("mail.smtp.useAuth", Boolean.TRUE);

        mailProperties.forEach((k, v) -> {
            LOGGER.debug("JavaMailSender using property {}:{} ", k, v);
            props.put(k, v);
        });

        return mailSender;
    }

}
