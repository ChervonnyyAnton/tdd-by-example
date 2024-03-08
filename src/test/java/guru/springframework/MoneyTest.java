package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    public void testMultiplicationDollar(){
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testMoneyEquality() {
        assertEquals(new Dollar(5),new Dollar(5));
        assertEquals(new Frank(5), new Frank(5));
        assertNotEquals(new Dollar(5), new Dollar(6));
        assertNotEquals(new Dollar(5), new Frank(5));
    }

    @Test
    public void testMultiplicationFrank(){
        Frank five = new Frank(5);
        assertEquals(new Frank(10), five.times(2));
        assertEquals(new Frank(15), five.times(3));
    }
}
