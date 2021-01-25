/**
 *
 */
package com.ivoslabs.mail.comp;

import java.io.File;

/**
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
public interface EmailComp {

    boolean sendEmail(String to, String subject, String text);

    boolean sendEmail(String[] to, String subject, String text);

    //

    boolean sendEmail(String to, String cc, String subject, String text);

    boolean sendEmail(String to, String[] cc, String subject, String text);

    boolean sendEmail(String[] to, String cc, String subject, String text);

    boolean sendEmail(String[] to, String[] cc, String subject, String text);

    boolean sendEmail(String[] to, String[] cc, String[] bc, String subject, String text);

    //

    boolean sendEmail(Enum<?> distList, String subject, String text);

    boolean sendEmail(Enum<?> distList, Enum<?> distListCC, String subject, String text);

    boolean sendEmail(Enum<?> distList, Enum<?> distListCC, Enum<?> distListBC, String subject, String text);

    //
    //
    // attachment
    //
    //

    boolean sendEmail(String to, String subject, String text, File attachment);

    boolean sendEmail(String[] to, String subject, String text, File attachment);

    //

    boolean sendEmail(String to, String cc, String subject, String text, File attachment);

    boolean sendEmail(String to, String[] cc, String subject, String text, File attachment);

    boolean sendEmail(String[] to, String cc, String subject, String text, File attachment);

    boolean sendEmail(String[] to, String[] cc, String subject, String text, File attachment);

    boolean sendEmail(String[] to, String[] cc, String[] bc, String subject, String text, File attachment);

    //

    boolean sendEmail(Enum<?> distList, String subject, String text, File attachment);

    boolean sendEmail(Enum<?> distList, Enum<?> distListCC, String subject, String text, File attachment);

    boolean sendEmail(Enum<?> distList, Enum<?> distListCC, Enum<?> distListBC, String subject, String text, File attachment);
}
