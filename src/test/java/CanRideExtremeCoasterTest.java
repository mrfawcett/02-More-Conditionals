import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CanRideExtremeCoasterTest {
    @DisplayName("canRideExtremeCoaster Test 1")
    @Test
    void canRideExtremeCoaster_Test01 () {
        int age = 18;
        double height = 65;
        boolean vip = false;
        boolean expected = true; // meets 16+ and 60+
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 2")
    @Test
    void canRideExtremeCoaster_Test02 () {
        int age = 16;
        double height = 60;
        boolean vip = false;
        boolean expected = true; // exactly at boundary for normal rules
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 3")
    @Test
    void canRideExtremeCoaster_Test03 () {
        int age = 15;
        double height = 60;
        boolean vip = false;
        boolean expected = false; // under 16 without VIP
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 4")
    @Test
    void canRideExtremeCoaster_Test04 () {
        int age = 16;
        double height = 59;
        boolean vip = false;
        boolean expected = false; // tall enough only at 60+
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 5")
    @Test
    void canRideExtremeCoaster_Test05 () {
        int age = 14;
        double height = 55;
        boolean vip = true;
        boolean expected = true; // exactly at VIP boundary
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 6")
    @Test
    void canRideExtremeCoaster_Test06 () {
        int age = 14;
        double height = 54.9;
        boolean vip = true;
        boolean expected = false; // height just below VIP requirement
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 7")
    @Test
    void canRideExtremeCoaster_Test07 () {
        int age = 13;
        double height = 60;
        boolean vip = true;
        boolean expected = false; // under VIP minimum age (14)
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 8")
    @Test
    void canRideExtremeCoaster_Test08 () {
        int age = 17;
        double height = 54;
        boolean vip = true;
        boolean expected = false; // even with VIP, still under 55 height for special rule
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 9")
    @Test
    void canRideExtremeCoaster_Test09 () {
        int age = 20;
        double height = 59;
        boolean vip = false;
        boolean expected = false; // fails normal requirement (needs 60+ height)
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 10")
    @Test
    void canRideExtremeCoaster_Test10 () {
        int age = 15;
        double height = 57;
        boolean vip = true;
        boolean expected = true; // meets VIP conditions (14+ and 55+)
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }

    @DisplayName("canRideExtremeCoaster Test 11")
    @Test
    void canRideExtremeCoaster_Test11 () {
        int age = 13;
        double height = 53;
        boolean vip = true;
        boolean expected = false; // under age and under height
        boolean received = ThemePark.canRideExtremeCoaster(age, height, vip);
        assertEquals(expected, received);
    }
}
