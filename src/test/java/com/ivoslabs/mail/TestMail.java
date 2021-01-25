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
import com.ivoslabs.mail.enums.ExampleLists;

/**
 * Test
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TestMail {


    /** Email component */
    @Autowired
    private EmailComp emailComp;

    @Test
    public void test01() {
        assertTrue(this.emailComp.sendEmail("user01@gmail.com", "Test-01", "<b>Content</b>"));
    }

    @Test
    public void test02() {
        assertTrue(this.emailComp.sendEmail("user01@gmail.com", "user02@gmail.com", "Test-01", "<b>Content</b>"));
    }

    @Test
    public void test03() {
        assertTrue(this.emailComp.sendEmail(new String[] { "user01@gmail.com" }, new String[] { "user02@gmail.com" }, new String[] { "user03@gmail.com" }, "Test-01", "<b>Content</b>"));
    }

    @Test
    public void testEnum01() {
        assertTrue(this.emailComp.sendEmail(ExampleLists.ADMIN, "Test-01", "<b>Content</b>"));
    }

    @Test
    public void testEnum02() {
        assertTrue(this.emailComp.sendEmail(ExampleLists.ADMIN, ExampleLists.SUPPORT, "Test-01", "<b>Content</b>"));
    }

    @Test
    public void testEnum03() {
        assertTrue(this.emailComp.sendEmail(ExampleLists.ADMIN, ExampleLists.SUPPORT, ExampleLists.OTHER_DIST_LIST, "Test-01", "<b>Content</b>"));
    }

}
