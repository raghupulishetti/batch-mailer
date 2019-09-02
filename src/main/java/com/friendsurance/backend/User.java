package com.friendsurance.backend;

/**
 * Encapsulates the information about user's situation.
 */
public class User {

    private String  email;
    private boolean hasContract;
    private int     friendsNumber;
    private int     sentInvitationsNumber;

    public User(String email, boolean hasContract, int friendsNumber, int sentInvitationsNumber) {
        this.email = email;
        this.hasContract = hasContract;
        this.friendsNumber = friendsNumber;
        this.sentInvitationsNumber = sentInvitationsNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean hasContract() {
        return hasContract;
    }

    public int getFriendsNumber() {
        return friendsNumber;
    }

    public int getSentInvitationsNumber() {
        return sentInvitationsNumber;
    }

    @Override
    public String toString() {
        return "User{" +
               "email='" + email + '\'' +
               ", hasContract=" + hasContract +
               ", friendsNumber=" + friendsNumber +
               ", sentInvitationsNumber=" + sentInvitationsNumber +
               '}';
    }

}
