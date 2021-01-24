/**
 *
 */
package com.ivoslabs.mail;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivoslabs.mail.comp.EmailComp;

/**
 * @since
 * @author www.ivoslabs.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TestMail {

    @Autowired
    private EmailComp emailComp;

    @Test
    public void test01() {

        this.emailComp.sendEmail("iperez.c@outlook.com", "test02", "<b>texto02</b>");

        assertTrue(Boolean.TRUE);
    }

}
