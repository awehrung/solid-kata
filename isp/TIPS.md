# Interface Segregation Principle

Both `Bird` and `Dog` implement the `Animal` interface, therefore they are _forced_ to implement all three methods `fly`, `run`, and `bark`.

This is error-inducing because birds are known to _not_ bark and dogs usually do _not_ fly (at least not the ones in this repository). This problem is a symptom of poor interface segregation, the `Animal` interface just does not make much sense here.

Try splitting up `Animal` in three interfaces `Flyer`, `Runner` and `Barker`, and have `Bird` and `Dog` implement only the ones that make sense for them. Should the `Animal` interface be needed somewhere else in the codebase for legacy reasons, it is still possible to recreate it by extending the three specific interfaces.

Now with the split interfaces, it is impossible to call `dog.fly()` or `bird.bark()`, reducing the potential for errors. However, both animals are still "linked" by the `Runner` interface and code that needs to call `.run()` on an object can do so without "knowing" whether it is a `Bird` or a `Dog`, keeping the useful abstraction.
