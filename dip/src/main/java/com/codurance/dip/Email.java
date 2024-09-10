package com.codurance.dip;

public record Email(
        String to,
        String subject,
        String message
) {
}
