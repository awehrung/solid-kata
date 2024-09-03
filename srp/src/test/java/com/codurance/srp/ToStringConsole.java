package com.codurance.srp;

public class ToStringConsole implements Console {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void printLine(String line) {
        sb.append(line).append("\n");
    }

    public String content() {
        return sb.toString();
    }

    public void clear() {
        sb = new StringBuilder();
    }
}
