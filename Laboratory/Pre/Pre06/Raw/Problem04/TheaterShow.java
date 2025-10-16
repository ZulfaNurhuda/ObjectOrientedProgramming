public class TheaterShow {
    // TODO: Deklarasikan field untuk menyimpan title, venue, showDate, showTime, dan capacity
    // TODO: Deklarasikan array boolean untuk menandai kursi yang sudah terjual (seats)
    // TODO: Deklarasikan array untuk daftar performer (performers)
    // TODO: Tambahkan field static untuk menghitung total show yang pernah dibuat (totalShowsCreated)

    public TheaterShow(String title, String venue, String showDate, String showTime, int capacity) {
        // TODO: Inisialisasi semua field sesuai parameter
        // TODO: Pastikan kapasitas tidak negatif (minimal 1 atau lebih)
        // HINT: Gunakan Math.max
        // TODO: Inisialisasi seats dengan array boolean sebanyak capacity
        // TODO: Inisialisasi performers dengan array performer kosong
        // TODO: Increment totalShowsCreated setiap kali show baru dibuat
    }

    public static int getTotalShowsCreated() {
        // TODO: Kembalikan jumlah total show yang pernah dibuat
        return 0;
    }

    public String getTitle() {
        // TODO: Kembalikan title pertunjukan
        return null;
    }

    public String getVenue() {
        // TODO: Kembalikan venue pertunjukan
        return null;
    }

    public String getShowDate() {
        // TODO: Kembalikan tanggal pertunjukan
        return null;
    }

    public String getShowTime() {
        // TODO: Kembalikan waktu pertunjukan
        return null;
    }

    public int getCapacity() {
        // TODO: Kembalikan kapasitas pertunjukan
        return 0;
    }

    public int countSold() {
        // TODO: Hitung jumlah kursi yang sudah terjual dengan menghitung elemen true pada array seats
        return 0;
    }

    public boolean isSeatAvailable(int seatIdx) {
        // TODO: Periksa apakah index kursi valid minimal 1, maksimal capacity, dan kursi belum terjual
        return false;
    }

    // ================================
    // ENUM: TicketType
    // ================================
    public enum TicketType {
        // TODO: Tambahkan tipe tiket, yaitu REGULAR, PRESALE, dan VIP
    }

    // ================================
    // CLASS: ReservationDraft 
    // Class untuk membuat draft tiket sebelum konfirmasi pembelian
    // TODO: tentukan inner class / static nested class
    // ================================
    public ... class ReservationDraft {
        // TODO: Deklarasikan field untuk String buyer, int seatIdx, TicketType type, dan int quotedPrice dan tidak dapat diubah

        public ReservationDraft(String buyer, int seatIdx, TicketType type) {
            // TODO: Inisialisasi field buyer jika buyer adalah null, maka diubah menjadi string kosong
            // TODO: Inisialisasi field seatIdx dan type
            // TODO: Hitung harga tiket menggunakan method calc() pada PriceRules dan simpan ke field quotedPrice
        }

        public boolean isValid() {
            // TODO: Validasi buyer tidak kosong dan kursi masih tersedia
            return false;
        }

        public Ticket confirm() {
            // TODO: Jika valid, tandai kursi sebagai terjual dengan seat tersebut menjadi true
            // TODO: Jika tidak valid, kembalikan null
            // TODO: Kembalikan objek Ticket baru
            return null;
        }
    }

    public Ticket issueTicket(String buyer, int seatIdx, TicketType ticketType) {
        // TODO: Method issueTicket untuk melakukan reservasi dan mengonfirmasi pembelian tiket baru dari ReservationDraft        
        return null;
    }

    // ================================
    // CLASS: Ticket
    // Class untuk merepresentasikan tiket yang telah terjual setelah konfirmasi pembelian
    // TODO: Tentukan inner class / static nested class
    // ================================
    public ... class Ticket {
        // TODO: Deklarasikan field untuk String id, String buyer, TicketType ticketType, int seatIdx, dan int price dan tidak dapat diubah

        private Ticket(String buyer, int seatIdx, int price, TicketType ticketType) {
            // TODO: Inisialisasi semua field
            // TODO: Gunakan method pada class IdGenerator untuk membuat id unik
        }

        public String label() {
            // TODO: Gunakan method pada class SeatCode untuk format kursi
            // TODO: Tampilkan informasi tiket lengkap dengan format:
            // "[id] buyer | title on venue at showDate showTime | Seat seatCode [ticketType] | Rpprice"
            // Contoh:
            // “[TK-000001] Andi | Musical Theater on Grand Hall at 13 Oct 2025 19:00 | Seat A8 [VIP] | Rp150000”
            return null;
        }
    }

    // ================================
    // CLASS: IdGenerator
    // Class untuk menghasilkan ID unik untuk tiket
    // TODO: Tentukan inner class / static nested class
    // ================================
    public ... class IdGenerator {
        // TODO: Deklarasikan field untuk penomoran ID
        public static String next() {
            // TODO: Increment id tersebut dan kembalikan ID dalam format “TK-<id>”
            // Id akan dimulai dari 000001 dan akan terus bertambah
            // For your exploration: coba cari tahu cara format string dengan 6 digit
            return null;
        }
    }

    // ================================
    // CLASS: PriceRules
    // Class untuk menghitung harga tiket
    // TODO: Tentukan inner class / static nested class
    // ================================
    public ... class PriceRules {
        public static int calc(TicketType ticketType, boolean hasSenior) {
            // TODO: Tentukan base price berdasarkan tipe tiket
            // Jika tipe tiket adalah REGULAR, maka base price adalah 100000
            // Jika tipe tiket adalah PRESALE, maka base price adalah 80000
            // Jika tipe tiket adalah VIP, maka base price adalah 150000
            // TODO: Tambahkan penambahan harga sebesar 50000 jika ada performer senior dalam pertunjukan
            return 0;
        }
    }

    // ================================
    // CLASS: SeatCode
    // Class untuk mengonversi index kursi ke format baris dan kolom
    // TODO: Tentukan inner class / static nested class
    // ================================
    public ... class SeatCode {
        public static String toCode(int seatIdx) {
            // TODO: Konversi seatIdx ke format baris dan kolom (misal A1, A2, ... B1, dst.)
            // Jika seatIdx kurang dari 1, maka kembalikan "NA"
            // Satu baris terdiri dari 20 kolom
            // Jika satu baris telah terisi penuh, maka isi baris berikutnya dengan abjad selanjutnya
            // Contoh:
            // toCode(1) -> "A1"
            // toCode(9) -> "A9"
            // toCode(20) -> "A20"
            // toCode(21) -> "B1"
            // toCode(125) -> "G5"
            return null;
        }
    }

    // ================================
    // CLASS: Performer
    // Class untuk merepresentasikan performer dalam pertunjukan
    // TODO: Tentukan inner class / static nested class
    // ================================
    public ... class Performer {
        // TODO: Buat enum Role di dalam class ini dengan nilai SENIOR dan JUNIOR
        // HINT: Coba cari tahu tentang error yang muncul dan coba cari solusinya sendiri
        // TODO: Deklarasikan field name dan role

        public Performer(String name, Role role) {
            // TODO: Inisialisasi field name dan role
        }

        public String getName() {
            // TODO: Kembalikan nama performer
            return null;
        }

        public Role getRole() {
            // TODO: Kembalikan role performer
            return null;
        }
    }

    public void addPerformer(Performer performer) {
        // TODO: Tambahkan performer ke array performers
        // TODO: Gunakan System.arraycopy untuk memperbesar array
        // For your exploration: Coba cari tahu cara menambahkan elemen ke array yang sudah terdefinisi ukurannya
    }

    private boolean hasSeniorPerformer() {
        // TODO: Cek apakah ada performers dengan role SENIOR, jika ada minimal satu performer, maka kembalikan true
        return false;
    }
}