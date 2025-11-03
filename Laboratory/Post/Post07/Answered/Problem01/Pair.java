// TODO:
// Lengkapi parameter generik dari kelas Pair.
// Note: disarankan parameter generik dalam kelas ini tidak perlu menggunakan bounded generic
public final class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        // TODO:
        // 1. Simpan parameter first dan second
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        // TODO:
        // 1. Kembalikan nilai elemen pertama dari pair.
        // ...
        return first;
    }

    public U getSecond() {
        // TODO:
        // 1. Kembalikan nilai elemen kedua dari pair.
        // ...
        return second;
    }
}
