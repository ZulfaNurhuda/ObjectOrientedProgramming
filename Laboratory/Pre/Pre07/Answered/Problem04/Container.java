import java.util.ArrayList;
import java.util.List;

// TODO: Buat generic class Container<T>
// Pertanyaan: Mengapa kita menggunakan generic class?
// Hint: Coba bayangkan jika Anda harus membuat ContainerInteger, ContainerString, ContainerDouble.
//       Apakah ada pola yang berulang? Konsep pemrograman apa yang menghindari pengulangan kode?
//
// Pertanyaan: Apa keuntungan menggunakan <T> dibanding menggunakan Object?
// Hint: Kapan error tipe data akan terdeteksi? Apa yang terjadi jika ada kesalahan cast?
public class Container<T> {
    // TODO: Implementasikan class ini
    // Jangan lupa tambahkan <T> setelah nama class!

    // Atribut yang diperlukan:
    // - List<T> items untuk menyimpan data
    // - String name untuk nama container
    private List<T> items;
    private String name;

    // Method yang diperlukan:
    // - Constructor(String name): inisialisasi container dengan nama
    //   * Pertanyaan: Bagaimana cara menginisialisasi List<T>? ArrayList atau LinkedList?
    public Container(String name) {
        this.name = name;
        this.items = new ArrayList<T>();
    }

    // - add(T item): menambahkan item ke container
    //   * Tampilkan: "Item ditambahkan ke [name]"
    //   * Hint: Eksplorasi dokumentasi List interface. Method apa yang menambahkan elemen?    
    public void add(T item) {
        items.add(item);
        System.out.println("Item ditambahkan ke " + name);
    }

    // - get(int index): mengambil item pada index tertentu
    //   * Return item pada index, atau null jika index tidak valid
    //   * Hint: Pikirkan batas bawah dan atas index yang valid untuk sebuah list.
    public T get(int index) {
        T foundItem = null;
        if (index >= 0 && index < items.size()) {
            foundItem = items.get(index);
        }
        return foundItem;
    }

    // - size(): return jumlah item dalam container
    //   * Hint: Bagaimana cara mengetahui berapa banyak elemen dalam sebuah koleksi?
    public int size() {
        return items.size();
    }

    // - getName(): return nama container
    public String getName() {
        return name;
    }

    // - getItems(): return List<T> items
    //   * Pertanyaan: Apakah aman return reference langsung atau perlu copy?
    //   * Hint: Untuk praktikum ini, return reference langsung sudah cukup
    public List<T> getItems() {
        return items;
    }

    // - display(): menampilkan semua item
    //   * Format: "Container [name] berisi [size] item:"
    //   * Lalu tampilkan setiap item dengan format: "- [item]"
    //   * Hint: Ada beberapa cara untuk mengiterasi koleksi. Pertimbangkan readability kode Anda.    
    public void display() {
        System.out.println("Container " + name + " berisi " + size() + " item:");
        for (T item : items) {
            System.out.println("- " + item);
        }
    }
}
