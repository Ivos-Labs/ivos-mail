/**
 *
 */
package com.ivoslabs.mail;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ivoslabs.mail.comp.EmailComp;

/**
 * Test
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TestMailFile {

    /** Email component */
    @Autowired
    private EmailComp emailComp;

    @Test
    public void test01() {
        Assertions.assertTrue(this.emailComp.sendEmail("user@ivoslabs.com", "Test-01-file", "<b>Content-file</b>", new File("D://temp/test.txt")));
    }
}
