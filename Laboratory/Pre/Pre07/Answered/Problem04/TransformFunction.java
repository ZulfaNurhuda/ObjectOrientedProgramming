// TODO: Buat interface TransformFunction<T, R>
// Pertanyaan: Mengapa kita perlu interface ini?
// Hint: Ini adalah contoh functional interface untuk strategy pattern
//       Memungkinkan kita passing different transformation logic
public interface TransformFunction<T, R> {
    // TODO: Implementasikan interface ini

    // Method yang diperlukan:
    // - R apply(T input): method abstract untuk transformasi
    R apply(T input);
}
