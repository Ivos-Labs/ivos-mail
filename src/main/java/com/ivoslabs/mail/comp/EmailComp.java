/**
 *
 */
package com.ivoslabs.mail.comp;

import java.io.File;

/**
 * Component to send emails using Spring
 *
 * @since 1.0.0
 * @author www.ivoslabs.com
 *
 */
public interface EmailComp {

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String to, String subject, String text);

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String subject, String text);

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc      carbon copy; secondary recipients addreses
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String to, String cc, String subject, String text);

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc      carbon copy; secondary recipients addreses
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String to, String[] cc, String subject, String text);

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc      carbon copy; secondary recipients addreses
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String cc, String subject, String text);

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc      carbon copy; secondary recipients addreses
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String[] cc, String subject, String text);

    /**
     * Sends an email
     *
     * @param to      the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc      carbon copy; secondary recipients addreses
     * @param bc      blind carbon copy; addresses are usually only specified during SMTP delivery, and not usually listed in the message header.
     * @param subject a brief summary of the topic of the message
     * @param text    the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String[] cc, String[] bc, String subject, String text);

    /***
     * *
     ***/

    /***
     * *
     ***/

    /***
     * *
     ***/

    /*****************************
     * Distribution list by enum *
     *****************************/

    /***
     * *
     ***/

    /**
     * Sends an email
     *
     * @param distListTo the recipients email addreses. Indicates primary recipients. For secondary recipients see Cc: and Bcc: below
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(Enum<?> distListTo, String subject, String text);

    /**
     * Sends an email
     *
     * @param distListTo the recipients email addreses. Indicates primary recipients. For secondary recipients see Cc: and Bcc: below
     * @param distListCC carbon copy; secondary recipients addreses
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(Enum<?> distListTo, Enum<?> distListCC, String subject, String text);

    /**
     * Sends an email
     *
     * @param distListTo the recipients email addreses. Indicates primary recipients. For secondary recipients see Cc: and Bcc: below
     * @param distListCC carbon copy; secondary recipients addreses
     * @param distListBC blind carbon copy; addresses are usually only specified during SMTP delivery, and not usually listed in the message header.
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(Enum<?> distListTo, Enum<?> distListCC, Enum<?> distListBC, String subject, String text);

    /***
     * *
     ***/

    /***
     * *
     ***/

    /***
     * *
     ***/

    /***************************
     * Emails width attachment *
     ***************************/

    /***
     * *
     ***/

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String to, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc         carbon copy; secondary recipients addreses
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String to, String cc, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc         carbon copy; secondary recipients addreses
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String to, String[] cc, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc         carbon copy; secondary recipients addreses
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String cc, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc         carbon copy; secondary recipients addreses
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String[] cc, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param to         the recipient email addres. Indicates primary recipient. For secondary recipients see Cc: and Bcc: below
     * @param cc         carbon copy; secondary recipients addreses
     * @param bc         blind carbon copy; addresses are usually only specified during SMTP delivery, and not usually listed in the message header.
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(String[] to, String[] cc, String[] bc, String subject, String text, File attachment);

    /***
     * *
     ***/

    /***
     * *
     ***/

    /***
     * *
     ***/

    /*********************************************************
     * Emails width attachment and distribution list by enum *
     ********************************************************/

    /***
     * *
     ***/

    /**
     * Sends an email
     *
     * @param distListTo the recipients email addreses. Indicates primary recipients. For secondary recipients see Cc: and Bcc: below
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(Enum<?> distListTo, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param distListTo the recipients email addreses. Indicates primary recipients. For secondary recipients see Cc: and Bcc: below
     * @param distListCC carbon copy; secondary recipients addreses
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(Enum<?> distListTo, Enum<?> distListCC, String subject, String text, File attachment);

    /**
     * Sends an email
     *
     * @param distListTo the recipients email addreses. Indicates primary recipients. For secondary recipients see Cc: and Bcc: below
     * @param distListCC carbon copy; secondary recipients addreses
     * @param distListBC blind carbon copy; addresses are usually only specified during SMTP delivery, and not usually listed in the message header.
     * @param subject    a brief summary of the topic of the message
     * @param text       the text for the message
     * @param attachment file to be attached
     * @return true when the email was sent successfully
     * @since 1.0.0
     * @author imperezivan
     *
     */
    boolean sendEmail(Enum<?> distListTo, Enum<?> distListCC, Enum<?> distListBC, String subject, String text, File attachment);
}
