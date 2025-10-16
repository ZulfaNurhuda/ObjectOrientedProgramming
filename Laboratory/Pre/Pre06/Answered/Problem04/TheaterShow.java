public class TheaterShow {
    // TODO: Deklarasikan field untuk menyimpan title, venue, showDate, showTime,
    // dan capacity
    // TODO: Deklarasikan array boolean untuk menandai kursi yang sudah terjual
    // (seats)
    // TODO: Deklarasikan array untuk daftar performer (performers)
    // TODO: Tambahkan field static untuk menghitung total show yang pernah dibuat
    // (totalShowsCreated)
    private String title;
    private String venue;
    private String showDate;
    private String showTime;
    private int capacity;
    private boolean[] seats;
    private Performer[] performers;
    private static int totalShowsCreated;

    public TheaterShow(String title, String venue, String showDate, String showTime, int capacity) {
        // TODO: Inisialisasi semua field sesuai parameter
        // TODO: Pastikan kapasitas tidak negatif (minimal 1 atau lebih)
        // HINT: Gunakan Math.max
        // TODO: Inisialisasi seats dengan array boolean sebanyak capacity
        // TODO: Inisialisasi performers dengan array performer kosong
        // TODO: Increment totalShowsCreated setiap kali show baru dibuat
        this.title = title;
        this.venue = venue;
        this.showDate = showDate;
        this.showTime = showTime;
        this.capacity = Math.max(1, capacity);
        seats = new boolean[this.capacity];
        performers = new Performer[0];
        totalShowsCreated++;
    }

    public static int getTotalShowsCreated() {
        // TODO: Kembalikan jumlah total show yang pernah dibuat
        return totalShowsCreated;
    }

    public String getTitle() {
        // TODO: Kembalikan title pertunjukan
        return title;
    }

    public String getVenue() {
        // TODO: Kembalikan venue pertunjukan
        return venue;
    }

    public String getShowDate() {
        // TODO: Kembalikan tanggal pertunjukan
        return showDate;
    }

    public String getShowTime() {
        // TODO: Kembalikan waktu pertunjukan
        return showTime;
    }

    public int getCapacity() {
        // TODO: Kembalikan kapasitas pertunjukan
        return capacity;
    }

    public int countSold() {
        // TODO: Hitung jumlah kursi yang sudah terjual dengan menghitung elemen true
        // pada array seats
        int totalSold = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                totalSold++;
            }
        }
        return totalSold;
    }

    public boolean isSeatAvailable(int seatIdx) {
        // TODO: Periksa apakah index kursi valid minimal 1, maksimal capacity, dan
        // kursi belum terjual
        boolean status = false;
        if (seatIdx >= 1 && seatIdx <= capacity) {
            status = !seats[seatIdx - 1];
        }
        return status;
    }

    // ================================
    // ENUM: TicketType
    // ================================
    public enum TicketType {
        // TODO: Tambahkan tipe tiket, yaitu REGULAR, PRESALE, dan VIP
        REGULAR, PRESALE, VIP
    }

    /** BIKIN ENUMNYA DISINI AJA, BUKAN DI CLASS THEATERSHOW */
    public enum Role {
        SENIOR, JUNIOR
    }

    // ================================
    // CLASS: ReservationDraft
    // Class untuk membuat draft tiket sebelum konfirmasi pembelian
    // TODO: tentukan inner class / static nested class
    // ================================
    public class ReservationDraft {
        // TODO: Deklarasikan field untuk String buyer, int seatIdx, TicketType type,
        // dan int quotedPrice dan tidak dapat diubah
        private final String buyer;
        private final int seatIdx;
        private final TicketType type;
        private final int quotedPrice;

        public ReservationDraft(String buyer, int seatIdx, TicketType type) {
            // TODO: Inisialisasi field buyer jika buyer adalah null, maka diubah menjadi
            // string kosong
            // TODO: Inisialisasi field seatIdx dan type
            // TODO: Hitung harga tiket menggunakan method calc() pada PriceRules dan simpan
            // ke field quotedPrice
            this.buyer = (buyer == null) ? "" : buyer;
            this.seatIdx = seatIdx;
            this.type = type;
            quotedPrice = PriceRules.calc(type, hasSeniorPerformer());
        }

        public boolean isValid() {
            // TODO: Validasi buyer tidak kosong dan kursi masih tersedia
            return !buyer.trim().isEmpty() && isSeatAvailable(seatIdx);
        }

        public Ticket confirm() {
            // TODO: Jika valid, tandai kursi sebagai terjual dengan seat tersebut menjadi
            // true
            // TODO: Jika tidak valid, kembalikan null
            // TODO: Kembalikan objek Ticket baru
            Ticket newTicket = null;
            if (isValid()) {
                seats[seatIdx - 1] = true;
                newTicket = new Ticket(buyer, seatIdx, quotedPrice, type);
            }
            return newTicket;
        }
    }

    public Ticket issueTicket(String buyer, int seatIdx, TicketType ticketType) {
        // TODO: Method issueTicket untuk melakukan reservasi dan mengonfirmasi
        // pembelian tiket baru dari ReservationDraft
        ReservationDraft draft = new ReservationDraft(buyer, seatIdx, ticketType);
        return draft.confirm();
    }

    // ================================
    // CLASS: Ticket
    // Class untuk merepresentasikan tiket yang telah terjual setelah konfirmasi
    // pembelian
    // TODO: Tentukan inner class / static nested class
    // ================================
    public class Ticket {
        // TODO: Deklarasikan field untuk String id, String buyer, TicketType
        // ticketType, int seatIdx, dan int price dan tidak dapat diubah
        private final String id;
        private final String buyer;
        private final TicketType ticketType;
        private final int seatIdx;
        private final int price;

        private Ticket(String buyer, int seatIdx, int price, TicketType ticketType) {
            // TODO: Inisialisasi semua field
            // TODO: Gunakan method pada class IdGenerator untuk membuat id unik
            id = IdGenerator.next();
            this.buyer = buyer;
            this.seatIdx = seatIdx;
            this.price = price;
            this.ticketType = ticketType;
        }

        public String label() {
            // TODO: Gunakan method pada class SeatCode untuk format kursi
            // TODO: Tampilkan informasi tiket lengkap dengan format:
            // "[id] buyer | title on venue at showDate showTime | Seat seatCode
            // [ticketType] | Rpprice"
            // Contoh:
            // "[TK-000001] Andi | Musical Theater on Grand Hall at 13 Oct 2025 19:00 | Seat
            // A8 [VIP] | Rp150000"
            String seatCode = SeatCode.toCode(seatIdx);
            return "[" + id + "] " + buyer + " | " + title + " on " + venue + " at " + showDate + " " + showTime
                    + " | Seat " + seatCode + " [" + ticketType + "] | Rp" + price;
        }
    }

    // ================================
    // CLASS: IdGenerator
    // Class untuk menghasilkan ID unik untuk tiket
    // TODO: Tentukan inner class / static nested class
    // ================================
    public static class IdGenerator {
        // TODO: Deklarasikan field untuk penomoran ID
        private static int counter = 0;

        public static String next() {
            // TODO: Increment id tersebut dan kembalikan ID dalam format "TK-<id>"
            // Id akan dimulai dari 000001 dan akan terus bertambah
            // For your exploration: coba cari tahu cara format string dengan 6 digit
            counter++;
            return String.format("TK-%06d", counter);
        }
    }

    // ================================
    // CLASS: PriceRules
    // Class untuk menghitung harga tiket
    // TODO: Tentukan inner class / static nested class
    // ================================
    public static class PriceRules {
        public static int calc(TicketType ticketType, boolean hasSenior) {
            // TODO: Tentukan base price berdasarkan tipe tiket
            // Jika tipe tiket adalah REGULAR, maka base price adalah 100000
            // Jika tipe tiket adalah PRESALE, maka base price adalah 80000
            // Jika tipe tiket adalah VIP, maka base price adalah 150000
            // TODO: Tambahkan penambahan harga sebesar 50000 jika ada performer senior
            // dalam pertunjukan
            int basePrice = 0;

            if (ticketType == TicketType.REGULAR) {
                basePrice = 100000;
            } else if (ticketType == TicketType.PRESALE) {
                basePrice = 80000;
            } else if (ticketType == TicketType.VIP) {
                basePrice = 150000;
            }

            if (hasSenior) {
                basePrice += 50000;
            }

            return basePrice;
        }
    }

    // ================================
    // CLASS: SeatCode
    // Class untuk mengonversi index kursi ke format baris dan kolom
    // TODO: Tentukan inner class / static nested class
    // ================================
    public static class SeatCode {
        public static String toCode(int seatIdx) {
            // TODO: Konversi seatIdx ke format baris dan kolom (misal A1, A2, ... B1, dst.)
            // Jika seatIdx kurang dari 1, maka kembalikan "NA"
            // Satu baris terdiri dari 20 kolom
            // Jika satu baris telah terisi penuh, maka isi baris berikutnya dengan abjad
            // selanjutnya
            // |====== Contoh =======|
            // | toCode(1) -> "A1"   |
            // | toCode(9) -> "A9"   |
            // | toCode(20) -> "A20" |
            // | toCode(21) -> "B1"  |
            // | toCode(125) -> "G5" |
            // |=====================|
            String code = "NA";
            if (seatIdx >= 1) {
                int idx = seatIdx - 1;
                int row = idx / 20;
                int col = (idx % 20) + 1;
                code = String.format("%c%d", (char) ('A' + row), col);
            }
            return code;
        }
    }

    // ================================
    // CLASS: Performer
    // Class untuk merepresentasikan performer dalam pertunjukan
    // TODO: Tentukan inner class / static nested class
    // ================================
    public class Performer {
        // TODO: Buat enum Role di dalam class ini dengan nilai SENIOR dan JUNIOR
        // HINT: Coba cari tahu tentang error yang muncul dan coba cari solusinya
        // sendiri
        /** SOLUSINYA, JANGAN BIKIN ROLE DISINI */

        // TODO: Deklarasikan field name dan role
        private String name;
        private Role role;

        public Performer(String name, Role role) {
            // TODO: Inisialisasi field name dan role
            this.name = name;
            this.role = role;
        }

        public String getName() {
            // TODO: Kembalikan nama performer
            return name;
        }

        public Role getRole() {
            // TODO: Kembalikan role performer
            return role;
        }
    }

    public void addPerformer(Performer performer) {
        // TODO: Tambahkan performer ke array performers
        // TODO: Gunakan System.arraycopy untuk memperbesar array
        // For your exploration: Coba cari tahu cara menambahkan elemen ke array yang
        // sudah terdefinisi ukurannya
        Performer[] newPerformers = new Performer[performers.length + 1];
        System.arraycopy(performers, 0, newPerformers, 0, performers.length);
        newPerformers[performers.length] = performer;
        performers = newPerformers;
    }

    private boolean hasSeniorPerformer() {
        // TODO: Cek apakah ada performers dengan role SENIOR, jika ada minimal satu
        // performer, maka kembalikan true
        boolean found = false;
        for (int i = 0; i < performers.length && !found; i++) {
            Performer performer = performers[i];
            if (performer.getRole() == Role.SENIOR) {
                found = true;
            }
        }
        return found;
    }
}