package guru.springframework;

public class Dollar extends Money{

    private String currency;

    public Dollar(int amount) {
        this.amount = amount;
        this.currency = "USD";
    }

    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public String getCurrency() {
        return currency;
    }
}
