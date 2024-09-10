package com.codurance.dip;

public class SystemOutEmailSender implements EmailSender {
    @Override
    public void send(Email email) {
        System.out.printf("To: %s, Subject: %s, Message: %s", email.to(), email.subject(), email.message());
    }
}
