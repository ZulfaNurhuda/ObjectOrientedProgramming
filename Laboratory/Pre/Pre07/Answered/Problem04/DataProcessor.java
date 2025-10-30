import java.util.List;

// TODO: Buat generic class DataProcessor<T extends Comparable<T>>
// Pertanyaan: Mengapa kita menggunakan bounded type parameter "T extends Comparable<T>"?
// Hint: Method apa yang diperlukan untuk melakukan sorting atau mencari min/max?
//       Apakah semua tipe data memiliki method tersebut secara default?
//
// Atribut yang diperlukan:
// - String processorName
//
// Method yang diperlukan:
// - Constructor(String processorName): inisialisasi processor
// - findMin(Container<T> container): mencari nilai minimum
//   * Tampilkan: "Mencari nilai minimum di [container.getName()]..."
//   * Return nilai minimum, atau null jika container kosong
//   * Hint: Bagaimana cara membandingkan dua objek untuk menentukan mana yang lebih kecil?
// - findMax(Container<T> container): mencari nilai maximum
//   * Tampilkan: "Mencari nilai maksimum di [container.getName()]..."
//   * Return nilai maximum, atau null jika container kosong
// - sort(Container<T> container): mengurutkan item dalam container (ascending)
//   * Tampilkan: "Mengurutkan data di [container.getName()]..."
//   * Hint: Pikirkan algoritma sorting sederhana yang pernah Anda pelajari.
//   * Method ini memodifikasi container secara langsung
// - getProcessorName(): return nama processor

public class DataProcessor<T extends Comparable<T>> {
    // TODO: Implementasikan class ini
    private String processorName;

    public DataProcessor(String processorName) {
        this.processorName = processorName;
    }

    public T findMin(Container<T> container) {
        System.out.println("Mencari nilai minimum di " + container.getName() + "...");
        T min = null;
        if (container.size() > 0) {
            min = container.get(0);
            for (int i = 1; i < container.size(); i++) {
                T current = container.get(i);
                if (current.compareTo(min) < 0) {
                    min = current;
                }
            }
        }
        return min;
    }

    public T findMax(Container<T> container) {
        System.out.println("Mencari nilai maksimum di " + container.getName() + "...");
        T max = null;
        if (container.size() > 0) {
            max = container.get(0);
            for (int i = 1; i < container.size(); i++) {
                T current = container.get(i);
                if (current.compareTo(max) > 0) {
                    max = current;
                }
            }
        }
        return max;
    }

    public void sort(Container<T> container) {
        System.out.println("Mengurutkan data di " + container.getName() + "...");
        List<T> items = container.getItems();

        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = 0; j < items.size() - i - 1; j++) {
                if (items.get(j).compareTo(items.get(j + 1)) > 0) {
                    T temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }

    public String getProcessorName() {
        return processorName;
    }
}
