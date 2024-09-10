package com.codurance.dip;

public class EmailSender {
    public void send(Email email) {
        System.out.printf("To: %s, Subject: %s, Message: %s", email.to(), email.subject(), email.message());
    }
}
