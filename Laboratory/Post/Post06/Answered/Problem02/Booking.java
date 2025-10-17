import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private String customerName;
    private Train train;
    private LocalDateTime time;

    /*
     * Inner static class untuk menghasilkan ID booking unik
     * TODO: Buatlah private static attribute counter bertipe int, dengan nilai awal
     * 1000
     * TODO: Buatlah method public static generate() yang mengembalikan String ID
     * booking
     * dengan format "BK" diikuti counter yang di-increment setiap kali method ini
     * dipanggil. (Contoh: "BK1001", "BK1002", dst.)
     */
    public static class BookingIdGenerator {
        // TODO: lengkapi code di sini
        private static int counter = 1000;

        public static String generate() {
            counter++;
            return String.format("BK%d", counter);
        }
    }

    /*
     * Konstruktor kelas Booking
     * TODO: Lengkapi semua state awal dari object Booking
     * customerName dan train diisi dari parameter konstruktor
     * Gunakan BookingIdGenerator.generate() untuk mengisi bookingId
     * Gunakan LocalDateTime.of(2025, 10, 17, 10, 0, 0); untuk mengisi time (Tinggal
     * panggil LocalDateTime.of(2025, 10, 17, 10, 0, 0) saja!)
     */
    public Booking(String customerName, Train train) {
        // TODO: lengkapi code di sini
        bookingId = BookingIdGenerator.generate();
        this.customerName = customerName;
        this.train = train;
        this.time = LocalDateTime.of(2025, 10, 17, 10, 0, 0);
    }

    /*
     * Getter untuk bookingId
     * TODO: Kembalikan String bookingId;
     */
    public String getBookingId() {
        // TODO: lengkapi code di sini
        return bookingId;
    }

    /*
     * Getter untuk train
     * TODO: Kembalikan object Train train
     */
    public Train getTrain() {
        // TODO: lengkapi code di sini
        return train;
    }

    /*
     * Override method toString() untuk menampilkan informasi booking
     * Format: bookingId | customerName | trainName | time
     * Untuk mendapatkan string time, cukup panggil time saja karena nanti outputnya
     * string
     * (Kenapa bisa gitu? karena LocalDateTime sudah punya override toString()
     * sendiri
     * di dalam librarynya)
     * Contoh: BK1001 | Alice | Argo Parahyangan | 2024-06-01T10:15:30.123
     */
    @Override
    public String toString() {
        // TODO: lengkapi code di sini
        return String.format("%s | %s | %s | %s", bookingId, customerName, train.getName(), time);
    }
}
