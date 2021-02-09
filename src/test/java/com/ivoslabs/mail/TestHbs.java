/**
 * 
 */
package com.ivoslabs.mail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ivoslabs.mail.comp.HBSTemplates;
import com.ivoslabs.mail.comp.hbs.HTMLParams;
import com.ivoslabs.mail.enums.ExampleTemplate;

/**
 * Test
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TestHbs {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestHbs.class);

    /** Email component */
    @Autowired
    private HBSTemplates hbsTemplates;

    @Test
    public void test01() {

        String text1 = null;
        String text2 = null;
        HTMLParams htmlParams1 = null;
        HTMLParams htmlParams2 = null;

        {
            htmlParams1 = new HTMLParams();
            htmlParams1.put("content", "text");
            htmlParams1.put("error", Boolean.TRUE);
            htmlParams1.put("alert", Boolean.FALSE);
            htmlParams1.put("htmlcontent", "<b><i>html text</i></b>");

            List<HTMLParams> alerts = new ArrayList<>();
            alerts.add(new HTMLParams("code", "1001", "msg", "Desc 1001"));
            alerts.add(new HTMLParams("code", "1002", "msg", "Desc 1002"));

            htmlParams1.put("alerts", alerts);

            text1 = this.hbsTemplates.compile(ExampleTemplate.ADMIN_ALERT, htmlParams1);

            LOGGER.info("text1: {}", this.format(text1));
        }

        {
            JsonObject params = new JsonObject();
            params.addProperty("content", "text");
            params.addProperty("error", Boolean.TRUE);
            params.addProperty("alert", Boolean.FALSE);
            params.addProperty("htmlcontent", "<b><i>html text</i></b>");

            JsonArray alerts = new JsonArray();

            JsonObject alert1 = new JsonObject();
            alert1.addProperty("code", "1001");
            alert1.addProperty("msg", "Desc 1001");

            JsonObject alert2 = new JsonObject();
            alert2.addProperty("code", "1002");
            alert2.addProperty("msg", "Desc 1002");

            alerts.add(alert1);
            alerts.add(alert2);

            params.add("alerts", alerts);

            htmlParams2 = this.hbsTemplates.createModel(params);

            text2 = this.hbsTemplates.compile(ExampleTemplate.ADMIN_ALERT, htmlParams2);

            LOGGER.info("text2: {}", this.format(text2));

        }

        Assertions.assertEquals(text1, text2);
    }

    private String format(String text) {
        return text.replaceAll("\n", " ").replaceAll("\t", " ")
                .replaceAll("\\s+", " ")
                .replaceAll("> <", "><")
                .replaceAll("><", ">\n<")
                .replaceAll(">\n</", "></");
    }

}
