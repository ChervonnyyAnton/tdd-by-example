package guru.springframework;

public class Money {
    protected int amount;

    public static Dollar dollar(int amount){
        return new Dollar(amount);
    }

    public static Frank frank(int amount){
        return new Frank(amount);
    }

    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        Money money = (Money) object;
        return amount == money.amount;
    }
}
