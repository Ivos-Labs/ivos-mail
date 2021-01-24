/**
 *
 */
package com.ivoslabs.mail.core;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @since
 * @author www.ivoslabs.com
 *
 */
@Configuration
public class MailCfg {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;


    @Value("${spring.mail.properties.mail.smtp.ssl_enable}")
    private boolean sslEnable;


    @Value("${spring.mail.properties.mail.smtp.is_ssl}")
    private boolean isSSL;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private boolean ttls;

    @Value("${spring.mail.properties.mail.debug}")
    private boolean debug;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.host);
        mailSender.setPort(this.port);

        mailSender.setUsername(this.username);
        mailSender.setPassword(this.password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");

        props.put("mail.smtp.auth", Boolean.TRUE);
        props.put("mail.smtp.useAuth", Boolean.TRUE);

        props.put("mail.smtp.starttls.enable", this.ttls);
        props.put("mail.debug", this.debug);
        props.put("mail.smtp.ssl.enable", this.sslEnable);
        props.put("mail.smtp.isSSL", this.isSSL);

        return mailSender;
    }

}
