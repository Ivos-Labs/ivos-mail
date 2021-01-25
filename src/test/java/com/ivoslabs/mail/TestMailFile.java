/**
 *
 */
package com.ivoslabs.mail;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivoslabs.mail.comp.EmailComp;

/**
 * Test
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TestMailFile {

    /** Email component */
    @Autowired
    private EmailComp emailComp;

    @Test
    public void test01() {
        assertTrue(this.emailComp.sendEmail("user@ivoslabs.com", "Test-01-file", "<b>Content-file</b>", new File("D://temp/test.txt")));
    }
}
