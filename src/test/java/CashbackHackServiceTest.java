import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
    void shouldReturn0IfAmount1000() {
        CashbackHackService cashbackHackService = new CashbackHackService();
        int amount = 1000;

        int actual = cashbackHackService.remain(amount);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn100IfAmount900() {
        CashbackHackService cashbackHackService = new CashbackHackService();
        int amount = 900;

        int actual = cashbackHackService.remain(amount);
        int expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIllegalArgumentException() {
        CashbackHackService cashbackHackService = new CashbackHackService();
        int amount = -100;

        assertThrows(IllegalArgumentException.class,
                () -> cashbackHackService.remain(amount),
                "amount must be greater than zero");
    }
}