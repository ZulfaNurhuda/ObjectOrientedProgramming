public final class GramWeight extends Weight {
    public GramWeight(double grams) {
        super(grams / 1000.0);
    }

    @Override
    public String toString() {
        return (getValue() * 1000.0) + " g";
    }
}
