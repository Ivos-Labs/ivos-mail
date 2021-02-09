/**
 * 
 */
package com.ivoslabs.mail.comp.hbs;

/**
 * @since
 * @author  
 *
 */
public interface LabelSupplier {

    /**
     * Gets the value
     * @param labelKey
     * @return the message value of the key
     * @since 1.0.0
     * @author www.ivoslabs.com
     *
     */
    String getLabelFor(String labelKey);
}
