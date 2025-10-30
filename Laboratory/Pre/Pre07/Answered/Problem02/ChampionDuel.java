// TODO: 
// Lengkapi definisi kelas ChampionDuel 
// dengan menambahkan sebuah parameter 
// generik yang harus menerapkan interface Comparable.
final class ChampionDuel<T extends Comparable<T>> {
    // TODO:
    // 1. Buat atribut final dengan tipe generik dari elemen pertama dan elemen
    // kedua
    // 2. Buat atribut final label dengan tipe String untuk menyimpan label dari
    // duel saat ini
    private final T first;
    private final T second;
    private final String label;

    ChampionDuel(String label, T first, T second) {
        // TODO: Lengkapi definisi konstruktor.
        this.label = label;
        this.first = first;
        this.second = second;
    }

    T decideChampion() {
        // TODO:
        // 1. Lengkapi definisi fungsi dengan menambahkan return type yang sesuai dengan tipe generik dari elemen pertama dan kedua
        // 2. Kembalikan hasil dari fungsi findChampion dari Champion Finder
        return first.compareTo(second) > 0 ? first : second;
    }

    String report() {
        // TODO:
        // Kembalikan string <tanpa newline dimanapun>:
        // "<label> champion between <player pertama> and <player kedua> is: <hasil
        // decide champion>"
        return label + " champion between " + first + " and " + second + " is: " + decideChampion();
    }
}
