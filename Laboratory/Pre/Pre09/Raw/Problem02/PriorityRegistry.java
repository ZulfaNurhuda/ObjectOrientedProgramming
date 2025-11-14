import java.util.TreeSet;

public class PriorityRegistry {
    private TreeSet<Patient> prioritySet = new TreeSet<>();

    /* TODO : Lengkapi method addPriority(Patient p)
       Menambahkan pasien ke daftar prioritas.
       Alasan menggunakan TreeSet:
       - Menghindari duplikasi (pasien unik berdasarkan nama)
       - Otomatis terurut (critical > non-critical, lalu abjad)
       Tidak ada nilai kembalian. */
    public void addPriority(Patient p) {
        // Type your code
    }

    /* TODO : Lengkapi method removePriority(String name)
       Menghapus pasien dari daftar prioritas berdasarkan nama.
       - Jika tidak ditemukan, tidak melakukan apa pun.
       Return: true jika berhasil dihapus, false jika tidak ditemukan.
       Kompleksitas: O(log n) untuk pencarian di TreeSet. */
    public boolean removePriority(String name) {
        // Type your code
        return false;
    }

    /* TODO : Lengkapi method displayPriorityList()
       Menampilkan seluruh pasien prioritas secara terurut.
       Format (Jika kosong):
       Priority Patients:
       - (empty)
       Format (Jika tidak kosong):
       Priority Patients:
       - <nama> (<umur>) [Critical]
       Tidak ada nilai kembalian. 
       */
    public void displayPriorityList() {
        // Type your code
    }
}
