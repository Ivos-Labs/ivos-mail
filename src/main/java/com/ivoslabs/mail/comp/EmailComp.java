/**
 *
 */
package com.ivoslabs.mail.comp;

/**
 * @since
 * @author www.ivoslabs.com
 *
 */
public interface EmailComp {

    boolean sendEmail(String to, String subject, String text);

}
