# Open/Closed Principle

See how the types of `Employee`s are differentiated by an `EmployeeType` attribute and reflect how the code would need to change if one were to add a new type of employee.

Not only would the `EmployeeType` enum have to be extended, but the `switch/case` block in `Employee` would have to be changed too. This second part goes against the Open/Closed Principle. In a real-world version of this example, we may not be able to _change_ the `Employee` class but would still need the possibility of adding new employee types. How to design it from scratch so that it allows for _extensions_ without _modification_?

A solution for this problem is making `Employee` an interface or abstract class and having different concrete types represent the employee types. Each concrete class has its own constructor and implementation of `payAmount`, and the `EmployeeType` enum can be removed.

Try adding a new employee type "trainee", which only receives 80% of their assigned salary due to random discriminatory measures, and notice what needs to change for this feature in the original and refactored version.

Bonus:
* Use `record`s for the concrete `Employee` subtypes
* Cleanup the code using your IDE's features before starting the refactoring
