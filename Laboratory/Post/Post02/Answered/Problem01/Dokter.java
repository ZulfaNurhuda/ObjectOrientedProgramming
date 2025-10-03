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
        jumlahDokter++;

        // TODO 1b: Generate kodeDokter menggunakan format "DR001", "DR002", dst.
        // Petunjuk: Gunakan String.format("%03d", jumlahDokter) untuk mendapat angka 3 digit dengan leading zeros
        kodeDokter = "DR" + String.format("%03d", jumlahDokter);

        // TODO 1c: Inisialisasi semua variabel instance
        this.dataPribadi = dataPribadi;
        this.spesialisasi = spesialisasi;
        jumlahPasien = 0;
        sedangBertugas = false;

        // TODO 1d: Hitung tarif berdasarkan spesialisasi
        // Umum: 100000, Jantung: 300000, Anak: 200000
        // Petunjuk: Gunakan if-else statements atau ternary operator
        if (spesialisasi.equals("Umum")) {
            tarif = 100000;
        } else if (spesialisasi.equals("Jantung")) {
            tarif = 300000;
        } else if (spesialisasi.equals("Anak")) {
            tarif = 200000;
        }

        // TODO 1e: Tambahkan bonus pengalaman berdasarkan umur
        // Bonus = ((umur - 25) / 5) * 50000
        // Petunjuk: Gunakan integer division untuk mendapat bilangan bulat saja
        int umur = dataPribadi.getUmur();
        if (umur > 25) {
            tarif += ((umur - 25) / 5) * 50000;
        }
    }

    // TODO 2: Buat method mulaiShift()
    // Mengembalikan true jika berhasil memulai shift, false jika sudah bertugas
    public boolean mulaiShift() {
        boolean success = false;
        if (!sedangBertugas) {
            sedangBertugas = true;
            success = true;
        }
        return success;
    }

    // TODO 3: Buat method tambahPasien()
    // Mengembalikan true jika berhasil menambah pasien, false jika tidak bertugas atau sudah maksimal
    public boolean tambahPasien() {
        boolean success = false;
        if (sedangBertugas && jumlahPasien < MAX_PASIEN) {
            jumlahPasien++;
            success = true;
        }
        return success;
    }

    // TODO 4: Buat method decrementPasien() untuk mengurangi jumlah pasien
    // Petunjuk: Hanya kurangi jika jumlahPasien > 0
    public void decrementPasien() {
        if (jumlahPasien > 0) {
            jumlahPasien--;
        }
    }

    // TODO 5: Buat static getter untuk jumlahDokter
    public static int getJumlahDokter() {
        return jumlahDokter;
    }

    // TODO 6: Override method toString()
    // Format: "kodeDokter - nama (spesialisasi) - Pasien: current/max"
    // Contoh: "DR001 - Dr. Budi (Umum) - Pasien: 2/3"
    public String toString() {
        return kodeDokter + " - " + dataPribadi.getNama() + " (" + spesialisasi + ") - Pasien: " + jumlahPasien + "/" + MAX_PASIEN;
    }

    // TODO 7: Buat method getter untuk semua atribut private
    public String getSpesialisasi() {
        return spesialisasi;
    }

    public boolean isSedangBertugas() {
        return sedangBertugas;
    }

    public int getJumlahPasien() {
        return jumlahPasien;
    }

    public double getTarif() {
        return tarif;
    }

    public DataPribadi getDataPribadi() {
        return dataPribadi;
    }

    public static int getMaxPasien() {
        return MAX_PASIEN;
    }
}
