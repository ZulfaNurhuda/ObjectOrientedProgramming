public class Event {
    private String title;
    private Waktu start; // komposisi objek
    private Waktu end;   // komposisi objek

    // Static counter untuk total event
    private static int totalEvents = 0;

    // TODO: static getter getTotalEvents()

    // ========== CONSTRUCTORS (OVERLOADING) ==========

    // TODO: Constructor default
    //  - title = "Untitled"
    //  - start = 00:00
    //  - end   = 00:00
    //  - tingkatkan totalEvents

    // TODO: Constructor Event(String title, Waktu start, Waktu end)
    //  - title kosong/null jadi title nya "Untitled"
    //  - jika start/end null berarti ganti dengan 00:00
    //  - simpan salinan baru dari start & end. Ingat tentang referensi objek? biar gak seperti itu lakukan penyalinan dengan cara:
    //      - contoh untuk atribut start dari event yang akan dibuat (this.start) harus di assign new Waktu(Waktu.toMinutes(start));
    //  - tingkatkan totalEvents

    // TODO: Constructor Event(String title, int sh, int sm, int eh, int em)
    //  - buat start (dari start hour dan start minute) & end (dari end hour dan end minutes)
    //  - kalau title kosong/null jadi title nya "Untitled"
    //  - tingkatkan totalEvents

    // TODO: Constructor Event(String title, Waktu start, int durationMin)
    //  - end = start + durationMin (pakai Waktu.addMinutes)
    //  - title kosong/null jadi title nya "Untitled"
    //  - ini juga simpan salinan start-nya 
    //  - tingkatkan totalEvents

    // TODO: Getter getTitle(), getStart(), getEnd()
    //  - untuk start & end, kembalikan salinan baru jangan langsung this.start atau this.end

    // TODO: static boolean isOverlap(Event a, Event b)
    //  - return true jika rentang waktu keduanya beririsan

    @Override
    public String toString() {
        // TODO: kembalikan (bukan print) string seperti
        // "Judul [start-end] (tz: WIB)"
        // contoh: "Praktikum OOP [09:00 WIB-11:00 WIB] (tz: WIB)"
        
    }
}
