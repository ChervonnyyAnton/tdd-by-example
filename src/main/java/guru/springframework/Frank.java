package guru.springframework;

public class Frank extends Money{

    private String currency;

    public Frank(int amount) {
        this.amount = amount;
        this.currency = "CHF";
    }

    public Money times(int multiplier) {
        return new Frank(amount * multiplier);
    }

    @Override
    public String getCurrency() {
        return currency;
    }
}
