package com.friendsurance.mail.impl;

import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService;
import com.friendsurance.model.UserDetails;

public class EmailServiceImpl implements EmailService {
    /*
    This method sends the email to User.
    To decouple we can push the messages into the Queue(MQs) for asynchronous and fail safe.
     */
    public void sendMail(EmailRecipient recipient, MailType mailType) {
        System.out.println("Email was sent to " + recipient.getEmail() + " with content: " + getEmailTemplate(mailType));
    }

    /*
        This method generate customized Email content based on MailType and user in HTML or Text .
     */
    private String getEmailTemplate(MailType mailType) {
        String template = null;
        switch (mailType) {
            case MAIL_TYPE_1:
                template = "Hey , do you remember us? Give us a try and be social with your insurances!";
                break;
            case MAIL_TYPE_2:
                template = "Email Template 2";
                break;
            case MAIL_TYPE_3:
                template = "Email Template 3";
                break;
            case MAIL_TYPE_4:
                template = "Email Template 4";
                break;
            case MAIL_TYPE_5:
                template = "Email Template 5";
                break;
            default:
                template = "Default Template";
                break;
        }

        return template;
    }
}

