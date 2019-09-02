package com.friendsurance.model;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailRecipient;

public class UserDetails extends User implements EmailRecipient {

    public UserDetails(String email, boolean hasContract, int friendsNumber, int sentInvitationsNumber) {
        super(email, hasContract, friendsNumber, sentInvitationsNumber);
    }


}
