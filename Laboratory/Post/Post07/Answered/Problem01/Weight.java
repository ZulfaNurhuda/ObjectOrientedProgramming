// TODO:
// Lengkapi parameter generik dari kelas.
// Objek ini hanya bisa dibandingkan dengan objek weight yang lain.
public class Weight implements Measurable<Weight> {
    private final double kilograms;

    public Weight(double kilograms) {
        this.kilograms = kilograms;
    }

    // TODO:
    // 1. Implementasikan fungsi getValue untuk mengembalikan nilai massa dalam kilogram yang telah disimpan.
    // 2. Implementasikan fungsi compareTo untuk membandingkan nilai massa objek ini dengan objek lain.
    //    Gunakan Double.compare(Berat objek ini, berat objek lain) untuk mendapatkan hasil perbandingan.
    @Override
    public double getValue() {
        return kilograms;
    }

    @Override
    public int compareTo(Weight other) {
        return Double.compare(getValue(), other.getValue());
    }

    @Override
    public String toString() {
        return kilograms + " kg";
    }
}
