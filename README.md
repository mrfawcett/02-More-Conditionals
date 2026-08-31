# Honor Roll and Theme Park

**Unit 1 — Programming Fundamentals & Debugging** · Pairs with lecture 1.1 Day 2 (comparison operators, `if`/`else if`/`else`, `&&` `||` `!`)

Two small programs, four methods, and every one of them is a decision. A
school needs to know which list a student lands on based on GPA and behavior.
A theme park needs to know who is allowed on which ride based on age, height,
and who they came with. Nothing here needs a loop or a String method — just
numbers, booleans, and careful reading of "at least", "fewer than", and
"under". Read every rule twice. Most wrong answers on this assignment are
`>` where `>=` was meant.

---

## Honor Roll

You are writing a program to help a school decide whether a student qualifies
for the **Honor Roll**, the **Merit List**, or **No List**, based on their
grades and behavior record. The method you complete has three parameters:

- `gpa` — a number between 0.0 and 4.0
- `tardies` — number of tardies (an integer, 0 or more)
- `detentions` — number of detentions (an integer, 0 or more)

Apply the rules in this order:

**High GPA (3.5 or higher)**
- If the student has **no detentions**, they may qualify for the Honor Roll.
  - If they also have **fewer than 3** tardies → `"Honor Roll"`
  - Otherwise (3 or more tardies) → `"Merit List"`
- If a 3.5+ student **has a detention — even one** → `"No List"`.
  The Merit List rule below is only for GPAs from 2.5 to 3.49. A 3.5+ student
  does **not** fall back to it. `awardQualifier(3.5, 1, 1)` is `"No List"`.

**Middle GPA (2.5 to 3.49, inclusive)**
- **Fewer than 2** detentions → `"Merit List"`
- Otherwise (2 or more detentions) → `"No List"`
- Tardies do not matter in this range.

**Low GPA (below 2.5)** → `"No List"`, no matter what.

GPAs are given to two decimal places, so "up to 3.49" and "below 3.5" mean the
same thing; either comparison is fine.

Return exactly one of `"Honor Roll"`, `"Merit List"`, `"No List"`.

## Theme Park

You have been hired by a theme park to write a program that checks whether a
visitor is eligible to go on certain rides. Eligibility depends on the
visitor's age, height (in inches), and special conditions: having a VIP pass,
being with a parent/guardian, or being with a younger sibling.

**Extreme Coaster**
- Must be at least 16 years old **and** at least 60 inches tall.
- A VIP pass **lowers** both requirements: a VIP may ride at 14 or older
  **and** 55 inches or taller. The pass lowers the bar; it does not remove it.
  A 17-year-old VIP who is 54 inches tall cannot ride.

**Family River Ride**
- Must be at least 8 years old **and** at least 40 inches tall.
- A child **younger than 8** may ride if they are with a parent/guardian.
  **A parent replaces both requirements for an under-8**: a 5-year-old who is
  30 inches tall rides with a parent. Without a parent, an under-8 cannot ride
  no matter how tall they are.
- Riders who are 8 or older must meet the height rule themselves; a parent
  does not help them.

**Kiddie Carousel**
- Available to everyone **under 12**, no other conditions.
- Riders **12 or older** may ride only if they are with a sibling under 12.

---

## What you are given

| File | Status | Purpose |
|---|---|---|
| `src/main/java/HonorRoll.java` | **you complete this** | `awardQualifier`; `main` is a provided driver that prints your answers next to the expected ones |
| `src/main/java/ThemePark.java` | **you complete this** | the three `canRide…` methods |
| `src/test/java/*Test.java` | provided | the autograder's tests — read them |
| `pom.xml`, `grading.json`, `.gitignore` | provided | build and grading setup — do not edit |

## What to write

All four methods are `public static` and already declared. Fill in the bodies.
Do not change the headers.

| Method | Points | What it does |
|---|---|---|
| `String awardQualifier(double gpa, int tardies, int detentions)` | 40 | `"Honor Roll"`, `"Merit List"`, or `"No List"` by the rules above |
| `boolean canRideExtremeCoaster(int age, double height, boolean hasVIP)` | 25 | 16+/60+, or 14+/55+ with VIP |
| `boolean canRideFamilyRiver(int age, double height, boolean withParent)` | 20 | 8+/40+, or under 8 with a parent |
| `boolean canRideKiddieCarousel(int age, boolean withSiblingUnder12)` | 15 | under 12, or 12+ with a younger sibling |

### `awardQualifier`

Every input lands in exactly one of six cases:

| `gpa` | `detentions` | `tardies` | Returns |
|---|---|---|---|
| ≥ 3.5 | 0 | < 3 | `"Honor Roll"` |
| ≥ 3.5 | 0 | ≥ 3 | `"Merit List"` |
| ≥ 3.5 | ≥ 1 | any | `"No List"` |
| 2.5 – 3.49 | < 2 | any | `"Merit List"` |
| 2.5 – 3.49 | ≥ 2 | any | `"No List"` |
| < 2.5 | any | any | `"No List"` |

Worked example: `awardQualifier(3.6, 3, 0)`. GPA is high, no detentions, so
the student *may* qualify. But 3 tardies is not "fewer than 3". → `"Merit List"`.

