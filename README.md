# CoreJava17SealClass

What is seal class ?

Key Concepts
Controlled Inheritance: Before sealed classes, a class could either be open for extension by all classes or completely closed (using the final modifier). 
						Sealed classes offer a middle ground, allowing the developer to specify a fixed, finite set of permitted subclasses.
sealed and permits Keywords: A class is declared as sealed using the sealed modifier, and the allowed subclasses are listed using the permits clause.
Subclass Modifiers: Every permitted subclass must declare exactly one of the following modifiers:
final: The subclass cannot be extended further (e.g., public final class Circle extends Shape).
sealed: The subclass can be extended, but it also imposes its own restrictions on its subclasses (e.g., public sealed class Rectangle extends Shape permits FilledRectangle).
non-sealed: The subclass breaks the sealing hierarchy, allowing any class to extend it without restriction (e.g., public non-sealed class Square extends Shape).

Important Rules
Location: The sealed class and its permitted subclasses must be in the same module (if using modules) or the same package (if in an unnamed module).
Direct Extension: Permitted subclasses must directly extend the sealed superclass.
Implicit Permits: If the subclasses are defined in the same file as the sealed class, the permits clause can be omitted; the compiler will infer them. 



// STEP 1: Define the Sealed Base Class
public sealed class Employee permits FullTimeEmployee, Manager, Intern {
    // Shared logic here
}

// STEP 2: Every permitted subclass MUST choose a path:

// Path A: The "End" (Final)
// No one can ever extend FullTimeEmployee.
public final class FullTimeEmployee extends Employee { }

// Path B: The "Controlled Continuer" (Sealed)
// Only TechManager is allowed to extend Manager.
public sealed class Manager extends Employee permits TechManager { }

final class TechManager extends Manager { }

// Path C: The "Gate Opener" (Non-Sealed)
// This breaks the seal. Anyone can extend Intern now.
public non-sealed class Intern extends Employee { }

class SummerIntern extends Intern { } // Valid because Intern is non-sealed
 


| Feature                  | Abstract | Final | Sealed     |
| ------------------------ | -------- | ----- | ---------- |
| Can extend               | Yes      | No    | Controlled |
| Compile-time restriction | ❌        | ❌     | ✅          |
| Domain modeling          | ❌        | ❌     | ✅          |
| Enterprise safety        | ⚠️       | ⚠️    | ✅          |

When NOT to Use Sealed Classes

❌ When extensibility by third parties is required
❌ Framework base classes (Spring entities, controllers)
❌ Plugin-based architectures


public sealed interface DomainEvent
        permits PatientAdmitted, PatientDischarged {}
✔ Event-driven architectures benefit greatly
✔ Ensures consumers handle all known events
✔ Works perfectly with switch expressions


when we design the layer between two services then use seal class.
