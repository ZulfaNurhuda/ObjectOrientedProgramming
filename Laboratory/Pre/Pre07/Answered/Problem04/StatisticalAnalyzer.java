import java.util.ArrayList;
import java.util.List;

// TODO: Buat class StatisticalAnalyzer (standalone class)
//
// Atribut yang diperlukan:
// - String analyzerName
//
// Method yang diperlukan:
// - Constructor(String name): inisialisasi analyzer
// - getAnalyzerName(): return nama analyzer
// - calculateAverage(Container<? extends Number> container): hitung rata-rata
//   * Pertanyaan: Mengapa kita menggunakan wildcard "? extends Number"?
//   * Hint: Apa hubungan antara Integer, Double, Float dengan Number?
//         Jika method menerima Container<Number>, bisakah kita pass Container<Integer>?
//   * Tampilkan: "Menghitung rata-rata dari [container.getName()]..."
//   * Return rata-rata sebagai double, atau 0.0 jika kosong
//   * Hint: Bagaimana cara mengkonversi berbagai tipe Number menjadi double?
// - calculateSum(Container<? extends Number> container): hitung total
//   * Tampilkan: "Menghitung total dari [container.getName()]... (tanpa [])"
//   * Return sum sebagai double
// - findAboveThreshold(Container<? extends Number> container, double threshold)
//   * Tampilkan: "Mencari nilai di atas threshold [threshold] di [container.getName()]..."
//   * Return List<Number> berisi semua nilai yang lebih besar dari threshold
//   * Hint: Pikirkan cara membandingkan Number dengan double.

public class StatisticalAnalyzer {
    // TODO: Implementasikan class ini
    private String analyzerName;

    public StatisticalAnalyzer(String name) {
        this.analyzerName = name;
    }

    public String getAnalyzerName() {
        return analyzerName;
    }

    public double calculateAverage(Container<? extends Number> container) {
        System.out.println("Menghitung rata-rata dari " + container.getName() + "...");
        double avg = 0.0;
        if (container.size() > 0) {
            double sum = 0.0;
            for (int i = 0; i < container.size(); i++) {
                sum += container.get(i).doubleValue();
            }
            avg = sum / container.size();
        }
        return avg;
    }

    public double calculateSum(Container<? extends Number> container) {
        System.out.println("Menghitung total dari " + container.getName() + "...");
        double sum = 0.0;
        for (int i = 0; i < container.size(); i++) {
            sum += container.get(i).doubleValue();
        }
        return sum;
    }

    public List<Number> findAboveThreshold(Container<? extends Number> container, double threshold) {
        System.out.println("Mencari nilai di atas threshold " + threshold + " di " + container.getName() + "...");
        List<Number> result = new ArrayList<Number>();
        for (Number num : container.getItems()) {
            if (num.doubleValue() > threshold) {
                result.add(num);
            }
        }
        return result;
    }
}
