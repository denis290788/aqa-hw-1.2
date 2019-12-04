import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackData.csv", numLinesToSkip = 1)
    void shouldReturnCashback(int amount, int expected) {
        CashbackHackService cashbackHackService = new CashbackHackService();
        int actual = cashbackHackService.remain(amount);

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