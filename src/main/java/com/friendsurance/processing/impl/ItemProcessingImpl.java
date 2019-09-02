package com.friendsurance.processing.impl;

import com.friendsurance.mail.EmailService;
import com.friendsurance.model.UserDetails;
import com.friendsurance.model.ProcessOutput;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.ItemReader;
import com.friendsurance.processing.ItemWriter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
This is concrete implementation of ItemProcessing.
 */
public class ItemProcessingImpl extends ItemProcessing<UserDetails, ProcessOutput> {

    public ItemProcessingImpl(ItemReader<UserDetails> reader, ItemWriter<ProcessOutput> writer) {
        super(reader, writer);
    }

    /*
    This method do the processing of each record and find out the mailtype
    and wrapped into another object and given it for further processing.
     */
    @Override
    protected ProcessOutput process(UserDetails userDetails) {
        Boolean hasContract = userDetails.hasContract();

        Integer friends = userDetails.getFriendsNumber();

        Integer invitations = userDetails.getSentInvitationsNumber();

        EmailService.MailType mailType = findMailType(hasContract, friends, invitations);

        // There has been no valid status based on implemented algorithm
        if (mailType == null)
            return null;
        return new ProcessOutput(userDetails, mailType);
    }

    /*
    This method actually find MailType based on the userDetails.
    This can be implemented in Rules(Drools or some other rules framework), to decouple and dynamic amendments.
     */
    private EmailService.MailType findMailType(Boolean hasContract, Integer friends, Integer invitations) {
        Set<EmailService.MailType> mailTypes = new TreeSet<>(Comparator.reverseOrder());

        if (!hasContract) {
            if (friends == 0 && invitations == 0)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_2);

            if (friends > 1 && invitations == 0)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_3);

            if (friends > 3 && invitations > 1)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_1);

            if (friends < 3 && invitations > 1)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_2);

            if (friends < 3 && invitations > 6)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_3);
        } else {
            if (friends == 0 && invitations == 0)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_3);

            if (friends == 0 && invitations > 3)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_3);

            if (friends > 1)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_4);

            if (friends > 4 && invitations > 3)
                mailTypes.add(EmailService.MailType.MAIL_TYPE_5);
        }

        if (mailTypes.isEmpty())
            return null;


        return mailTypes.iterator().next();
    }
}
