// TODO: Buat generic class DataTransformer<T, R>
// Pertanyaan: Mengapa kita menggunakan dua type parameter T dan R?
// Hint: Pikirkan tentang transformasi data. Apakah tipe input selalu sama dengan tipe output?
//       Misalnya, mengubah String menjadi Integer, atau Integer menjadi Double.
public class DataTransformer<T, R> {
    // TODO: Implementasikan class ini

    // Atribut yang diperlukan:
    // - String transformerName
    private String transformerName;

    // Method yang diperlukan:
    // - Constructor(String transformerName): inisialisasi transformer
    public DataTransformer(String transformerName) {
        this.transformerName = transformerName;
    }

    // - transform(Container<T> source, Container<R> destination, TransformFunction<T, R> function)
    //   * Pertanyaan: Apa itu TransformFunction? (lihat interface TransformFunction.java)
    //   * Tampilkan: "Transforming data dari [source.getName()] ke [destination.getName()]..."
    //   * Loop setiap item di source, apply function, masukkan hasil ke destination
    //   * Hint: TransformFunction memiliki method untuk mengubah tipe T menjadi tipe R.    
    public void transform(Container<T> source, Container<R> destination, TransformFunction<T, R> function) {
        System.out.println("Transforming data dari " + source.getName() + " ke " + destination.getName() + "...");
        for (int i = 0; i < source.size(); i++) {
            T item = source.get(i);
            R transformedItem = function.apply(item);
            destination.add(transformedItem);
        }
    }

    // - getTransformerName(): return nama transformer
    public String getTransformerName() {
        return transformerName;
    }
}
