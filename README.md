
---

## Project Structure

```
src/main/java/com/tekup/
├── ex1_Strategy/
│   ├── Main_ex1_Strategy.java      # Demo of Strategy pattern
│   ├── SortStrategy.java           # Strategy interface
│   ├── Sorter.java                 # Context class
│   ├── SortAscending.java          # Concrete strategy
│   ├── SortDescending.java         # Concrete strategy
│   └── SortByLength.java           # Concrete strategy
│
├── ex2_Command/
│   ├── Main_ex2_Command.java       # Demo of Command pattern
│   ├── Command.java                # Command interface
│   ├── ShoppingCard.java           # Receiver
│   ├── AddProductCommand.java      # Concrete command
│   ├── RemoveProducCommand.java    # Concrete command
│   └── ValidateOrderCommand.java   # Concrete command
│
├── ex3_Observer/
│   ├── Main_ex3_Observer.java      # Demo of Observer pattern
│   ├── Subject.java                # Abstract subject
│   ├── Order.java                  # Concrete subject
│   ├── Observer.java               # Observer interface
│   ├── CustomerObserver.java       # Concrete observer
│   ├── ShippingTeamObserver.java   # Concrete observer
│   └── SupportTeamObserver.java    # Concrete observer
│
└── ex4_ChainOfResponsibility/
    ├── Main_ex4_ChainOfResponsibility.java  # Demo of Chain pattern
    ├── Handler.java                # Abstract handler
    ├── Request.java                # Request object
    ├── Technician.java             # Concrete handler
    ├── Supervisor.java             # Concrete handler
    └── Manager.java                # Concrete handler
```

---

## How to Run

### Prerequisites
- Java 8 or higher
- Maven 3.x

### Compile the Project
```bash
mvn clean compile
```

### Run All Examples
```bash
# Strategy Pattern
mvn exec:java -Dexec.mainClass="com.tekup.ex1_Strategy.Main_ex1_Strategy"

# Command Pattern
mvn exec:java -Dexec.mainClass="com.tekup.ex2_Command.Main_ex2_Command"

# Observer Pattern
mvn exec:java -Dexec.mainClass="com.tekup.ex3_Observer.Main_ex3_Observer"

# Chain of Responsibility Pattern
mvn exec:java -Dexec.mainClass="com.tekup.ex4_ChainOfResponsibility.Main_ex4_ChainOfResponsibility"
```

### Package the Project
```bash
mvn package
```

---

## Requirements

- **Java Version:** 8 or higher
- **Build Tool:** Apache Maven 3.x
- **IDE (Optional):** IntelliJ IDEA, Eclipse, or VS Code with Java extensions

---

## Key Takeaways

### Design Pattern Comparison

| Pattern | Purpose | Key Characteristic | Real-World Example |
|---------|---------|-------------------|-------------------|
| **Strategy** | Define family of algorithms | Interchangeable behaviors | Payment methods (Credit Card, PayPal, Cash) |
| **Command** | Encapsulate requests as objects | Queuing & undo operations | Remote control, Transaction system |
| **Observer** | One-to-many notification | Automatic updates | Newsletter subscriptions, Event listeners |
| **Chain of Responsibility** | Pass request along chain | Decoupled request handling | Support ticket escalation, Logging levels |

### Benefits of Behavioral Patterns

1. **Flexibility:** Easy to add new behaviors without modifying existing code
2. **Maintainability:** Clear separation of concerns
3. **Reusability:** Components can be reused in different contexts
4. **Loose Coupling:** Objects interact without tight dependencies
5. **Open/Closed Principle:** Open for extension, closed for modification

---

## Additional Resources

