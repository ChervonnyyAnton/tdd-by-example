package guru.springframework;

public class Frank {

    private int amount;

    public Frank(int amount) {
        this.amount = amount;
    }

    public Frank times(int multiplier) {
        return new Frank(this.amount * multiplier);
    }

    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Frank frank = (Frank) object;
        return amount == frank.amount;
    }
}
