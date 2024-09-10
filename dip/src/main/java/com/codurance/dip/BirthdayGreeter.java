package com.codurance.dip;

import lombok.RequiredArgsConstructor;

import java.time.MonthDay;

@RequiredArgsConstructor
public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private final EmailSender emailSender;

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(emailSender::send);
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.firstName());
        return new Email(employee.emailAddress(), "Happy birthday!", message);
    }
}
