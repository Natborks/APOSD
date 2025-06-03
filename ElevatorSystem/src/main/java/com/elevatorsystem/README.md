# Elevator System Simulation (Project 1)

This is the first in a series of small projects designed to explore and apply the design principles from *A Philosophy of Software Design* by John Ousterhout.

## 📘 Project Purpose

The goal of this project is to design and simulate an elevator system that allows users to:
- Request elevator pickups from a given floor and direction (up/down).
- Track the status of all elevators in the system.
- Assign elevators based on a strategy (priority scoring can be added later).

This project is written in Java 17 and uses Maven for build and dependency management.

---

## 🔍 Design Notes

### ✅ Deep Modules and Small Interfaces
A key goal in this project is to emphasize deep modules—modules that hide complex logic behind a small surface area. For example:
- The ElevatorSystem acts as the main façade for interaction.
- Internals like Elevator, PickupRequest, and ElevatorAssignmentStrategy are encapsulated with minimal public exposure.

###  Pass-Through Method: A Necessary Compromise
The `step()` method in the ElevatorSystem class delegates to each individual `Elevator.step()` method. While this may violate the "Pass-Through Method" rule (because it simply forwards a call), 
it's unavoidable here:

### Avoiding Temporal Decomposition
In the Elevator class, we deliberately avoid decomposing the request handling process into multiple narrowly-focused methods like:
- `validateRequest()`
- `enqueueRequest()`
- `maybeTriggerMove()`

While these might seem "cleaner" at first glance, they introduce temporal coupling—you must know the correct order to use them. Instead, we use a single method like `addRequest(int floor)` to:
- Minimize the cognitive load for future readers and maintainers.
- Keep the interface lean and intention-revealing.

---

## 🚀 Running the Project

To compile and run:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.elevatorsystem.Main"
