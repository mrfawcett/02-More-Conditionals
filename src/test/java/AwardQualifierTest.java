import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AwardQualifierTest {

    /** Compares ignoring case and surrounding spaces; the spelling must be right. */
    private static void check(String expected, double gpa, int tardies, int detentions, String why) {
        String received = HonorRoll.awardQualifier(gpa, tardies, detentions);
        String call = "awardQualifier(" + gpa + ", " + tardies + ", " + detentions + ")";
        assertNotNull(received, call + " returned null");
        assertEquals(expected.toLowerCase(), received.trim().toLowerCase(), call + ": " + why);
    }

    @DisplayName("awardQualifier: GPA 4.0, 2 tardies, 0 detentions -> Honor Roll")
    @Test
    void awardQualifier_Test01() {
        check("Honor Roll", 4.0, 2, 0, "GPA >= 3.5, no detentions, fewer than 3 tardies");
    }

    @DisplayName("awardQualifier: GPA 3.6 with 3 tardies (not fewer than 3) -> Merit List")
    @Test
    void awardQualifier_Test02() {
        check("Merit List", 3.6, 3, 0, "GPA >= 3.5 and no detentions, but 3 tardies is not < 3");
    }

    @DisplayName("awardQualifier: GPA 3.5 with ONE detention -> No List (not Merit List)")
    @Test
    void awardQualifier_Test03() {
        check("No List", 3.5, 1, 1,
            "a 3.5+ student with any detention is off both lists; "
            + "the Merit List rule is only for GPAs 2.5 to 3.49");
    }

    @DisplayName("awardQualifier: GPA 3.4, 1 detention -> Merit List")
    @Test
    void awardQualifier_Test04() {
        check("Merit List", 3.4, 0, 1, "GPA in 2.5..3.49 and fewer than 2 detentions");
    }

    @DisplayName("awardQualifier: GPA 3.4, 2 detentions -> No List")
    @Test
    void awardQualifier_Test05() {
        check("No List", 3.4, 2, 2, "GPA in range, but 2 detentions is not fewer than 2");
    }

    @DisplayName("awardQualifier: GPA 2.6, 5 tardies, 0 detentions -> Merit List (tardies do not matter here)")
    @Test
    void awardQualifier_Test06() {
        check("Merit List", 2.6, 5, 0, "tardies are only checked for the Honor Roll, not the Merit List");
    }

    @DisplayName("awardQualifier: GPA 2.6, 2 detentions -> No List")
    @Test
    void awardQualifier_Test07() {
        check("No List", 2.6, 1, 2, "GPA in range, but 2 detentions is not fewer than 2");
    }

    @DisplayName("awardQualifier: GPA 2.49 is just below the Merit List cutoff -> No List")
    @Test
    void awardQualifier_Test08() {
        check("No List", 2.49, 0, 0, "2.49 < 2.5, so a perfect record does not help");
    }

    @DisplayName("awardQualifier: GPA 0.0, 10 tardies, 5 detentions -> No List")
    @Test
    void awardQualifier_Test09() {
        check("No List", 0.0, 10, 5, "very low GPA is always No List");
    }

    @DisplayName("awardQualifier: GPA 3.9, 0 tardies, 0 detentions -> Honor Roll")
    @Test
    void awardQualifier_Test10() {
        check("Honor Roll", 3.9, 0, 0, "best case: high GPA, clean record");
    }
}
