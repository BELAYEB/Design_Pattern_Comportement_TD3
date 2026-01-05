# Behavioral Design Patterns - TD3

This project demonstrates five behavioral design patterns commonly used in object-oriented software development. Each pattern is implemented in a separate package with practical examples.

---

## Table of Contents

1. [Strategy Pattern](#1-strategy-pattern)
2. [Command Pattern](#2-command-pattern)
3. [Observer Pattern](#3-observer-pattern)
4. [Chain of Responsibility Pattern](#4-chain-of-responsibility-pattern)
5. [State Pattern](#5-state-pattern)

---

## 1. Strategy Pattern

**Package:** `com.tekup.ex1_Strategy`

### Purpose
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from the clients that use it.

### Structure

```
┌─────────────────┐         ┌──────────────────────┐
│     Sorter      │────────>│   <<interface>>      │
│   (Context)     │         │    SortStrategy<T>   │
├─────────────────┤         ├──────────────────────┤
│ - strategy      │         │ + sort(List<T>)      │
│ + setStrategy() │         └──────────────────────┘
│ + sort()        │                    △
└─────────────────┘                    │
                           ┌───────────┼───────────┐
                           │           │           │
                  ┌────────┴──┐ ┌──────┴─────┐ ┌───┴──────────┐
                  │SortAscending│SortDescending│ SortByLength │
                  └────────────┘└─────────────┘└──────────────┘
```

### Key Components

| Component | Role |
|-----------|------|
| `SortStrategy<T>` | Strategy interface defining the sorting contract |
| `Sorter<T>` | Context class that uses a strategy |
| `SortAscending` | Concrete strategy for ascending order |
| `SortDescending` | Concrete strategy for descending order |
| `SortByLength` | Concrete strategy for sorting by string length |

### Use Cases
- Multiple algorithms for the same task (sorting, validation, compression)
- Runtime algorithm switching
- Avoiding conditional statements for selecting behaviors
- Isolating algorithm-specific code from business logic

---

## 2. Command Pattern

**Package:** `com.tekup.ex2_Command`

### Purpose
The Command pattern encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. It also supports undoable operations.

### Structure

```
┌─────────────────┐         ┌──────────────────────┐
│  <<interface>>  │         │    ShoppingCard      │
│    Command      │         │     (Receiver)       │
├─────────────────┤         ├──────────────────────┤
│ + execute()     │         │ + addProduct()       │
└─────────────────┘         │ + removeProduct()    │
         △                  │ + validateOrder()    │
         │                  └──────────────────────┘
         │                            △
┌────────┼────────────────────────────┤
│        │                            │
┌───────┴────────┐  ┌────────────────┴────┐  ┌─────────────────────┐
│AddProductCommand│  │RemoveProductCommand│  │ValidateOrderCommand│
├─────────────────┤  ├────────────────────┤  ├─────────────────────┤
│ - shoppingCard  │  │ - shoppingCard     │  │ - shoppingCard      │
│ - productName   │  │ - productName      │  │                     │
└─────────────────┘  └────────────────────┘  └─────────────────────┘
```

### Key Components

| Component | Role |
|-----------|------|
| `Command` | Interface declaring the execution method |
| `ShoppingCard` | Receiver that performs the actual operations |
| `AddProductCommand` | Concrete command to add a product |
| `RemoveProductCommand` | Concrete command to remove a product |
| `ValidateOrderCommand` | Concrete command to validate an order |

### Use Cases
- Implementing undo/redo functionality
- Queuing and scheduling operations
- Transactional behavior
- Macro recording (combining multiple commands)
- Decoupling invoker from receiver

---

## 3. Observer Pattern

**Package:** `com.tekup.ex3_Observer`

### Purpose
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

### Structure

```
┌─────────────────────┐              ┌──────────────────────┐
│      Subject        │              │    <<interface>>     │
│     (Abstract)      │─────────────>│      Observer        │
├─────────────────────┤              ├──────────────────────┤
│ - observers: List   │              │ + update(Order)      │
│ + addObserver()     │              └──────────────────────┘
│ + removeObserver()  │                        △
│ + notifyObservers() │                        │
└─────────────────────┘            ┌───────────┼───────────┐
         △                         │           │           │
         │              ┌──────────┴───┐ ┌─────┴──────┐ ┌───┴────────────┐
    ┌────┴────┐         │CustomerObserver│ShippingTeam││SupportTeamObserver│
    │  Order  │         │              ││Observer    ││                   │
    ├─────────┤         └──────────────┘└────────────┘└───────────────────┘
    │-orderId │
    │-status  │
    │+setStatus()|
    └─────────┘
```

### Key Components

| Component | Role |
|-----------|------|
| `Subject` | Abstract class managing observer registration and notification |
| `Observer` | Interface for objects that should be notified of changes |
| `Order` | Concrete subject that notifies observers when status changes |
| `CustomerObserver` | Concrete observer representing a customer |
| `ShippingTeamObserver` | Concrete observer representing the shipping team |
| `SupportTeamObserver` | Concrete observer representing the support team |

### Use Cases
- Event handling systems
- Real-time notifications (order status, stock updates)
- Model-View-Controller (MVC) architectures
- Distributed event handling
- Pub/Sub messaging systems

---

## 4. Chain of Responsibility Pattern

**Package:** `com.tekup.ex4_ChainOfResponsibility`

### Purpose
The Chain of Responsibility pattern avoids coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. It chains the receiving objects and passes the request along the chain until an object handles it.

### Structure

```
┌────────────────────┐
│      Handler       │
│    (Abstract)      │──────────┐
├────────────────────┤          │
│ - nextHandler      │<─────────┘
│ + setNextHandler() │
│ + handleRequest()  │
└────────────────────┘
         △
         │
    ┌────┼──────────────────┐
    │    │                  │
┌───┴─────┐  ┌──────────┐  ┌┴────────┐
│Technician│  │Supervisor│  │ Manager │
├──────────┤  ├──────────┤  ├─────────┤
│handleReq()│ │handleReq()│ │handleReq()|
└──────────┘  └──────────┘  └─────────┘

Request Flow:
┌─────────┐    ┌──────────┐    ┌──────────┐    ┌─────────┐
│ Request │───>│Technician│───>│Supervisor│───>│ Manager │
└─────────┘    └──────────┘    └──────────┘    └─────────┘
```

### Key Components

| Component | Role |
|-----------|------|
| `Handler` | Abstract class defining the chain structure and handling interface |
| `Request` | Object containing request type and description |
| `Technician` | Handles technical requests |
| `Supervisor` | Handles supervisor-level requests |
| `Manager` | Handles management-level requests |

### Use Cases
- Event bubbling in UI frameworks
- Middleware pipelines (authentication, logging, validation)
- Approval workflows (expense approvals, leave requests)
- Help desk ticket escalation
- Exception handling chains

---

## 5. State Pattern

**Package:** `com.tekup.ex5_State`

### Purpose
The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

### Structure

```
┌─────────────────┐         ┌──────────────────────┐
│   UserContext   │────────>│    <<interface>>     │
│    (Context)    │         │      UserState       │
├─────────────────┤         ├──────────────────────┤
│ - state         │         │ + login(UserContext) │
│ - username      │         │ + logout(UserContext)|
│ + setState()    │         │ + lock(UserContext)  │
│ + login()       │         └──────────────────────┘
│ + logout()      │                    △
│ + lock()        │                    │
└─────────────────┘         ┌──────────┼──────────┐
                            │          │          │
                   ┌────────┴───┐ ┌────┴─────┐ ┌───┴────────┐
                   │Disconnected│ │Connected │ │LockedState │
                   │   State    │ │  State   │ │            │
                   └────────────┘ └──────────┘ └────────────┘
```

### State Transitions

```
                    login()
    ┌───────────────────────────────────────┐
    │                                       ▼
┌───┴──────────┐     lock()      ┌───────────────┐
│  Connected   │────────────────>│    Locked     │
└──────────────┘                 └───────────────┘
    │                                   │
    │ logout()                          │ login()
    ▼                                   ▼
┌──────────────┐                 ┌───────────────┐
│ Disconnected │<────────────────│    Locked     │
└──────────────┘     logout()    └───────────────┘
```

### Key Components

| Component | Role |
|-----------|------|
| `UserState` | Interface defining state-dependent behaviors |
| `UserContext` | Context class maintaining the current state |
| `ConnectedState` | State when user is logged in |
| `DisconnectedState` | State when user is logged out |
| `LockedState` | State when user account is locked |

### Use Cases
- User session management (connected, disconnected, locked)
- Order lifecycle (pending, processing, shipped, delivered)
- Media player controls (playing, paused, stopped)
- Document workflow (draft, review, published)
- TCP connection states

---

## Summary Comparison

| Pattern | Intent | Key Benefit |
|---------|--------|-------------|
| **Strategy** | Encapsulate interchangeable algorithms | Runtime algorithm switching |
| **Command** | Encapsulate requests as objects | Decouple invoker from receiver |
| **Observer** | One-to-many dependency notification | Loose coupling between subjects and observers |
| **Chain of Responsibility** | Pass request along a chain of handlers | Decouple sender from receiver |
| **State** | Alter behavior based on internal state | Eliminate state-based conditionals |

---

## Project Structure

```
src/main/java/com/tekup/
├── ex1_Strategy/           # Strategy Pattern
├── ex2_Command/            # Command Pattern
├── ex3_Observer/           # Observer Pattern
├── ex4_ChainOfResponsibility/  # Chain of Responsibility Pattern
└── ex5_State/              # State Pattern
```

---

## How to Run

1. Ensure you have Java 8+ and Maven installed
2. Build the project:
   ```bash
   mvn clean compile
   ```
3. Run individual examples from each package's `Main_ex*` class

---

## References

- **Gang of Four (GoF)**: *Design Patterns: Elements of Reusable Object-Oriented Software*
- **Head First Design Patterns** by Eric Freeman & Elisabeth Robson

---

© 2026 TEKUP - Behavioral Design Patterns TD3

