/** READ FIRST
 * You are writing a program to help a school decide whether a student
 * qualifies for the Honor Roll, the Merit List, or No List, based on their
 * grades and behavior record. The method you will complete has three
 * parameters:
 *      gpa         a number between 0.0 and 4.0
 *      tardies     number of tardies (an integer, 0 or more)
 *      detentions  number of detentions (an integer, 0 or more)
 *
 * Apply the rules in this order:
 *
 *   HIGH GPA (gpa >= 3.5):
 *      A student with NO detentions may qualify for the Honor Roll.
 *        - If they also have fewer than 3 tardies -> "Honor Roll"
 *        - Otherwise (3 or more tardies)          -> "Merit List"
 *      A student with 3.5 or higher who HAS a detention (even one) is NOT
 *      eligible for either list -> "No List". The Merit List rule below is
 *      only for GPAs from 2.5 to 3.49; a 3.5+ student does not fall back to it.
 *
 *   MIDDLE GPA (2.5 <= gpa <= 3.49):
 *      If they have fewer than 2 detentions -> "Merit List"
 *      Otherwise (2 or more detentions)      -> "No List"
 *      Tardies do not matter for this range.
 *
 *   LOW GPA (gpa < 2.5):
 *      -> "No List", no matter what.
 *
 * Return exactly one of these three Strings:
 *      "Honor Roll"
 *      "Merit List"
 *      "No List"
 */

public class HonorRoll {
    /** PROVIDED -- do not change.
     *  A small driver you can run to see your method's answers next to the
     *  expected ones. The autograder does not use main; it runs the tests. */
    public static void main(String[] args) {
        double[] gpas       = {4.0, 3.6, 3.5, 3.4};
        int[]    tardies    = {2,   3,   1,   0};
        int[]    detentions = {0,   0,   1,   1};
        String[] expects = {
            "Honor Roll",
            "Merit List",
            "No List",
            "Merit List"
        };

        for (int i = 0; i < gpas.length; i++) {
            String received = HonorRoll.awardQualifier(gpas[i], tardies[i], detentions[i]);
            System.out.println("Test " + (i + 1));
            System.out.println("  GPA: " + gpas[i] + ", Tardies: " + tardies[i]
                + ", Detentions: " + detentions[i]);
            System.out.println("  Expected: " + expects[i]);
            System.out.println("  Received: " + received);
            System.out.println();
        }
    }

    /** COMPLETE THIS METHOD
     * Precondition: 0.0 <= gpa <= 4.0; tardies >= 0; detentions >= 0.
     * Returns "Honor Roll", "Merit List", or "No List" using the rules above:
     *   gpa >= 3.5 and detentions == 0 and tardies < 3  -> "Honor Roll"
     *   gpa >= 3.5 and detentions == 0 and tardies >= 3 -> "Merit List"
     *   gpa >= 3.5 and detentions >= 1                  -> "No List"
     *   2.5 <= gpa <= 3.49 and detentions < 2           -> "Merit List"
     *   2.5 <= gpa <= 3.49 and detentions >= 2          -> "No List"
     *   gpa < 2.5                                        -> "No List"
     * Example: awardQualifier(3.6, 3, 0) returns "Merit List" -- high GPA and
     *          clean record, but three tardies is not "fewer than 3".
     *
     * @param gpa        GPA of the student
     * @param tardies    number of tardies the student has
     * @param detentions number of detentions the student has
     * @return the list the student is placed on
     */
    public static String awardQualifier(double gpa, int tardies, int detentions) {
        // Insert your code below

        return "";
    }
}
