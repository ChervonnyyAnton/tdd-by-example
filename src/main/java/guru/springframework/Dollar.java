package guru.springframework;

public class Dollar {

    final private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public int amount() {
        return this.amount;
    }

    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dollar dollar = (Dollar) object;
        return amount == dollar.amount;
    }
}
