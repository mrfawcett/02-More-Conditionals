import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CanRideExtremeCoasterTest {

    private static void check(boolean expected, int age, double height, boolean vip, String why) {
        assertEquals(expected, ThemePark.canRideExtremeCoaster(age, height, vip),
            "canRideExtremeCoaster(" + age + ", " + height + ", " + vip + "): " + why);
    }

    @DisplayName("canRideExtremeCoaster: 18 years, 65 in, no VIP -> true")
    @Test
    void canRideExtremeCoaster_Test01() {
        check(true, 18, 65, false, "meets 16+ and 60+");
    }

    @DisplayName("canRideExtremeCoaster: exactly 16 years and exactly 60 in, no VIP -> true")
    @Test
    void canRideExtremeCoaster_Test02() {
        check(true, 16, 60, false, "'at least' means the boundary counts -- use >=, not >");
    }

    @DisplayName("canRideExtremeCoaster: 15 years, 60 in, no VIP -> false")
    @Test
    void canRideExtremeCoaster_Test03() {
        check(false, 15, 60, false, "under 16 without a VIP pass");
    }

    @DisplayName("canRideExtremeCoaster: 16 years, 59 in, no VIP -> false")
    @Test
    void canRideExtremeCoaster_Test04() {
        check(false, 16, 59, false, "old enough but one inch short of 60");
    }

    @DisplayName("canRideExtremeCoaster: VIP, exactly 14 years and exactly 55 in -> true")
    @Test
    void canRideExtremeCoaster_Test05() {
        check(true, 14, 55, true, "exactly at the VIP boundary; both >= should be true");
    }

    @DisplayName("canRideExtremeCoaster: VIP, 14 years, 54.9 in -> false")
    @Test
    void canRideExtremeCoaster_Test06() {
        check(false, 14, 54.9, true, "height is a double; 54.9 is below 55");
    }

    @DisplayName("canRideExtremeCoaster: VIP, 13 years, 60 in -> false")
    @Test
    void canRideExtremeCoaster_Test07() {
        check(false, 13, 60, true, "tall enough, but under the VIP minimum age of 14");
    }

    @DisplayName("canRideExtremeCoaster: VIP, 17 years, 54 in -> false (VIP lowers the bar, it does not remove it)")
    @Test
    void canRideExtremeCoaster_Test08() {
        check(false, 17, 54, true, "even a VIP must be at least 55 inches");
    }

    @DisplayName("canRideExtremeCoaster: 20 years, 59 in, no VIP -> false")
    @Test
    void canRideExtremeCoaster_Test09() {
        check(false, 20, 59, false, "fails the normal 60-inch requirement");
    }

    @DisplayName("canRideExtremeCoaster: VIP, 15 years, 57 in -> true")
    @Test
    void canRideExtremeCoaster_Test10() {
        check(true, 15, 57, true, "meets the VIP rule (14+ and 55+) even though not the normal rule");
    }

    @DisplayName("canRideExtremeCoaster: VIP, 13 years, 53 in -> false")
    @Test
    void canRideExtremeCoaster_Test11() {
        check(false, 13, 53, true, "under both the VIP age and the VIP height");
    }
}
