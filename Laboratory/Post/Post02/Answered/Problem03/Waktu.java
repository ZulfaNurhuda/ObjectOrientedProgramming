public class Waktu {
    private int hour; // 0..23
    private int minute; // 0..59

    // Static attribute untuk default timezone (misalnya "WIB")
    private static String DEFAULT_TZ = "WIB";

    // TODO: default constructor -> set jam dan menit ke 0
    public Waktu() {
        hour = 0;
        minute = 0;
    }

    // TODO: Parameterized constructor dengan parameter jam dan menit
    // - batasi jam hanya 0..23, jika kurang dari 0, jam = 0; jika lebih dari 23,
    // jam = 23.
    // - batasi menit hanya 0..59, jika kurang dari 0, menit = 0; jika lebih dari
    // 59, menit = 59.
    public Waktu(int hour, int minute) {
        // gunakan this.hour dan this.minute
        if (hour < 0) {
            this.hour = 0;
        } else if (hour > 23) {
            this.hour = 23;
        } else {
            this.hour = hour;
        }

        if (minute < 0) {
            this.minute = 0;
        } else if (minute > 59) {
            this.minute = 59;
        } else {
            this.minute = minute;
        }
    }

    // TODO: Constructor dengan total menit
    // - ubah total menit jadi jam dan menit
    public Waktu(int totalMinutes) {
        // misalnya 150 -> 02:30
        if (totalMinutes < 0) {
            hour = 0;
            minute = 0;
        } else if (totalMinutes > 1439 /* Hasil: 23 * 60 + 59 */) {
            hour = 23;
            minute = 59;
        } else {
            hour = totalMinutes / 60;
            minute = totalMinutes % 60;
        }
    }

    // TODO: Buatlah Getter getHour() dan getMinute()
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    // ===== STATIC method =====
    // TODO: public static Waktu fromMinutes(int total) -> kembalikan Waktu dari
    // total menit
    public static Waktu fromMinutes(int total) {
        return new Waktu(total);
    }

    // TODO: public static int toMinutes(Waktu t) -> kembalikan total menit dari
    // objek Waktu
    public static int toMinutes(Waktu t) {
        return t.hour * 60 + t.minute;
    }

    // TODO: public static Waktu addMinutes(Waktu t, int add) -> tambah menit ke
    // sebuah Waktu lalu kembalikan
    public static Waktu addMinutes(Waktu t, int add) {
        int totalMinutes = (toMinutes(t) + add) % 1440 /* Hasil: 24 * 60 */;
        return fromMinutes(totalMinutes);
    }

    // ===== STATIC getter & setter untuk Waktuzone =====
    // TODO: getDefaultTz() -> kembalikan DEFAULT_TZ
    public static String getDefaultTz() {
        return DEFAULT_TZ;
    }

    // TODO: setDefaultTz(String tz) -> ubah DEFAULT_TZ
    public static void setDefaultTz(String tz) {
        DEFAULT_TZ = tz;
    }

    // Helper untuk format jam:menit
    private String format() {
        // TODO: kembalikan hour & minute jadi string 2 digit, contoh "09:05"
        return String.format("%02d:%02d", hour, minute);
    }

    @Override
    public String toString() {
        // TODO: kembalikan (bukan print) string "HH:MM TZ", contoh "09:05 WIB"
        // HINT: manfaatkan method format()
        return format() + " " + DEFAULT_TZ;
    }
}
