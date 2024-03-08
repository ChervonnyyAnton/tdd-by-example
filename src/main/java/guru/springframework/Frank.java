package guru.springframework;

public class Frank extends Money{

    public Frank(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return Money.frank(amount * multiplier);
    }
}
