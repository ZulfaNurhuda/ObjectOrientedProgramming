// TODO: Buat interface TransformFunction<T, R>
// Pertanyaan: Mengapa kita perlu interface ini?
// Hint: Ini adalah contoh functional interface untuk strategy pattern
//       Memungkinkan kita passing different transformation logic
//
// Method yang diperlukan:
// - R apply(T input): method abstract untuk transformasi

public interface TransformFunction<T, R> {
    // TODO: Implementasikan interface ini
    R apply(T input);
}
