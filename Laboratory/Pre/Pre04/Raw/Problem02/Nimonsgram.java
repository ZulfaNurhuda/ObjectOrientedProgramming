public class Nimonsgram {

    public static void main(String[] args) {
        PhotoPost p1 = new PhotoPost("pop_es", "sunset vibes", 3, false, true);
        PhotoPost p2 = new PhotoPost("kebin_binatang", "coffee time", 1, true, false);

        VideoPost v1 = new VideoPost("neck_gro", "day in my life as an agent", 60, false);
        VideoPost v2 = new VideoPost("dr.neroifa", "lab routine", 120, false);

        System.out.println("=== INITIAL OBJECTS ===");
        printPhoto(p1);
        printPhoto(p2);
        printVideo(v1);
        printVideo(v2);
        System.out.println();

        System.out.println("=== BASIC ACTIONS ===");
        System.out.println("-> Photo: shareTo()");
        p1.shareTo("kebin_binatang"); // harus mencetak: "Photo by @pop_es shared to kebin_binatang"
        p2.shareTo("dr.neroifa"); // harus mencetak: "Photo by @kebin_binatang shared to dr.neroifa"

        System.out.println("-> Photo: like() & comment()");
        p1.like(); p1.like(); p1.comment();   // naikkan engagement p1
        p2.like();                             // naikkan engagement p2 sedikit

        System.out.println("-> Video: view() & shareTo()");
        v1.view(); v1.view(); v1.like();       // v1: views + likes
        v1.shareTo("dr.neroifa");              // harus mencetak: "Video by @neck_gro shared to dr.neroifa"
        v2.view();                             // v2: sedikit views

        System.out.println();
        System.out.println("=== AFTER ACTIONS ===");
        printPhoto(p1);
        printPhoto(p2);
        printVideo(v1);
        printVideo(v2);
        System.out.println();

        System.out.println("=== INTERFACE AS TYPE (Engageable) ===");
        Engageable ePhotoA = p1;
        Engageable ePhotoB = p2;
        int cmpPhoto = ePhotoA.compareEngagement(ePhotoB);
        System.out.println("compareEngagement(p1 vs p2) = " + cmpToWord(cmpPhoto) + " (p1 dibanding p2)");

        Engageable eVideoA = v1;
        Engageable eVideoB = v2;
        int cmpVideo = eVideoA.compareEngagement(eVideoB);
        System.out.println("compareEngagement(v1 vs v2) = " + cmpToWord(cmpVideo) + " (v1 dibanding v2)");
        System.out.println();

        System.out.println("=== PostUtil ===");
        Object higherPhoto = PostUtil.findHigher(p1, p2);
        System.out.println("findHigher(Photo): " + classAndAuthor(higherPhoto));
        boolean sameVideo = PostUtil.isEqual(v1, v2);
        System.out.println("isEqual(Video v1,v2): " + sameVideo);
        System.out.println();

        // System.out.println("=== EXPERIMENT AREA (edit kode & jalankan ulang) ===");
        // PhotoPost px = new PhotoPost("daev_karambol", "shooting day", 5, false, true);
        // VideoPost vx = new VideoPost("sti.wart", "late night coding", 75, false);
        // px.like(); px.comment(); // tambahkan aksi lain jika mau
        // for (int i = 0; i < 3; i++) vx.view();
        // printPhoto(px);
        // printVideo(vx);

        System.out.println("Done.");
    }

    private static void printPhoto(PhotoPost p) {
        System.out.println("[Photo] @" + p.getAuthor()
                + " | caption=\"" + p.getCaption() + "\""
                + " | likes=" + p.getLikes()
                + " | comments=" + p.getComments()
                + " | shares=" + p.getShares()
                + " | hashtags=" + p.getHashtagCount()
                + " | useAI=" + p.isUseAI()
                + " | useMusic=" + p.isUseMusic());
    }

    private static void printVideo(VideoPost v) {
        System.out.println("[Video] @" + v.getAuthor()
                + " | caption=\"" + v.getCaption() + "\""
                + " | likes=" + v.getLikes()
                + " | comments=" + v.getComments()
                + " | shares=" + v.getShares()
                + " | views=" + v.getViews()
                + " | durationSec=" + v.getDurationSec()
                + " | useAI=" + v.isUseAI());
    }

    private static String cmpToWord(int cmp) {
        if (cmp < 0) return "LESS (-1)";
        if (cmp > 0) return "GREATER (1)";
        return "EQUAL (0)";
    }

    private static String classAndAuthor(Object o) {
        if (o instanceof PhotoPost p) return "PhotoPost by @" + p.getAuthor();
        if (o instanceof VideoPost v) return "VideoPost by @" + v.getAuthor();
        return (o == null) ? "null" : o.getClass().getSimpleName();
    }
}
