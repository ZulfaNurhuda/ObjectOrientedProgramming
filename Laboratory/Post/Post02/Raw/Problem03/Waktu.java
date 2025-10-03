public class Waktu {
    private int hour;   // 0..23
    private int minute; // 0..59

    // Static attribute untuk default timezone (misalnya "WIB")
    private static String DEFAULT_TZ = "WIB";

    // TODO: default constructor  -> set jam dan menit ke 0
    public Waktu() {
        
    }

    // TODO: Parameterized constructor dengan parameter jam dan menit
    // - batasi jam hanya 0..23, jika kurang dari 0, jam = 0; jika lebih dari 23, jam = 23.
    // - batasi menit hanya 0..59, jika kurang dari 0, menit = 0; jika lebih dari 59, menit = 59.
    public Waktu(int hour, int minute) {
        // gunakan this.hour dan this.minute
    }

    // TODO: Constructor dengan total menit
    // - ubah total menit jadi jam dan menit
    public Waktu(int totalMinutes) {
        // misalnya 150 -> 02:30
    }

    // TODO: Buatlah Getter getHour() dan getMinute()

    // ===== STATIC method =====
    // TODO: public static Waktu fromMinutes(int total) -> kembalikan Waktu dari total menit
    // TODO: public static int toMinutes(Waktu t) -> kembalikan total menit dari objek Waktu
    // TODO: public static Waktu addMinutes(Waktu t, int add) -> tambah menit ke sebuah Waktu lalu kembalikan

    // ===== STATIC getter & setter untuk Waktuzone =====
    // TODO: getDefaultTz() -> kembalikan DEFAULT_TZ
    // TODO: setDefaultTz(String tz) -> ubah DEFAULT_TZ

    // Helper untuk format jam:menit
    private String format() {
        // TODO: kembalikan hour & minute jadi string 2 digit, contoh "09:05"
    }

    @Override
    public String toString() {
        // TODO: kembalikan (bukan print) string "HH:MM TZ", contoh "09:05 WIB"
        // HINT: manfaatkan method format()
    }
}
