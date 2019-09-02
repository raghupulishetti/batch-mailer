package com.friendsurance.model;

import com.friendsurance.mail.EmailService;
/*
This is output class after processing from Item Processing Impl.
 */
public class ProcessOutput {
    private UserDetails userDetails;
    private EmailService.MailType mailType;

    public ProcessOutput(UserDetails userDetails, EmailService.MailType mailType) {
        this.userDetails = userDetails;
        this.mailType = mailType;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public EmailService.MailType getMailType() {
        return mailType;
    }
}
