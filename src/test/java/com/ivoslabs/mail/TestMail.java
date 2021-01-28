/**
 *
 */
package com.ivoslabs.mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ivoslabs.mail.comp.EmailComp;
import com.ivoslabs.mail.enums.ExampleDistLists;

/**
 * Test
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TestMail {

    /** Email component */
    @Autowired
    private EmailComp emailComp;

    @Test
    public void test01() {
        Assertions.assertTrue(this.emailComp.sendEmail("user01@gmail.com", "Test-01", "<b>Content</b>"));
    }

    @Test
    public void test02() {
        Assertions.assertTrue(this.emailComp.sendEmail("user01@gmail.com", "user02@gmail.com", "Test-01", "<b>Content</b>"));
    }

    @Test
    public void test03() {
        Assertions.assertTrue(this.emailComp.sendEmail(new String[] { "user01@gmail.com" }, new String[] { "user02@gmail.com" }, new String[] { "user03@gmail.com" }, "Test-01", "<b>Content</b>"));
    }

    @Test
    public void testEnum01() {
        Assertions.assertTrue(this.emailComp.sendEmail(ExampleDistLists.ADMIN, "Test-01", "<b>Content</b>"));
    }

    @Test
    public void testEnum02() {
        Assertions.assertTrue(this.emailComp.sendEmail(ExampleDistLists.ADMIN, ExampleDistLists.SUPPORT, "Test-01", "<b>Content</b>"));
    }

    @Test
    public void testEnum03() {
        Assertions.assertTrue(this.emailComp.sendEmail(ExampleDistLists.ADMIN, ExampleDistLists.SUPPORT, ExampleDistLists.OTHER_DIST_LIST, "Test-01", "<b>Content</b>"));
    }

}
