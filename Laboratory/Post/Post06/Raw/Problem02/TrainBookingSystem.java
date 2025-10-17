import java.util.List;

public class TrainBookingSystem {
    // private List<Train> trains;
    // private BookingManager bookingManager;

    /*
     * Konstruktor Kelas TrainBookingSystem
     * TODO: Lengkapi state awal dari attribut TrainBookingSystem
     *      - Inisialisasi trains dari parameter konstruktor
     *      - Inisialisasi bookingManager dengan objek BookingManager baru
     */
    public TrainBookingSystem(List<Train> trains) {
        // TODO: lengkapi konstruktor
    }

    /*
     * Method showTrains
     * TODO:    Method ini berupa prosedur yang akan menampilkan semua kereta yang ada di dalam list trains.
     *          Awali dengan menampilkan header "=== Daftar Kereta Tersedia ==="
     *          - Jika tidak ada kereta, tampilkan pesan "(Tidak ada kereta tersedia)\n"
     *          - Jika trains tidak kosong, print objek train satu per satu dengan format "<index>. <train.toString()>"
     *          - Index dimulai dari 1
     *          - Akhiri dengan baris kosong
     */
    public void showTrains() {
        // TODO: Lengkapi method showTrains
    }

    /*
     * Method bookTicket
     * TODO:    Method ini berupa prosedur yang akan melakukan booking tiket 
     *          untuk customerName pada kereta dengan nama trainName.
     *          - Jika kereta dengan nama trainName tidak ditemukan, 
     *              tampilkan pesan "Kereta tidak ditemukan: <trainName>"
     *          - Jika kereta ditemukan tetapi tidak ada kursi tersedia, 
     *              tampilkan pesan "Kursi penuh pada kereta: <trainName>"
     *          - Jika booking berhasil, buat objek Booking baru dengan 
     *              customerName dan objek Train yang bersangkutan.
     *              Tambahkan booking ke dalam BookingManager, kurangi kursi pada kereta, 
     *              dan tampilkan pesan "Booking berhasil: <booking.toString()>"
     */
    public void bookTicket(String customerName, String trainName) {
        // TODO: lengkapi method bookTicket
    }

    /*
     * Method cancelBooking
     * TODO: Method ini berupa prosedur yang akan membatalkan booking dengan bookingId tertentu.
     *         Gunakan method cancel dari BookingManager.Action untuk membatalkan booking.
     * 
     */
    public void cancelBooking(String bookingId) {
        // TODO: lengkapi method cancelBooking
    }

    /*
     * Method showAllBookings
     * TODO: Method ini berupa prosedur yang akan menampilkan semua booking yang ada di dalam BookingManager.
     *        Gunakan method showAllBookings dari BookingManager untuk menampilkan semua booking.
     */
    public void showAllBookings() {
        // TODO: lengkapi method showAllBookings
    }
}
