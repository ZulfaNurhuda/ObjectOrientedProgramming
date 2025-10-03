public class Pasien {
    private static int nomorUrut = 1;

    private String nomorPasien;
    private DataPribadi dataPribadi;
    // private String keluhan; /* Trash, not used anywhere. */
    private String tingkatUrgent;
    private Dokter dokterPemeriksa;
    private double biaya;
    // private boolean sudahSelesai; /* Trash, not used anywhere. */

    // TODO 1: Buat constructor yang menerima DataPribadi, keluhan, dan
    // tingkatUrgent
    public Pasien(DataPribadi dataPribadi, String keluhan, String tingkatUrgent) {
        // TODO 1a: Generate nomorPasien menggunakan format "P0001", "P0002", dst.
        // Petunjuk: Gunakan String.format("%04d", nomorUrut) untuk angka 4 digit dengan
        // leading zeros
        nomorPasien = "P" + String.format("%04d", nomorUrut);

        // TODO 1b: Tambahkan nomorUrut untuk pasien berikutnya
        nomorUrut++;

        // TODO 1c: Inisialisasi semua variabel instance
        // Set dokterPemeriksa ke null, biaya ke 0.0, sudahSelesai ke false
        this.dataPribadi = dataPribadi;
        // this.keluhan = keluhan; /* Unneeded */
        this.tingkatUrgent = tingkatUrgent;

        dokterPemeriksa = null;
        biaya = 0.0;
        // sudahSelesai = false; /* Unneeded */
    }

    // TODO 2: Buat method assignDokter() yang menerima object Dokter
    public boolean assignDokter(Dokter dokter) {
        // TODO 2a: Periksa apakah dokter dapat menangani tingkat urgensi pasien ini
        // Aturan:
        // - Pasien "Berat" hanya bisa ke dokter "Jantung" atau "Anak"
        // - Pasien "Sedang" tidak boleh ke dokter "Umum"
        // - Pasien "Ringan" bisa ke dokter mana saja
        // Return false jika aturan dilanggar
        boolean success = true;
        
        if (tingkatUrgent.equals("Berat") && !dokter.getSpesialisasi().equals("Jantung") && !dokter.getSpesialisasi().equals("Anak")) {
            success = false;
        } else if (tingkatUrgent.equals("Sedang") && dokter.getSpesialisasi().equals("Umum")) {
            success = false;
        }

        if (success) {
            // TODO 2b: Hitung biaya berdasarkan tingkatUrgent
            // Multipliers: "Ringan" = 1.0, "Sedang" = 1.5, "Berat" = 2.0
            // Formula: biaya = dokter.getTarif() * multiplier
            double multiplier = 0.0;
            if (tingkatUrgent.equals("Ringan")) {
                multiplier = 1.0;
            } else if (tingkatUrgent.equals("Sedang")) {
                multiplier = 1.5;
            } else if (tingkatUrgent.equals("Berat")) {
                multiplier = 2.0;
            }
            biaya = dokter.getTarif() * multiplier;

            // TODO 2c: Assign dokter dan tambahkan pasien ke hitungan dokter
            // Set dokterPemeriksa dan panggil dokter.tambahPasien()
            dokterPemeriksa = dokter;
            dokter.tambahPasien();
        }

        // Return true jika berhasil
        return success;
    }

    // TODO 3: Buat method resetAssignment()
    // Reset dokterPemeriksa ke null dan biaya ke 0
    public void resetAssignment() {
        dokterPemeriksa = null;
        biaya = 0.0;
    }

    // TODO 4: Override method toString()
    // Format: "nomorPasien - nama (tingkatUrgent) - Biaya: RpX,XXX"
    // Petunjuk: Gunakan String.format("%,.0f", biaya) untuk format mata uang dengan
    // koma
    public String toString() {
        return nomorPasien + " - " + dataPribadi.getNama() + " (" + tingkatUrgent + ") - Biaya: Rp" + String.format("%,.0f", biaya);
    }

    // TODO 5: Buat method getter untuk semua atribut yang diperlukan
    public Dokter getDokterPemeriksa() {
        return dokterPemeriksa;
    }

    public double getBiaya() {
        return biaya;
    }

    public String getTingkatUrgent() {
        return tingkatUrgent;
    }

    public DataPribadi getDataPribadi() {
        return dataPribadi;
    }
}
