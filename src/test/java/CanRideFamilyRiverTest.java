import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CanRideFamilyRiverTest {

    private static void check(boolean expected, int age, double height, boolean parent, String why) {
        assertEquals(expected, ThemePark.canRideFamilyRiver(age, height, parent),
            "canRideFamilyRiver(" + age + ", " + height + ", " + parent + "): " + why);
    }

    @DisplayName("canRideFamilyRiver: exactly 8 years and exactly 40 in, no parent -> true")
    @Test
    void canRideFamilyRiver_Test01() {
        check(true, 8, 40, false, "exactly at both boundaries; 'at least' includes them");
    }

    @DisplayName("canRideFamilyRiver: 10 years, 45 in, no parent -> true")
    @Test
    void canRideFamilyRiver_Test02() {
        check(true, 10, 45, false, "clearly meets both requirements");
    }

    @DisplayName("canRideFamilyRiver: 8 years, 39 in, no parent -> false")
    @Test
    void canRideFamilyRiver_Test03() {
        check(false, 8, 39, false, "old enough but one inch short of 40");
    }

    @DisplayName("canRideFamilyRiver: 7 years, 42 in, with parent -> true")
    @Test
    void canRideFamilyRiver_Test04() {
        check(true, 7, 42, true, "under 8 but with a parent");
    }

    @DisplayName("canRideFamilyRiver: 7 years, 39 in, with parent -> true (parent overrides the height rule)")
    @Test
    void canRideFamilyRiver_Test05() {
        check(true, 7, 39, true,
            "for an under-8, a parent replaces BOTH the age and the height requirement");
    }

    @DisplayName("canRideFamilyRiver: 7 years, 42 in, no parent -> false")
    @Test
    void canRideFamilyRiver_Test06() {
        check(false, 7, 42, false, "under 8 with no parent cannot ride, even if tall enough");
    }

    @DisplayName("canRideFamilyRiver: 12 years, 39 in, no parent -> false")
    @Test
    void canRideFamilyRiver_Test07() {
        check(false, 12, 39, false, "8 or older must meet the height rule themselves");
    }

    @DisplayName("canRideFamilyRiver: 5 years, 30 in, with parent -> true")
    @Test
    void canRideFamilyRiver_Test08() {
        check(true, 5, 30, true, "very young and very short, but with a parent");
    }

    @DisplayName("canRideFamilyRiver: 5 years, 30 in, no parent -> false")
    @Test
    void canRideFamilyRiver_Test09() {
        check(false, 5, 30, false, "very young, no parent");
    }

    @DisplayName("canRideFamilyRiver: 20 years, 70 in, no parent -> true")
    @Test
    void canRideFamilyRiver_Test10() {
        check(true, 20, 70, false, "an adult easily qualifies");
    }
}
