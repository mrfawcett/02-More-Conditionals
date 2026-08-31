import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CanRideKiddieCarouselTest {

    private static void check(boolean expected, int age, boolean sibling, String why) {
        assertEquals(expected, ThemePark.canRideKiddieCarousel(age, sibling),
            "canRideKiddieCarousel(" + age + ", " + sibling + "): " + why);
    }

    @DisplayName("canRideKiddieCarousel: 11 years, no sibling -> true")
    @Test
    void canRideKiddieCarousel_Test01() {
        check(true, 11, false, "under 12 always rides");
    }

    @DisplayName("canRideKiddieCarousel: 5 years, no sibling -> true")
    @Test
    void canRideKiddieCarousel_Test02() {
        check(true, 5, false, "under 12 always rides");
    }

    @DisplayName("canRideKiddieCarousel: 0 years, no sibling -> true")
    @Test
    void canRideKiddieCarousel_Test03() {
        check(true, 0, false, "even a baby is 'under 12'");
    }

    @DisplayName("canRideKiddieCarousel: exactly 12 years, with younger sibling -> true")
    @Test
    void canRideKiddieCarousel_Test04() {
        check(true, 12, true, "12 or older needs a younger sibling, and has one");
    }

    @DisplayName("canRideKiddieCarousel: exactly 12 years, no sibling -> false")
    @Test
    void canRideKiddieCarousel_Test05() {
        check(false, 12, false, "12 is NOT under 12 -- check < versus <=");
    }

    @DisplayName("canRideKiddieCarousel: 15 years, with younger sibling -> true")
    @Test
    void canRideKiddieCarousel_Test06() {
        check(true, 15, true, "older, but with a younger sibling");
    }

    @DisplayName("canRideKiddieCarousel: 15 years, no sibling -> false")
    @Test
    void canRideKiddieCarousel_Test07() {
        check(false, 15, false, "older without a younger sibling");
    }

    @DisplayName("canRideKiddieCarousel: 30 years, with younger sibling -> true")
    @Test
    void canRideKiddieCarousel_Test08() {
        check(true, 30, true, "any age is allowed with a younger sibling");
    }

    @DisplayName("canRideKiddieCarousel: 30 years, no sibling -> false")
    @Test
    void canRideKiddieCarousel_Test09() {
        check(false, 30, false, "too old, no sibling");
    }

    @DisplayName("canRideKiddieCarousel: 11 years, with sibling -> true (sibling is irrelevant under 12)")
    @Test
    void canRideKiddieCarousel_Test10() {
        check(true, 11, true, "under 12 rides whether or not a sibling is along");
    }
}
