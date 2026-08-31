/** READ FIRST
 * You have been hired by a theme park to write a program that checks whether
 * a visitor is eligible to go on certain rides. Eligibility depends on the
 * visitor's age, height (in inches), and special conditions: having a VIP
 * pass, being with a parent/guardian, or being with a younger sibling.
 *
 * Ride Rules
 *
 * Extreme Coaster:
 *      Must be at least 16 years old AND at least 60 inches tall.
 *      A VIP pass LOWERS both requirements: a VIP may ride at 14 or older
 *      AND 55 inches or taller. A VIP who is under 14 or under 55 inches
 *      still cannot ride -- the pass lowers the bar, it does not remove it.
 *
 * Family River Ride:
 *      Must be at least 8 years old AND at least 40 inches tall.
 *      A child younger than 8 may ride if they are with a parent/guardian.
 *      Being with a parent replaces BOTH requirements for an under-8: a
 *      5-year-old who is 30 inches tall rides with a parent. Without a
 *      parent, an under-8 cannot ride no matter how tall they are.
 *      Riders who are 8 or older must meet the height rule themselves; a
 *      parent does not help them.
 *
 * Kiddie Carousel:
 *      Available to everyone under 12 years old, no other conditions.
 *      Riders 12 or older may ride only if they are with a sibling who is
 *      under 12.
 */

public class ThemePark {
    public static void main(String[] args) {
        // Try your methods here. The autograder ignores main.
        System.out.println(canRideExtremeCoaster(15, 57, true));  // true
        System.out.println(canRideFamilyRiver(7, 39, true));      // true
        System.out.println(canRideKiddieCarousel(12, false));     // false
    }

    /** COMPLETE THIS METHOD
     * Precondition: age >= 0; height > 0.
     * Returns true if the person can ride the Extreme Coaster:
     *   without VIP: age >= 16 AND height >= 60
     *   with VIP:    age >= 14 AND height >= 55
     * (A VIP who also meets the normal rule can of course ride.)
     * Example: canRideExtremeCoaster(17, 54, true) is false -- VIP or not,
     *          54 inches is under the 55-inch VIP minimum.
     *
     * @param age    age of the person in years
     * @param height height of the person in inches
     * @param hasVIP true if the person holds a VIP pass
     * @return true if the person can go on the ride
     */
    public static boolean canRideExtremeCoaster(int age, double height, boolean hasVIP) {
        // Insert your code below

        return false;
    }

    /** COMPLETE THIS METHOD
     * Precondition: age >= 0; height > 0.
     * Returns true if the person can ride the Family River Ride:
     *   age >= 8:  must have height >= 40 (withParent does not matter)
     *   age < 8:   can ride only if withParent is true (height does not matter)
     * Example: canRideFamilyRiver(7, 39, true) is true -- under 8 with a
     *          parent, so the height rule is not applied.
     *
     * @param age        age of the person in years
     * @param height     height of the person in inches
     * @param withParent true if a parent/guardian is riding with them
     * @return true if the person can go on the ride
     */
    public static boolean canRideFamilyRiver(int age, double height, boolean withParent) {
        // Insert your code below

        return false;
    }

    /** COMPLETE THIS METHOD
     * Precondition: age >= 0.
     * Returns true if the person can ride the Kiddie Carousel:
     *   age < 12:  always true
     *   age >= 12: true only if withSiblingUnder12 is true
     * Example: canRideKiddieCarousel(12, false) is false -- 12 is not
     *          "under 12", and there is no younger sibling along.
     *
     * @param age               age of the person in years
     * @param withSiblingUnder12 true if a sibling under 12 is riding with them
     * @return true if the person can go on the ride
     */
    public static boolean canRideKiddieCarousel(int age, boolean withSiblingUnder12) {
        // Insert your code below

        return false;
    }
}
