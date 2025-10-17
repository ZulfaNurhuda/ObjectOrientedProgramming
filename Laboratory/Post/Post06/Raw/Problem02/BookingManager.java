import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    // private List<Booking> bookings;

    /*
     * Konstruktor Kelas BookingManager
     * TODO: Lengkapi state awal dari attribut BookingManager
     *      - Inisialisasi list bookings dengan list kosong
     */
    public BookingManager() {
        // TODO: lengkapi konstruktor
    }

    /*
     * Inner class Action
     * TODO: Buatlah method cancel dan addbooking
     *     - Method cancel akan menerima parameter String bookingId dan mengembalikan boolean.
     *          Method cancel akan menghapus booking yang memiliki bookingId dari bookings.
     *          Jika booking berhasil dihapus, jangan lupa untuk menambahkan seat pada kereta 
     *          yang bersangkutan dan keluarkan pesan "Booking <bookingId> berhasil dibatalkan."
     *          Jika bookingId tidak ditemukan, kembalikan false dan keluarkan pesan 
     *          "Booking ID tidak ditemukan: <bookingId>"
     * 
     *     - Method addBooking berupa prosedur yang menerima parameter Booking booking.
     *          Method ini akan menambahkan booking ke dalam list bookings.
     */
    public class Action {
        // TODO: Lengkapi class Action
    }

    /*
     * Method showAllBookings
     * TODO:    Method ini berupa prosedur yang akan menampilkan semua booking yang ada di dalam list bookings.
     *          Awali dengan menampilkan header "=== Daftar Semua Booking ===\n"
     *          - Jika tidak ada booking, tampilkan pesan "(Belum ada booking)\n"
     *          - Jika bookings tidak kosong, print objek booking satu per satu.
     */
    public void showAllBookings() {
        // TODO: lengkapi method showAllBookings
    }

    /*
     * Getter untuk bookings
     * TODO: Getter ini akan mengembalikan list bookings
     */
    public List<Booking> getBookings() {
        // TODO: lengkapi getter
    }
}
