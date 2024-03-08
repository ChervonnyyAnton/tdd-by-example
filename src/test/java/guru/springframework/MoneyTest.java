package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    public void testMultiplication(){
        Money fiveD = Money.dollar(5);
        assertEquals(Money.dollar(10), fiveD.times(2));

        Money fiveF = Money.frank(5);
        assertEquals(Money.frank(15), fiveF.times(3));
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.frank(2));
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testMoneyEquality() {
        var fiveD = Money.dollar(5);
        var anotherFiveD = Money.dollar(5);
        var sixD = Money.dollar(6);
        var fiveF = Money.frank(5);

        assertEquals(fiveD, anotherFiveD);
        assertNotEquals(fiveD, sixD);
        assertNotEquals(fiveD, fiveF);
    }

    @Test
    public void testGetCurrency(){
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("CHF", Money.frank(1).getCurrency());
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().getRate("USD", "USD"));
        assertEquals(1, new Bank().getRate("CHF", "CHF"));
    }

    @Test
    public void testMixedAddition(){
        Expression fiveD = Money.dollar(5);
        Expression tenF = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveD.plus(tenF));
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum);
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum);
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1));
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testSumPlusMoney(){
        Expression fiveD = Money.dollar(5);
        Expression tenF = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveD, tenF).plus(fiveD);
        Money result = bank.reduce(sum);
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes(){
        Expression fiveD = Money.dollar(5);
        Expression tenF = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveD, tenF).times(2);
        Money result = bank.reduce(sum);
        assertEquals(Money.dollar(20), result);
    }

    @Test
    public void testToString_usd() {
        Money money = new Money(150, "USD");

        String expected = "Money{amount=150, currency='USD'}";
        String actual = money.toString();

        assertEquals(expected, actual, "toString method for USD doesn't work as expected");
    }

    @Test
    public void testToString_chf() {
        Money money = new Money(100, "CHF");

        String expected = "Money{amount=100, currency='CHF'}";
        String actual = money.toString();

        assertEquals(expected, actual, "toString method for CHF doesn't work as expected");
    }

    @Test
    public void testToString_zeroAmount() {
        Money money = new Money(0, "USD");

        String expected = "Money{amount=0, currency='USD'}";
        String actual = money.toString();

        assertEquals(expected, actual, "toString method for zero amount doesn't work as expected");
    }
}
