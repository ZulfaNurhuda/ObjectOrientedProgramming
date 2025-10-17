import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train("Argo Parahyangan", 3));
        trains.add(new Train("Lodaya", 2));
        trains.add(new Train("Taksaka", 1));

        TrainBookingSystem system = new TrainBookingSystem(trains);

        system.showTrains();
        System.out.println();

        system.bookTicket("Penumpang 1", "Lodaya");
        system.bookTicket("Penumpang 2", "Mutiara Selatan"); // Kereta tidak ditemukan
        system.bookTicket("Penumpang 2", "Lodaya");
        system.bookTicket("Penumpang 3", "Lodaya"); // Kursi penuh

        System.out.println();
        system.showAllBookings();

        // Batalkan salah satu booking
        System.out.println("\n=== Pembatalan Booking ===");
        system.cancelBooking("BK1002"); // Cancel booking dengan ID BK1002

        // Lihat daftar booking dan kursi terbaru
        System.out.println();
        system.showAllBookings();
        System.out.println();
        system.showTrains();
    }
}
