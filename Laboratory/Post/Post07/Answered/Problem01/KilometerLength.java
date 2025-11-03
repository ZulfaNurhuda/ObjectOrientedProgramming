public final class KilometerLength extends Length {
    public KilometerLength(double kilometers) {
        super(kilometers * 1000.0);
    }

    @Override
    public String toString() {
        return (getValue() / 1000.0) + " km";
    }
}
