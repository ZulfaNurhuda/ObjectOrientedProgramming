public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to THEATER SHOW Demo ===\n");

        // ------------------------------------------------------------
        // 1) Instansiasi show
        //    Catatan:
        //    - seats menggunakan indeks 1-based (lihat SeatCode & isSeatAvailable)
        //    - capacity min 1 (dipaksa Math.max(1, capacity))
        // ------------------------------------------------------------
        TheaterShow show = new TheaterShow(
            "My Sunshine", "Grand Hall",
            "2025-10-16", "19:00", 25
        );

        System.out.println("Show created:");
        System.out.println("  Title : " + show.getTitle());
        System.out.println("  Venue : " + show.getVenue());
        System.out.println("  Date  : " + show.getShowDate());
        System.out.println("  Time  : " + show.getShowTime());
        System.out.println("  Cap   : " + show.getCapacity());
        System.out.println();

        // ------------------------------------------------------------
        // 2) SeatCode & ketersediaan kursi (teaser 1-based index)
        //    Perhatikan: implementasi isSeatAvailable() saat ini menggunakan
        //    batas atas '< capacity' sehingga kursi terakhir (== capacity)
        //    akan dianggap TIDAK valid. Biarkan praktikan melihat & menganalisis.
        // ------------------------------------------------------------
        System.out.println("Seat mapping examples (1-based):");
        int[] sampleSeats = {1, 20, 21, show.getCapacity(), show.getCapacity() + 1};
        for (int s : sampleSeats) {
            String code = TheaterShow.SeatCode.toCode(s);
            boolean avail = show.isSeatAvailable(s);
            System.out.printf("  Seat %d -> %-3s | available=%s%n", s, code, avail);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3) Tambahkan performer
        //    Inner class: Performer melekat ke satu show tertentu.
        //    - Tanpa SENIOR: harga REGULAR = 100.000; PRESALE = 80.000; VIP = 150.000
        //    - Jika ada SENIOR: +50.000 (PriceRules.calc)
        // ------------------------------------------------------------
        System.out.println("Add performers:");
        show.addPerformer(show.new Performer("Intan",  TheaterShow.Role.JUNIOR));
        show.addPerformer(show.new Performer("Nur",  TheaterShow.Role.JUNIOR));
        System.out.println("  Added JUNIOR x2");
        System.out.println("  (Coba bandingkan harga tiket sebelum & sesudah ada SENIOR)\n");

        // ------------------------------------------------------------
        // 4) Flow DRAFT -> CONFIRM (inner ReservationDraft)
        //    Draft = quote (belum mengunci kursi); Confirm = komit (kursi terkunci)
        // ------------------------------------------------------------
        System.out.println("Draft -> Confirm (kursi 1, REGULAR, tanpa SENIOR):");
        TheaterShow.ReservationDraft d1 = show.new ReservationDraft("Aulia", 1, TheaterShow.TicketType.REGULAR);
        System.out.println("  Valid draft? " + d1.isValid());
        TheaterShow.Ticket t1 = d1.confirm();
        if (t1 != null) {
            System.out.println("  Ticket issued:");
            System.out.println("   " + t1.label());
        } else {
            System.out.println("  Confirm failed (draft invalid)");
        }
        System.out.println("  Sold so far: " + show.countSold() + "\n");

        // Tambahkan SENIOR lalu coba DRAFT baru untuk melihat efek harga
        System.out.println("Add 1 SENIOR performer, then draft VIP on seat 2:");
        show.addPerformer(show.new Performer("Jesslyn", TheaterShow.Role.SENIOR));
        TheaterShow.ReservationDraft d2 = show.new ReservationDraft("Budiman", 2, TheaterShow.TicketType.VIP);
        System.out.println("  Valid draft? " + d2.isValid());
        TheaterShow.Ticket t2 = d2.confirm();
        if (t2 != null) {
            System.out.println("  Ticket issued:");
            System.out.println("   " + t2.label()); // perhatikan harga VIP + 50.000
        }
        System.out.println("  Sold so far: " + show.countSold() + "\n");

        // ------------------------------------------------------------
        // 5) Double booking: coba ambil seat 2 lagi (harus gagal -> null)
        // ------------------------------------------------------------
        System.out.println("Try double-booking seat 2 (should return null):");
        TheaterShow.Ticket tDup = show.issueTicket("Caca", 2, TheaterShow.TicketType.REGULAR);
        System.out.println("  Result: " + (tDup == null ? "NULL (blocked)" : "Should not happen"));
        System.out.println();

        // ------------------------------------------------------------
        // 6) Issue cepat (tanpa draft): PRESALE kursi 21 (harusnya B1)
        // ------------------------------------------------------------
        System.out.println("Issue quickly (no draft): seat 21 PRESALE");
        TheaterShow.Ticket t3 = show.issueTicket("Desi", 21, TheaterShow.TicketType.PRESALE);
        if (t3 != null) {
            System.out.println("  Ticket issued:");
            System.out.println("   " + t3.label()); // check "Seat B1 [PRESALE]"
        }
        System.out.println("  Sold so far: " + show.countSold() + "\n");

        // ------------------------------------------------------------
        // 7) Coba kursi terakhir (== capacity) untuk melihat perilaku current impl
        //    Jika ingin memperbaiki, ubah isSeatAvailable() menjadi <= capacity
        // ------------------------------------------------------------
        int last = show.getCapacity();
        System.out.println("Try last seat (capacity = " + last + "):");
        System.out.println("  isSeatAvailable(" + last + ") -> " + show.isSeatAvailable(last));
        TheaterShow.Ticket tLast = show.issueTicket("Eko", last, TheaterShow.TicketType.REGULAR);
        System.out.println("  issueTicket(last) -> " + (tLast == null ? "NULL (current impl)" : tLast.label()));
        System.out.println();

        // ------------------------------------------------------------
        // 8) Gambaran umum: cetak beberapa seat mapping agar terasa 1-based
        // ------------------------------------------------------------
        System.out.println("Seat mapping (first 2 rows):");
        for (int i = 1; i <= Math.min(40, show.getCapacity()); i++) {
            System.out.printf("%-4s", TheaterShow.SeatCode.toCode(i));
            if (i % 20 == 0) System.out.println();
        }
        System.out.println("\n");

        // ------------------------------------------------------------
        // 9) Tunjukkan bahwa IdGenerator itu GLOBAL (static)
        //    Buat show lain dan lihat ID lanjut (bukan kembali ke TK-000001)
        // ------------------------------------------------------------
        System.out.println("ID Generator is GLOBAL across shows:");
        TheaterShow other = new TheaterShow("Teenage Girls", "Red Theater", "2025-11-03", "14:00", 10);
        TheaterShow.Ticket ox = other.issueTicket("Fina", 1, TheaterShow.TicketType.REGULAR);
        TheaterShow.Ticket oy = other.issueTicket("Gilang", 2, TheaterShow.TicketType.REGULAR);
        if (ox != null) System.out.println("  " + ox.label());
        if (oy != null) System.out.println("  " + oy.label());
        System.out.println();

        // ------------------------------------------------------------
        // 10) Ringkasan akhir
        // ------------------------------------------------------------
        System.out.println("=== SUMMARY ===");
        System.out.println("Show        : " + show.getTitle() + " @ " + show.getVenue());
        System.out.println("Date & Time : " + show.getShowDate() + " " + show.getShowTime());
        System.out.println("Capacity    : " + show.getCapacity());
        System.out.println("Sold        : " + show.countSold());
        System.out.println();

        System.out.println("Other Show  : " + other.getTitle() + " @ " + other.getVenue());
        System.out.println("Date & Time : " + other.getShowDate() + " " + other.getShowTime());
        System.out.println("Capacity    : " + other.getCapacity());
        System.out.println("Sold        : " + other.countSold());

        System.out.println("\n=== END DEMO ===");
    }
}