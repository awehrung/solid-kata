# Single Responsibility Principle

The class `AccountService` is very central to this module and approaches the "god-class" status: it does absolutely everything, getting and printing statements, as well as transferring money.

This behaviour is contradictory to the Single Responsibility Principle. Having very different functionalities such as these implemented within the same class makes it increasingly difficult to maintain, as it grows in length and loses focus on a specific job. There is no _single solution_ to this problem.

One approach could be to keep the `AccountService` as central entry point and to delegate its fine-grained behaviour to more specific classes, such as a `TransactionPrinter` and a `TransactionBuilder` which are respectively responsible for printing the ledger and creating timestamped transactions.

Another idea is to directly split the `AccountService` into two classes `AccountPrinter` and `MoneyTransferService` which both depend on the `TransactionRepository` to interact with the persisted data.

Notice how easier it is to understand and explain what each class does after trying out those changes.
