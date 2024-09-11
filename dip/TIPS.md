# Dependency Inversion Principle

See how the `BirthdayGreeter` _depends_ on the `EmailSender` class: `BirthdayGreeter` needs an instance of `EmailSender` to actually send the email.

To do this, it instantiates the concrete implementation with `new EmailSender()` then calls the required method. This part is contrary to the DIP, because the "higher-level" domain class `BirthdayGreeter` depends on a "lower-level" `EmailSender` infrastructure class.

In a perfect world, `BirthdayGreeter` should be able to do its work without _knowing_ the concrete details of how the emails get sent, it just needs "something" that offer this functionality: an interface. This would allow for the concrete implementation of `EmailSender` to be changed at any time without having to modify `BirthdayGreeter`, thus lowering the coupling between both classes.

Try making `EmailSender` an interface and passing it as a constructor argument to `BirthdayGreeter`, as is `EmployeeRepository`. See how the test (as a placeholder for a real application) can be modified to freely switch between several implementations of `EmailSender`: create for example variants like `SystemOutEmailSender` which prints to the console or `ScreamingEmailSender` which converts all text to upper-case, or `HtmlEmailSender` which adds HTML-tags around the text.

Notice that the need for mocking the `EmailSender` in the tests disappears as it can just be replaced with an alternative implementation for the test context.

Bonus:
* Make an interface out of `Clock` with a `FakeClock` implementation for the tests, that allows configuring the returned value in the constructor and see how this affects the testing/mocking
* Use `record`s for `Email` and `Employee`
* Cleanup the code using your IDE's features
