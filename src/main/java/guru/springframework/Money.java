package guru.springframework;

public abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public abstract Money times(int multiplier);

    public static Money dollar(int amount){
        return new Dollar(amount, "USD");
    }

    public static Money frank(int amount){
        return new Frank(amount, "CHF");
    }

    public String getCurrency() {
        return currency;
    }

    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        Money money = (Money) object;
        return amount == money.amount;
    }
}
