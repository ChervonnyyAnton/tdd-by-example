package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    public void testMultiplication(){
        Money fiveD = Money.dollar(5);
        assertEquals(Money.dollar(10), fiveD.times(2));

        Money fiveF = Money.frank(5);
        assertEquals(Money.frank(15), fiveF.times(3));
    }

    @Test
    public void testMoneyEquality() {
        assertEquals(Money.dollar(5),Money.dollar(5));
        assertEquals(Money.frank(5), Money.frank(5));

        assertNotEquals(Money.dollar(5), Money.dollar(6));
        assertNotEquals(Money.dollar(5), Money.frank(5));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("CHF", Money.frank(1).getCurrency());
    }
}
