package com.codurance.dip;

import lombok.RequiredArgsConstructor;

import java.time.MonthDay;

@RequiredArgsConstructor
public class FakeClock implements Clock {
    private final MonthDay fixedMonthDay;
    
    @Override
    public MonthDay monthDay() {
        return fixedMonthDay;
    }
}
