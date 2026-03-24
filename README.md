# CoreJava17SealClass

**What is seal class ?**

Key Concepts <br>
**Controlled Inheritance:** Before sealed classes, a class could either be open for extension by all classes or completely closed (using the final modifier). <br>
						Sealed classes offer a middle ground, allowing the developer to specify a fixed, finite set of permitted subclasses. <br>
**sealed and permits Keywords:** A class is declared as sealed using the sealed modifier, and the allowed subclasses are listed using the permits clause. <br>
**Subclass Modifiers: ** Every permitted subclass must declare exactly one of the following modifiers:<br>
               **final:** The subclass cannot be extended further (e.g., public final class Circle extends Shape). <br>
               **sealed:** The subclass can be extended, but it also imposes its own restrictions on its subclasses (e.g., public sealed class Rectangle extends Shape permits FilledRectangle). <br>
                **non-sealed:** The subclass breaks the sealing hierarchy, allowing any class to extend it without restriction (e.g., public non-sealed class Square extends Shape). <br>

**Important Rules** <br>
**Location:** The sealed class and its permitted subclasses must be in the same module (if using modules) or the same package (if in an unnamed module). <br>
**Direct Extension:** Permitted subclasses must directly extend the sealed superclass. <br>
**Implicit Permits:** If the subclasses are defined in the same file as the sealed class, the permits clause can be omitted; the compiler will infer them. <br>



// STEP 1: Define the Sealed Base Class <br>
public sealed class Employee permits FullTimeEmployee, Manager, Intern { <br>
    // Shared logic here <br>
} <br>

// STEP 2: Every permitted subclass MUST choose a path: <br>

// Path A: The "End" (Final)  <br>
// No one can ever extend FullTimeEmployee. <br>
public final class FullTimeEmployee extends Employee { } <br>

// Path B: The "Controlled Continuer" (Sealed) <br>
// Only TechManager is allowed to extend Manager. <br>
public sealed class Manager extends Employee permits TechManager { } <br>

final class TechManager extends Manager { }  <br>

// Path C: The "Gate Opener" (Non-Sealed) <br>
// This breaks the seal. Anyone can extend Intern now. <br>
public non-sealed class Intern extends Employee { } <br>

class SummerIntern extends Intern { } // Valid because Intern is non-sealed <br>
 


| Feature                  | Abstract | Final | Sealed     |
| ------------------------ | -------- | ----- | ---------- |
| Can extend               | Yes      | No    | Controlled |
| Compile-time restriction | ❌        | ❌     | ✅          |
| Domain modeling          | ❌        | ❌     | ✅          |
| Enterprise safety        | ⚠️       | ⚠️    | ✅          |

When NOT to Use Sealed Classes <br>

❌ When extensibility by third parties is required <br>
❌ Framework base classes (Spring entities, controllers) <br>
❌ Plugin-based architectures <br>


public sealed interface DomainEvent <br>
        permits PatientAdmitted, PatientDischarged {}  <br>
✔ Event-driven architectures benefit greatly <br>
✔ Ensures consumers handle all known events <br>
✔ Works perfectly with switch expressions <br>


when we design the layer between two services then use seal class. <br>
