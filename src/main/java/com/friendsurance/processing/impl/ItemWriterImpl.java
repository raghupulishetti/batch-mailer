package com.friendsurance.processing.impl;

import com.friendsurance.mail.EmailService;
import com.friendsurance.mail.impl.EmailServiceImpl;
import com.friendsurance.model.ProcessOutput;
import com.friendsurance.processing.ItemWriter;

/*
This is concrete implementation of ItemReader interface.
 */
public class ItemWriterImpl implements ItemWriter<ProcessOutput> {

    private EmailService emailService = new EmailServiceImpl();
    /*
    This method takes the output based on user details and sends the email using specific template.
     */
    public void write(ProcessOutput output) {
        emailService.sendMail(output.getUserDetails(), output.getMailType());
    }
}
