public class BankSystem {
    private BankAccount[] accounts;
    private int count;

    /* TODO : Lengkapi konstruktor BankSystem(int capacity)
       Konstruktor ini membuat sistem bank yang dapat menampung sejumlah akun.
       - capacity menentukan banyaknya akun maksimum.
       - Inisialisasi array accounts dengan ukuran capacity.
       Tidak ada nilai kembalian. */
    public BankSystem(int capacity) {
        // Type your code
    }

    /* TODO : Lengkapi method addAccount(BankAccount account)
       Menambahkan akun ke sistem.
       - Jika sudah penuh, lempar IllegalStateException.
       - Jika akun null, lempar NullPointerException.
       Tidak ada nilai kembalian. */
    public void addAccount(BankAccount account) {
        // Type your code
    }

    /* TODO : Lengkapi method findAccount(String owner)
       Mencari akun berdasarkan nama pemilik.
       - Jika tidak ditemukan, return null.
       Return: objek BankAccount atau null jika tidak ada. */
    public BankAccount findAccount(String owner) {
        // Type your code
        return null;
    }

    /* TODO : Lengkapi method displayAll()
       Menampilkan semua akun yang ada di sistem.
       Format:
       Daftar Akun:
       - <nama> - Saldo: Rp<saldo>
       Jika belum ada akun, tampilkan pesan "(tidak ada akun)". */
    public void displayAll() {
        // Type your code
    }
}
