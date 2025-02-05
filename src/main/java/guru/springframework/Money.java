package guru.springframework;

public class Money implements Expression {
    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money frank(int amount){
        return new Money(amount, "CHF");
    }

    public String getCurrency() {
        return currency;
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null ) return false;

        Money money = (Money) object;
        return amount == money.amount && currency.equals(money.currency);
    }

    @Override
    public Money reduce(Bank bank, String toCurrency){
        int rate = bank.getRate(this.currency, toCurrency);
        return new Money(this.amount / rate, toCurrency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
