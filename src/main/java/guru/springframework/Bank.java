package guru.springframework;

import java.util.HashMap;

public class Bank {

    private final HashMap<Pair, Integer> rates = new HashMap<>();
    Money reduce(Expression source) {
        return source.reduce(this, "USD");
    }

    public void addRate(String source, String toCurrency, int rate) {
        rates.put(new Pair(source, toCurrency), rate);
    }

    public int getRate(String source, String toCurrency) {
        if (source.equals(toCurrency)) return 1;
        return rates.get(new Pair(source, toCurrency));
    }
}
