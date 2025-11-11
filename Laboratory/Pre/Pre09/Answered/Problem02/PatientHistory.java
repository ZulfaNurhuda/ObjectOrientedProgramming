import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class PatientHistory {
    private List<Patient> history = new LinkedList<Patient>();

    /* TODO : Lengkapi method addRecord(Patient p)
       Menambahkan pasien ke daftar riwayat.
       Alasan memakai LinkedList:
       - Operasi tambah di akhir dan hapus cepat tanpa perlu realokasi array.
       Tidak ada nilai kembalian. */
    public void addRecord(Patient p) {
        // Type your code
        history.add(p);
    }

    /* TODO : Lengkapi method sortByName()
       Mengurutkan daftar riwayat pasien berdasarkan nama (ascending).
       Gunakan Collections.sort() atau Comparator.
       Alasan: karena LinkedList tidak terurut secara alami, perlu sorting manual.
       Tidak ada nilai kembalian. */
    public void sortByName() {
        // Type your code
        Collections.sort(history, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
    }

    /* TODO : Lengkapi method searchByName(String name)
       Mencari pasien berdasarkan nama pada riwayat.
       Lakukan pencarian linear (O(n)) pada LinkedList.
       - Parameter: name = nama pasien
       - Return: objek Patient jika ditemukan, null jika tidak.
       Output: Patient atau null. */
    public Patient searchByName(String name) {
        // Type your code
        Patient result = null;
        for (int i = 0; i < history.size() && result == null; i++) {
            Patient p = history.get(i);
            if (p.getName().equals(name)) {
                result = p;
            }
        }
        return result;
    }

    /* TODO : Lengkapi method displayHistory()
       Menampilkan semua pasien dalam riwayat layanan.
       Format:
       Patient History:
       - <nama> (<umur>) [Critical]
       Tidak ada nilai kembalian. */
    public void displayHistory() {
        // Type your code
        System.out.println("Patient History:");
        for (Patient p : history) {
            System.out.println("- " + p);
        }
    }
}