- **Design Patterns Book:** "Design Patterns: Elements of Reusable Object-Oriented Software" by Gang of Four
- **Refactoring Guru:** [refactoring.guru/design-patterns](https://refactoring.guru/design-patterns)
- **Source Making:** [sourcemaking.com/design_patterns](https://sourcemaking.com/design_patterns)

---

## License

This project is created for educational purposes as part of TD3 coursework.

---

## Author

**Course:** Design Patterns (Behavioral Patterns)
**Institution:** TEK-UP University
**Date:** January 2026
# Behavioral Design Patterns - TD3

This project demonstrates the implementation of four fundamental **Behavioral Design Patterns** in Java. Each pattern is organized in its own package with complete working examples.

## 📋 Table of Contents
- [Project Overview](#project-overview)
- [Design Patterns Implemented](#design-patterns-implemented)
  - [1. Strategy Pattern](#1-strategy-pattern)
  - [2. Command Pattern](#2-command-pattern)
  - [3. Observer Pattern](#3-observer-pattern)
  - [4. Chain of Responsibility Pattern](#4-chain-of-responsibility-pattern)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Requirements](#requirements)

---

## Project Overview

Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects. They help in defining how objects interact and communicate with each other in a way that increases flexibility in carrying out communication.

This project provides practical implementations of four key behavioral patterns with real-world scenarios.

---

## Design Patterns Implemented

### 1. Strategy Pattern
**Package:** `com.tekup.ex1_Strategy`

#### Purpose
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

#### Problem Solved
When you have multiple ways to perform an operation (e.g., different sorting algorithms), you want to:
- Avoid multiple conditional statements
- Make algorithms interchangeable at runtime
- Add new algorithms without modifying existing code

#### Components
- **`SortStrategy<T>`** (Interface): Defines the contract for all sorting strategies
- **`Sorter<T>`** (Context): Maintains a reference to a Strategy object and delegates the sorting operation
- **Concrete Strategies:**
  - `SortAscending`: Sorts integers in ascending order
  - `SortDescending`: Sorts integers in descending order
  - `SortByLength`: Sorts strings by their length

#### How It Works
```
Client → Sorter (Context) → SortStrategy (Interface) ← Concrete Strategies
```

#### Usage Example
```java
Sorter<Integer> sorter = new Sorter<>();
List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 4);

// Switch strategies at runtime
sorter.setStrategy(new SortAscending());
sorter.sort(numbers);  // [1, 2, 4, 5, 8]

sorter.setStrategy(new SortDescending());
sorter.sort(numbers);  // [8, 5, 4, 2, 1]
```

#### When to Use
- When you have multiple algorithms for a specific task
- When you want to avoid exposing complex algorithm-specific data structures
- When you need to switch between different behaviors at runtime

#### Run the Example
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.tekup.ex1_Strategy.Main_ex1_Strategy"
```

---

### 2. Command Pattern
**Package:** `com.tekup.ex2_Command`

#### Purpose
The Command pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

#### Problem Solved
When you need to:
- Decouple the object that invokes the operation from the one that knows how to perform it
- Queue operations for later execution
- Support undo/redo functionality
- Log changes so that they can be reapplied in case of a system crash

#### Components
- **`Command`** (Interface): Declares the execute method
- **`ShoppingCard`** (Receiver): The object that performs the actual work
- **Concrete Commands:**
  - `AddProductCommand`: Adds a product to the shopping cart
  - `RemoveProducCommand`: Removes a product from the shopping cart
  - `ValidateOrderCommand`: Validates the order

#### How It Works
```
Client → Command (Interface) → Concrete Commands → Receiver (ShoppingCard)
```

#### Usage Example
```java
ShoppingCard cart = new ShoppingCard();

Command addLaptop = new AddProductCommand(cart, "Laptop");
Command addPhone = new AddProductCommand(cart, "Smartphone");
Command removeItem = new RemoveProducCommand(cart, "Laptop");
Command validate = new ValidateOrderCommand(cart);

// Execute commands
addLaptop.execute();    // Added product Laptop
addPhone.execute();     // Added product Smartphone
removeItem.execute();   // Removed product Laptop
validate.execute();     // Validating order
```

#### When to Use
- When you need to parameterize objects with operations
- When you need to queue operations for later execution
- When you want to support undo/redo operations
- When you want to log operations for auditing or recovery

#### Run the Example
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.tekup.ex2_Command.Main_ex2_Command"
```

---

### 3. Observer Pattern
**Package:** `com.tekup.ex3_Observer`

#### Purpose
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

#### Problem Solved
When you need to:
- Maintain consistency between related objects without making them tightly coupled
- Notify multiple objects about state changes
- Add or remove observers dynamically at runtime

#### Components
- **`Subject`** (Abstract Class): Manages observers and provides notification mechanism
- **`Order`** (Concrete Subject): Extends Subject and maintains state (order status)
- **`Observer`** (Interface): Defines the update method for observers
- **Concrete Observers:**
    - `CustomerObserver`: Notifies customers about order status changes
    - `ShippingTeamObserver`: Notifies shipping team about order updates
    - `SupportTeamObserver`: Notifies support team about order events

#### How It Works
```
Order (Subject) → notifies → Multiple Observers
                             ├── CustomerObserver
                             ├── ShippingTeamObserver
                             └── SupportTeamObserver
```

#### Usage Example
```java
Order order = new Order("CMD-001");

// Register observers
order.addObserver(new CustomerObserver("Mahmoud"));
order.addObserver(new ShippingTeamObserver());
order.addObserver(new SupportTeamObserver());

// Change state - all observers are automatically notified
order.setStatus("CONFIRMÉE");  // All 3 observers notified
order.setStatus("EXPÉDIÉE");   // All 3 observers notified
order.setStatus("LIVRÉE");     // All 3 observers notified
```

#### When to Use
- When changes to one object require changing others
- When an object should notify other objects without making assumptions about who they are
- When you need a publish-subscribe model
- When you want loose coupling between interacting objects

#### Run the Example
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.tekup.ex3_Observer.Main_ex3_Observer"
```

---

### 4. Chain of Responsibility Pattern
**Package:** `com.tekup.ex4_ChainOfResponsibility`

#### Purpose
The Chain of Responsibility pattern avoids coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. It chains the receiving objects and passes the request along the chain until an object handles it.

#### Problem Solved
When you need to:
- Decouple request senders from receivers
- Allow multiple objects to handle a request without the sender knowing which object will ultimately handle it
- Add or modify handlers dynamically
- Avoid hard-wiring the request handling logic

#### Components
- **`Handler`** (Abstract Class): Defines interface for handling requests and maintains reference to next handler
- **`Request`**: Encapsulates request information (type and description)
- **Concrete Handlers:**
    - `Technician`: Handles "technical" requests
    - `Supervisor`: Handles "supervisory" requests
    - `Manager`: Handles "managerial" requests

#### How It Works
```
Request → Technician → Supervisor → Manager → (No handler)
          (checks)     (checks)     (checks)
```

Each handler:
1. Checks if it can handle the request
2. If yes, processes it
3. If no, passes it to the next handler in the chain

#### Usage Example
```java
// Build the chain
Handler technician = new Technician();
Handler supervisor = new Supervisor();
Handler manager = new Manager();

technician.setNextHandler(supervisor);
supervisor.setNextHandler(manager);

// Send requests through the chain
technician.handleRequest(new Request("technical", "Network issue"));
// Output: Technician is handling the request: Network issue

technician.handleRequest(new Request("managerial", "Budget approval"));
// Output: Manager is handling the request: Budget approval

technician.handleRequest(new Request("other", "Unknown request"));
// Output: No handler available for the request: Unknown request
```

#### When to Use
- When more than one object may handle a request
- When you want to issue a request to one of several objects without specifying the receiver explicitly
- When the set of handlers should be specified dynamically
- When you want to avoid coupling the sender to the receiver

#### Run the Example
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.tekup.ex4_ChainOfResponsibility.Main_ex4_ChainOfResponsibility"
```

