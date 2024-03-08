package guru.springframework;

public class Bank {
    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public void addRate(String chf, String usd, int i) {

    }

    public int rate(String usd, String usd1) {
        return (usd.equals("CHF") && usd1.equals("USD")) ? 2 : 1;
    }
}
