package guru.springframework;

public class Money implements Expression {
    protected int amount;
    protected String currency;

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

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public Expression plus(Money addend){
        return new Sum(this, addend);
    }

    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null ) return false;

        Money money = (Money) object;
        return amount == money.amount && currency.equals(money.currency);
    }

    @Override
    public Money reduce(Bank bank, String toCurrency){
        int rate = (currency.equals("CHF") && toCurrency.equals("USD")) ? 2 : 1;
        return new Money(amount / rate, toCurrency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