**Trap:** the third row. A student with GPA 3.5 and one detention has a GPA in
the "high" band, so the middle-band rule never applies to them. If your code
falls through to a `gpa >= 2.5 && detentions < 2` check, you will return
`"Merit List"` and fail `AwardQualifierTest` test 3. Nest the tardies check
*inside* the no-detentions check, or write all six cases out.

### `canRideExtremeCoaster`

Two ways to qualify. Return `true` if either holds:
`age >= 16 && height >= 60`, or `hasVIP && age >= 14 && height >= 55`.

- `canRideExtremeCoaster(16, 60, false)` → `true` (boundaries count)
- `canRideExtremeCoaster(15, 57, true)` → `true` (VIP rule)
- `canRideExtremeCoaster(17, 54, true)` → `false` (VIP still needs 55)
- `canRideExtremeCoaster(14, 54.9, true)` → `false` (`height` is a `double`)

**Trap:** writing `if (hasVIP)` and then checking *only* the VIP rule is
fine — a VIP who meets the normal rule also meets the VIP rule, since 16 ≥ 14
and 60 ≥ 55. But writing the VIP branch without the height check is not.

### `canRideFamilyRiver`

Branch on age first.

- `age >= 8` → return `height >= 40`. The parent does not matter.
- `age < 8` → return `withParent`. The height does not matter.

- `canRideFamilyRiver(8, 40, false)` → `true`
- `canRideFamilyRiver(7, 39, true)` → `true` (parent overrides height)
- `canRideFamilyRiver(7, 42, false)` → `false` (tall, but under 8 with no parent)
- `canRideFamilyRiver(12, 39, false)` → `false` (8+ must meet the height rule)

**Trap:** requiring the height for an under-8 with a parent. Test 5 and
test 8 (`5, 30, true`) both expect `true`.

### `canRideKiddieCarousel`

`age < 12` → `true`. Otherwise → `withSiblingUnder12`. That is the whole
method — one line with `||` is enough.

- `canRideKiddieCarousel(11, false)` → `true`
- `canRideKiddieCarousel(12, false)` → `false` (12 is not under 12)
- `canRideKiddieCarousel(30, true)` → `true`

**Trap:** `age <= 12`.

---

## Examples

| Call | Result | Why |
|---|---|---|
| `awardQualifier(4.0, 2, 0)` | `"Honor Roll"` | high GPA, clean record, 2 tardies < 3 |
| `awardQualifier(3.5, 1, 1)` | `"No List"` | high GPA **with a detention** — never Merit List |
| `awardQualifier(2.6, 5, 0)` | `"Merit List"` | middle GPA, 0 detentions; tardies ignored |
| `awardQualifier(2.49, 0, 0)` | `"No List"` | just below 2.5 |
| `canRideExtremeCoaster(13, 60, true)` | `false` | tall enough, but VIP minimum age is 14 |
| `canRideFamilyRiver(5, 30, true)` | `true` | under 8 with a parent |
| `canRideKiddieCarousel(0, false)` | `true` | a baby is under 12 |

---

## Running the tests

`mvn test` runs everything; `mvn test -Dtest=<ClassName>` runs one rubric line.

| Test class | Rubric line | Points |
|---|---|---|
| `AwardQualifierTest` | HonorRoll.awardQualifier | 40 |
| `CanRideExtremeCoasterTest` | ThemePark.canRideExtremeCoaster | 25 |
| `CanRideFamilyRiverTest` | ThemePark.canRideFamilyRiver | 20 |
| `CanRideKiddieCarouselTest` | ThemePark.canRideKiddieCarousel | 15 |

The autograder awards a rubric line only when every test in that class passes.

You can also run `HonorRoll`'s `main` from your IDE: it prints your answer
next to the expected answer for four sample students.

## Suggested order

1. **`canRideKiddieCarousel`** — the simplest: one comparison and one
   boolean. Get a green rubric line and make sure your build works.
2. **`canRideFamilyRiver`** — branch on `age < 8` first, then decide what
   matters in each branch.
3. **`canRideExtremeCoaster`** — two `&&` conditions joined by `||`. Check
   the four boundary tests (16/60, 14/55, 54.9, 13).
4. **`awardQualifier`** — draw the six-row table above before you type.
   Write the `gpa >= 3.5` branch as an `if` with a nested `if`/`else`, then
   the `gpa >= 2.5` branch, then the `else`. Run the `main` driver, then the
   test class.

## Rules of the road

- AP Java subset only: `if`/`else if`/`else`, `&&`, `||`, `!`, comparison
  operators, `return`. No `switch`, no ternary tricks you cannot explain, no
  `var`.
- Do not change method headers or provided code (including `HonorRoll.main`).
- Do not touch `src/test`, `pom.xml`, `grading.json`, or `.github`. The
  autograder checks that they are byte-identical to the template before it
  runs a single test; if they differ it stops and awards nothing, and the
  change shows up in the roster.
- `awardQualifier` must **return** its String, spelled exactly as shown
  (`"Honor Roll"`, `"Merit List"`, `"No List"`). The tests forgive
  capitalization and stray spaces, not spelling.
