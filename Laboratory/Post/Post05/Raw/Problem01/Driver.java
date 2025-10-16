public class Driver {
    public static void main(String[] args) {
        // Auth Pengelola
        Pengelola pengelola = new Pengelola();
        pengelola.register("user1", "user");
        pengelola.login("user2", "pass"); //gagal
        pengelola.login("user1", "pass"); //gagal
        pengelola.login("user1","user"); //berhasil
        pengelola.register("admin1", "admin"); // gagal, sudah terdaftar
        System.out.println("\n----------------------------AUTH PENGELOLA--------------------------\n");

        // Auth Mahasiswa Domestik
        Mahasiswa mhsDom = new MahasiswaDomestik(Gender.PRIA);
        mhsDom.login("ABCD-1234"); //gagal, belum terdaftar
        mhsDom.login("user", "pass"); //gagal, belum terdaftar

        mhsDom.register("user2", "pass2"); //berhasil
        mhsDom.login("user2", "pass2"); //berhasil
        String slug = mhsDom.getUserId() + "-" + mhsDom.getUsername();
        mhsDom.login(slug); // berhasil
        mhsDom.register(slug, slug); // gagal, sudah terdaftar

        System.out.println("\n----------------------------AUTH MAHASISWA DOMESTIK--------------------------\n");

        // Auth Mahasiswa Asing
        String country = "Kongo";
        Mahasiswa mhsAsing = new MahasiswaAsing(country);
        slug = mhsAsing.getUserId() + "-" + country;
        mhsAsing.login(slug); //gagal, belum terdaftar
        mhsAsing.login("user3", "pass3"); //gagal, belum terdaftar
        mhsAsing.register("user3", "pass3");//berhasil
        mhsAsing.login("user3", "pass3");//berhasil
        mhsAsing.register("user3", "pass3");//gagal, sudah terdaftar

        System.out.println("\n----------------------------AUTH MAHASISWA ASING--------------------------\n");


        // Assign Asrama
        // Sangkuriang
        Asrama asramaSangku = new GedungSangkuriang(3);
        Mahasiswa mhsDom2 = new MahasiswaDomestik(Gender.WANITA); // berhasil
        mhsDom2.register("user15", "pass15");
        Mahasiswa mhsDom3 = new MahasiswaDomestik(Gender.PRIA); // berhasil
        mhsDom3.register("user16", "pass16");
        Mahasiswa mhsDom4 = new MahasiswaDomestik(Gender.PRIA); // berhasil
        mhsDom4.register("user17", "pass17");
        
        asramaSangku.infoAsrama(); // log (kapasitas 3)
        asramaSangku.daftarAsrama(mhsDom); // berhasil
        asramaSangku.daftarAsrama(mhsAsing); // gagal, mahasiswa asing
        asramaSangku.daftarAsrama(mhsDom2); // berhasil
        asramaSangku.daftarAsrama(mhsDom3); // berhasil
        asramaSangku.daftarAsrama(mhsDom2); // gagal, sudah penuh

        System.out.println("\n----------------------------ASSIGN ASRAMA SANGKURIANG--------------------------\n");

        
        // Kidang Pananjung
        Asrama asramaKidang = new GedungKidangPananjung(2);
        asramaKidang.infoAsrama(); // log (kapasitas 2)
        asramaKidang.daftarAsrama(mhsDom); // berhasil
        MahasiswaDomestik mhsDom2Cast = (MahasiswaDomestik) mhsDom2;
        mhsDom2Cast.setGender(Gender.WANITA); 
        asramaKidang.daftarAsrama(mhsAsing); // gagal, mahasiswa asing
        asramaKidang.daftarAsrama(mhsDom2Cast); // gagal, karena WANITA
        asramaKidang.daftarAsrama(mhsDom3); // berhasil
        asramaKidang.daftarAsrama(mhsDom4); // gagal, sudah penuh

        System.out.println("\n----------------------------ASSIGN ASRAMA KIDANG PANANJUNG--------------------------\n");


    
        // Kanayakan
        Asrama asramaKanayakan = new GedungKanayakan(3);
        asramaKanayakan.infoAsrama(); // log (kapasitas 3)
        MahasiswaDomestik mhsDomCast = (MahasiswaDomestik) mhsDom;
        mhsDomCast.setGender(Gender.WANITA);
        asramaKanayakan.daftarAsrama(mhsDomCast); // berhasil
        asramaKanayakan.daftarAsrama(mhsAsing); // gagal, mahasiswa asing
        asramaKanayakan.daftarAsrama(mhsDom2Cast); // berhasil
        asramaKanayakan.daftarAsrama(mhsDom3); // gagal, karena PRIA
        MahasiswaDomestik mhsDom3Cast = (MahasiswaDomestik) mhsDom3;
        mhsDom3Cast.setGender(Gender.WANITA);
        asramaKanayakan.daftarAsrama(mhsDom3Cast); // berhasil
        asramaKanayakan.daftarAsrama(mhsDom4); // gagal, sudah penuh

        System.out.println("\n----------------------------ASSIGN ASRAMA KANAYAKAN--------------------------\n");


        // Internasional
        Asrama asramaInternasional = new GedungInternasional(1);
        asramaInternasional.infoAsrama(); // log (kapasitas 1)
        asramaInternasional.daftarAsrama(mhsDomCast); // gagal, mahasiswa domestik
        asramaInternasional.daftarAsrama(mhsAsing); // berhasil
        asramaInternasional.daftarAsrama(mhsAsing); // gagal, sudah penuh

        System.out.println("\n----------------------------ASSIGN ASRAMA INTERNASIONAL--------------------------\n");


        // Terima Pendaftaran
        pengelola.terimaPendaftaran(mhsDom, asramaSangku);
        System.out.printf("Mahasiswa %s tinggal di ", mhsDom.getUsername());
        mhsDom.getAsramaInfo();
        System.out.println();
        pengelola.terimaPendaftaran(mhsAsing, asramaInternasional);
        System.out.printf("Mahasiswa %s tinggal di ", mhsAsing.getUsername());
        mhsAsing.getAsramaInfo();
        System.out.println();
        pengelola.terimaPendaftaran(mhsDom3, asramaKidang);
        System.out.printf("Mahasiswa %s tinggal di ", mhsDom3.getUsername());
        mhsDom3.getAsramaInfo();
        System.out.println();
        pengelola.terimaPendaftaran(mhsDom2Cast, asramaKanayakan);
        System.out.printf("Mahasiswa %s tinggal di ", mhsDom2Cast.getUsername());
        mhsDom2Cast.getAsramaInfo();
        System.out.println();

        GedungSangkuriang GedungSangku = (GedungSangkuriang) asramaSangku;
        GedungSangku.kapasitas = 4; // menambah kapasitas asrama sangkuriang

        GedungKanayakan GedungKanayakan = (GedungKanayakan) asramaKanayakan;
        GedungKanayakan.kapasitas = 4; // menambah kapasitas asrama kanayakan

        GedungInternasional GedungInternasional = (GedungInternasional) asramaInternasional;
        GedungInternasional.kapasitas = 2; // menambah kapasitas asrama internasional

        GedungKidangPananjung GedungKidang = (GedungKidangPananjung) asramaKidang;
        GedungKidang.kapasitas = 3; // menambah kapasitas asrama kidang pananjung

        GedungSangku.daftarAsrama(mhsDom3);
        System.out.printf("Mahasiswa %s tinggal di ", mhsDom3.getUsername());
        mhsDom.getAsramaInfo();
        System.out.println();
        GedungKidang.daftarAsrama(mhsDom);
        System.out.printf("Mahasiswa %s tinggal di ", mhsDom.getUsername());
        mhsDom.getAsramaInfo();
        System.out.println();
        GedungKanayakan.daftarAsrama(mhsDom2Cast);
        System.out.printf("Mahasiswa %s tinggal di ", mhsDom2Cast.getUsername());
        mhsDom2Cast.getAsramaInfo();
        System.out.println();
        GedungInternasional.daftarAsrama(mhsAsing);
        System.out.printf("Mahasiswa %s tinggal di ", mhsAsing.getUsername());
        mhsAsing.getAsramaInfo();
        System.out.println("\n----------------------------TERIMA PENDAFTARAN--------------------------");
    }
}
