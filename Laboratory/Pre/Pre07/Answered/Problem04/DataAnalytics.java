// TODO: Buat utility class DataAnalytics dengan static generic methods
// Class ini berisi method-method utility yang bekerja dengan generic containers

public class DataAnalytics {

    // TODO: Buat static generic method copyData
    // Signature: public static <T> void copyData(Container<? extends T> source, Container<? super T> destination)
    // Pertanyaan: Mengapa source menggunakan "? extends T" dan destination "? super T"?
    // Hint: Pertimbangkan operasi apa yang dilakukan pada source (baca/tulis)?
    //       Pertimbangkan operasi apa yang dilakukan pada destination (baca/tulis)?
    //       Cari tahu tentang prinsip PECS dalam Java Generics.
    //
    // Implementasi:
    // - Tampilkan: "Menyalin data dari [source.getName()] ke [destination.getName()]..."
    // - Loop setiap item di source dan tambahkan ke destination
    // - Tampilkan: "Berhasil menyalin [count] item"
    public static <T> void copyData(Container<? extends T> source, Container<? super T> destination) {
        System.out.println("Menyalin data dari " + source.getName() + " ke " + destination.getName() + "...");
        int count = 0;
        for (T item: source.getItems()) {
            destination.add(item);
            count++;
        }
        System.out.println("Berhasil menyalin " + count + " item");
    }


    // TODO: Buat static generic method mergeContainers
    // Signature: public static <T> Container<T> mergeContainers(Container<? extends T> c1, Container<? extends T> c2, String newName)
    // Pertanyaan: Mengapa kedua parameter menggunakan "? extends T"?
    // Hint: Apa operasi yang kita lakukan pada c1 dan c2? Apakah kita memodifikasi mereka?
    //
    // Implementasi:
    // - Buat container baru dengan nama newName
    // - Tampilkan: "Menggabungkan [c1.getName()] dan [c2.getName()]..."
    // - Copy semua item dari c1 dan c2 ke container baru
    // - Return container baru
    // - Tampilkan: "Berhasil menggabungkan [total] item"
    public static <T> Container<T> mergeContainers(Container<? extends T> c1, Container<? extends T> c2, String newName) {
        Container<T> result = new Container<T>(newName);
        System.out.println("Menggabungkan " + c1.getName() + " dan " + c2.getName() + "...");
        int total = 0;
        for (T item : c1.getItems()) {
            result.add(item);
            total++;
        }
        for (T item : c2.getItems()) {
            result.add(item);
            total++;
        }
        System.out.println("Berhasil menggabungkan " + total + " item");
        return result;
    }


    // TODO: Buat static generic method printContainer
    // Signature: public static void printContainer(Container<?> container)
    // Pertanyaan: Kapan kita menggunakan unbounded wildcard "?"?
    // Hint: Apakah tipe spesifik T penting untuk operasi print? Apakah semua tipe bisa di-print?
    //
    // Implementasi:
    // - Tampilkan: "=== Isi Container ==="
    // - Panggil container.display()
    // - Tampilkan: "==================="

    public static void printContainer(Container<?> container) {
        System.out.println("=== Isi Container ===");
        container.display();
        System.out.println("===================");
    }

}
