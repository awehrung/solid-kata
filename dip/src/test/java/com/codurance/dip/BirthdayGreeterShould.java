package com.codurance.dip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.MonthDay;
import java.util.Collections;

import static com.codurance.dip.EmployeeBuilder.anEmployee;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BirthdayGreeterShould {
    private static final int CURRENT_MONTH = 7;
    private static final int CURRENT_DAY_OF_MONTH = 9;
    private static final MonthDay TODAY = MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH);

    @Mock
    private EmployeeRepository employeeRepository;
    @Spy
    private Clock clock = new FakeClock(TODAY);
    @Spy
    private EmailSender emailSender = new SystemOutEmailSender();

    @InjectMocks
    private BirthdayGreeter birthdayGreeter;

    private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();

    @Test
    public void should_send_greeting_email_to_employee() {
        System.setOut(new PrintStream(consoleContent));
        Employee employee = anEmployee().build();
        given(employeeRepository.findEmployeesBornOn(TODAY)).willReturn(Collections.singletonList(employee));

        birthdayGreeter.sendGreetings();

        assertThat(consoleContent.toString()).isEqualTo(
                "To: %s, Subject: Happy birthday!, Message: Happy birthday, dear %s!".formatted(
                        employee.emailAddress(),
                        employee.firstName()
                )
        );
    }
}
