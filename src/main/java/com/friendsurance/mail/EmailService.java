package com.friendsurance.mail;

/**
 * Interface for emails service.
 */
public interface EmailService {

    /**
     * Will send an email to a recipient.
     *
     * @param recipient email recipient
     * @param mailType  type of mail
     */
    void sendMail(EmailRecipient recipient, MailType mailType);

    /**
     * MailType defines which kind of email will be sent
     */
    enum MailType {
        MAIL_TYPE_1,
        MAIL_TYPE_2,
        MAIL_TYPE_3,
        MAIL_TYPE_4,
        MAIL_TYPE_5
    }

}
