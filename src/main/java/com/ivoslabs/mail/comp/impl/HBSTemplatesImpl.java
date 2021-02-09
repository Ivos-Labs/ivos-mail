package com.ivoslabs.mail.comp.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.io.TemplateSource;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ivoslabs.mail.comp.HBSTemplates;
import com.ivoslabs.mail.comp.hbs.HTMLParams;
import com.ivoslabs.mail.comp.hbs.LabelSupplier;
import com.ivoslabs.mail.comp.hbs.ex.HBSException;

/**
 *
 * @author
 */
@Component
public class HBSTemplatesImpl implements HBSTemplates {

    private static final Logger LOGGER = LoggerFactory.getLogger(HBSTemplatesImpl.class);

    private static final Map<String, String> HTML_RESOURCES = new HashMap<>();

    @Value("classpath:html/**")
    private Resource[] resources;

    @Autowired
    private LabelSupplier labelSupplier;

    private static final String HBS_HTML = ".hbs.html";

    private Handlebars handlebars = new Handlebars();

    @PostConstruct
    public void init() {

        try {

            this.handlebars.registerHelper("labelFor", (String key, Options optns) -> this.labelSupplier.getLabelFor(key));

            if (this.resources != null) {
                if (this.resources.length > 0) {

                    Arrays.asList(this.resources).stream().filter(r -> r.getFilename().endsWith(".html")).forEach(r -> {

                        String path1 = r.toString().substring(r.toString().indexOf("[") + 1, r.toString().length() - 1);

                        String pathAux = "/aux/" + path1.replaceAll("\\\\", "/");

                        String htmlKey = pathAux.split("/html/")[1];

                        try {
                            String content = IOUtils.toString(r.getInputStream(), StandardCharsets.UTF_8);
                            HTML_RESOURCES.put(htmlKey, content);
                            LOGGER.info("html key: {}; path: {}; htmlContent is null: {}; ", htmlKey, path1, (content == null));
                        } catch (IOException e) {
                            throw new HBSException("An error occurred when starting the HBSTemplates.", e);
                        }

                    });

                } else {
                    LOGGER.warn("list of files at classpath:html/ is empty");
                }
            } else {
                LOGGER.warn("not found files at  classpath:html/ ");
            }

        } catch (Exception e) {
            throw new HBSException("An error occurred when starting the HtmlHandle.", e);
        }

    }

    /*
     * 
     * (non-Javadoc)
     * 
     * @see com.ivoslabs.mail.comp.HBSTemplates#compile(java.lang.Enum, com.ivoslabs.mail.comp.hbs.HTMLParams)
     */
    @Override
    public String compile(Enum<?> template, HTMLParams model) {
        String html = null;

        try {

            TemplateSource ts = createTemplateSource(template.name() + HBS_HTML);
            Template t = this.handlebars.compile(ts);
            Context c = Context.newBuilder(model).resolver(MapValueResolver.INSTANCE).build();
            html = t.apply(c);

        } catch (IOException e) {
            throw new HBSException("Ocurred an error at compileTemplateByModel", e);
        }

        return html;
    }

    /*
     * 
     * (non-Javadoc)
     * 
     * @see com.ivoslabs.mail.comp.HBSTemplates#createModel(com.google.gson.JsonObject)
     */
    @Override
    public HTMLParams createModel(JsonObject json) {
        HTMLParams model = new HTMLParams();

        Set<Map.Entry<String, JsonElement>> m = json.entrySet();

        m.forEach((entry) -> {
            String key = entry.getKey();
            JsonElement val = entry.getValue();
            if (val instanceof JsonArray) {
                JsonArray arr = (JsonArray) val;
                List<HTMLParams> list = new ArrayList<>();
                arr.forEach(jsonElement -> list.add(createModel((JsonObject) jsonElement)));
                model.put(key, list);
            } else if (val instanceof JsonObject) {
                model.put(key, createModel((JsonObject) val));
            } else if (val instanceof JsonPrimitive) {
                JsonPrimitive prim = (JsonPrimitive) val;
                if (prim.isBoolean()) {
                    model.put(key, prim.getAsBoolean());
                } else if (prim.isNumber()) {
                    model.put(key, prim.getAsNumber());
                } else {
                    model.put(key, prim.getAsString());
                }
            } else {
                model.put(key, HTMLParams.EMPTY);
            }
        });

        return model;
    }

    /***
     * *
     ***/

    /***
     * *
     ***/

    /***
     * *
     ***/

    /*******************
     * Private methods *
     *******************/

    /***
     * *
     ***/

    /**
     *
     * @param resurce
     * @return
     */
    private TemplateSource createTemplateSource(String template) {

        final long LAST_MODIFIED = new Date().getTime();

        TemplateSource ts = new TemplateSource() {

            @Override
            public String filename() {
                return template;
            }

            @Override
            public long lastModified() {
                return LAST_MODIFIED;
            }

            @Override
            public String content(Charset arg0) throws IOException {
                return HTML_RESOURCES.get(template);
            }
        };
        return ts;
    }

}
