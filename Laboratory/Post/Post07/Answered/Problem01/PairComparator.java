public final class PairComparator {
    private PairComparator() {}

    // TODO:
    // 1. Lengkapi parameter generik method yang merupakan kelas-kelas yang
    // menerapkan interface Comparable
    // 2. Lengkapi parameter generik dari pair yang dibandingkan
    public static <T extends Comparable, U extends Comparable> boolean isGreater(Pair<T, U> p1, Pair<T, U> p2) {
        // TODO:
        // 1. Bandingkan elemen pertama dan kedua antar pair menggunakan compareTo().
        // 2. Kembalikan true hanya jika kedua perbandingan menunjukkan p1 lebih besar
        // dari p2.
        // ...
        T first1 = p1.getFirst(), first2 = p2.getFirst();
        U second1 = p1.getSecond(), second2 = p2.getSecond();

        boolean resElmtOne = first1.compareTo(first2) > 0;
        boolean resElmtTwo = second1.compareTo(second2) > 0;

        return resElmtOne && resElmtTwo;
    }
}
