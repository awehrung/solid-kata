package com.codurance.ocp;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Employee {
    protected final int salary;

    public abstract int payAmount();
}
