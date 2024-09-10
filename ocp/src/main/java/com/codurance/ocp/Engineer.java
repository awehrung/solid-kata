package com.codurance.ocp;

public record Engineer(int salary) implements Employee {

    @Override
    public int payAmount() {
        return salary;
    }
}
