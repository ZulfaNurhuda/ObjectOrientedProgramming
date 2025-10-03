public class Dokter {
    private static int jumlahDokter = 0;
    private static int MAX_PASIEN = 3;

    private String kodeDokter;
    private DataPribadi dataPribadi;
    private String spesialisasi;
    private int jumlahPasien;
    private boolean sedangBertugas;
    private double tarif;

    // TODO 1: Buat constructor yang menerima DataPribadi dan spesialisasi
    public Dokter(DataPribadi dataPribadi, String spesialisasi) {
        // TODO 1a: Tambahkan jumlahDokter

        // TODO 1b: Generate kodeDokter menggunakan format "DR001", "DR002", dst.
        // Petunjuk: Gunakan String.format("%03d", jumlahDokter) untuk mendapat angka 3 digit dengan leading zeros

        // TODO 1c: Inisialisasi semua variabel instance

        // TODO 1d: Hitung tarif berdasarkan spesialisasi
        // Umum: 100000, Jantung: 300000, Anak: 200000
        // Petunjuk: Gunakan if-else statements atau ternary operator

        // TODO 1e: Tambahkan bonus pengalaman berdasarkan umur
        // Bonus = ((umur - 25) / 5) * 50000
        // Petunjuk: Gunakan integer division untuk mendapat bilangan bulat saja
    }

    // TODO 2: Buat method mulaiShift()
    // Mengembalikan true jika berhasil memulai shift, false jika sudah bertugas
    public boolean mulaiShift() {

    }

    // TODO 3: Buat method tambahPasien()
    // Mengembalikan true jika berhasil menambah pasien, false jika tidak bertugas atau sudah maksimal
    public boolean tambahPasien() {

    }

    // TODO 4: Buat method decrementPasien() untuk mengurangi jumlah pasien
    // Petunjuk: Hanya kurangi jika jumlahPasien > 0
    public void decrementPasien() {

    }

    // TODO 5: Buat static getter untuk jumlahDokter
    public static int getJumlahDokter() {

    }

    // TODO 6: Override method toString()
    // Format: "kodeDokter - nama (spesialisasi) - Pasien: current/max"
    // Contoh: "DR001 - Dr. Budi (Umum) - Pasien: 2/3"
    public String toString() {

    }

    // TODO 7: Buat method getter untuk semua atribut private
    public String getSpesialisasi() {

    }

    public boolean isSedangBertugas() {

    }

    public int getJumlahPasien() {

    }

    public double getTarif() {

    }

    public DataPribadi getDataPribadi() {

    }
}
