package com.ivoslabs.mail.comp.hbs;

import java.util.HashMap;

/**
 * 
 * @since
 * @author www.ivoslabs.com
 *
 */
public class HTMLParams extends HashMap<String, Object> {

    /** The constant serialVersionUID */
    private static final long serialVersionUID = 1;

    /** The constant EMPTY */
    public static final String EMPTY = "";

    /**
     * Creates a HTMLParams instance
     */
    public HTMLParams() {
        super();
    }

    /**
     * Creates an HTMLParams instance
     */
    public HTMLParams(String key, Object value) {
        super();
        this.put(key, value);
    }

    /**
     * Creates an HTMLParams instance
     */
    public HTMLParams(String key1, Object value1, String key2, Object value2) {
        super();
        this.put(key1, value1);
        this.put(key2, value2);
    }

    /*
     * 
     * (non-Javadoc)
     * 
     * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
     */
    public Object put(String key, Object value) {
        return super.put(key, value != null ? value : EMPTY);
    }
}
