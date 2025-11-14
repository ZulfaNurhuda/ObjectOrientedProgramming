public class Patient implements Comparable<Patient> {
    private String name;
    private int age;
    private boolean critical;

    /* TODO : Lengkapi konstruktor Patient(String name, int age, boolean critical)
       Konstruktor ini digunakan untuk membuat objek Patient baru.
       Parameter:
       - name : nama pasien.
       - age : umur pasien.
       - critical : true jika pasien dalam kondisi gawat (prioritas tinggi), false jika tidak.
       Method ini menginisialisasi semua atribut di atas.
       Tidak ada keluaran (void). */
    public Patient(String name, int age, boolean critical) {
        // Type your code
    }

    /* TODO : Lengkapi method getName()
       Mengembalikan nama pasien (String). */
    public String getName() {
        // Type your code
        return null;
    }

    /* TODO : Lengkapi method getAge()
       Mengembalikan umur pasien (int). */
    public int getAge() {
        // Type your code
        return 0;
    }

    /* TODO : Lengkapi method isCritical()
       Mengembalikan nilai boolean apakah pasien termasuk critical (true/false). */
    public boolean isCritical() {
        // Type your code
        return false;
    }

    /* TODO : Lengkapi method compareTo(Patient other)
       Method ini digunakan agar objek Patient dapat diurutkan di TreeSet.
       Urutan didasarkan pada:
       - Prioritas kritis duluan (critical > non-critical)
       - Jika sama, urutkan berdasarkan nama (lexicographically ignore case).
       Return:
       - Negatif jika pasien ini < pasien lain
       - 0 jika sama
       - Positif jika pasien ini > pasien lain
       Output: integer hasil perbandingan. */
    @Override
    public int compareTo(Patient other) {
        // Type your code
        return 0;
    }

    /* TODO : Lengkapi method toString()
       Keluaran format:
       "<nama> (<umur>) [Critical]" jika critical = true
       "<nama> (<umur>)" jika tidak.
       Output berupa String. */
    @Override
    public String toString() {
        // Type your code
        return null;
    }
}
