package com.codurance.ocp;

public record Manager(int salary, int bonus) implements Employee {

    @Override
    public int payAmount() {
        return salary + bonus;
    }
}
