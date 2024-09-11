# Liskov Substitution Principle

Notice how the abstract `Vehicle` class proposes methods `fillUpWithFuel` and `chargeBattery` that only make sense for _some_ of its children.

This goes against the Liskov Substitution Principle, because any code using the `Vehicle` class to call one of these methods (such as the `FillingStation`) _has_ to know which subclass it is dealing with in order to perform the correct actions.

Try removing the `instanceof` checks: the `FillingStation` calls "forbidden" methods in the test and explodes.

One can argue that the `fillUpWithFuel` and `chargeBattery` methods do not make sense in the `Vehicle` class. If possible, it should be removed so that each concrete implementation provides its own fueling/charging method without overriding from `Vehicle`. See what needs to change in `FillingStation` and the tests to make the code compile again with this change.

Another idea is to make a generic fueling/charging method in `Vehicle` and having each concrete implementation perform the correct operation. See what needs to change in `FillingStation` and the tests to make the code compile again with this change.
