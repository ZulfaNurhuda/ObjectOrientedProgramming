public class Main {
    public static void main(String[] args) {
        NewsAgency agensiBerita = new NewsAgency("Jaringan Berita");
        WeatherAgency agensiCuaca = new WeatherAgency("Pusat Informasi Cuaca");
        SportsAgency agensiOlahraga = new SportsAgency("Pusat Informasi Olahraga");

        UserSubscriber stewart = new UserSubscriber("Stewart");
        UserSubscriber otto = new UserSubscriber("Otto");
        UserSubscriber gro = new UserSubscriber("Gro");

        System.out.printf("Total agensi: %d%n", AbstractAgency.getAgencyCount());
        System.out.printf("Total pengguna: %d%n", UserSubscriber.getUserCount());
        System.out.println();

        agensiBerita.addSubscriber(stewart);
        agensiBerita.addSubscriber(otto);

        agensiCuaca.addSubscriber(stewart);
        agensiCuaca.addSubscriber(otto);
        agensiCuaca.addSubscriber(gro);

        agensiOlahraga.addSubscriber(otto);
        System.out.println();

        stewart.addCategoryPreference(agensiBerita.getAgencyName(), "Politik", DeliveryMethod.EMAIL);
        stewart.addCategoryPreference(agensiBerita.getAgencyName(), "Teknologi", DeliveryMethod.APP);
        stewart.addCategoryPreference(agensiCuaca.getAgencyName(), "Badai", DeliveryMethod.SMS);
        System.out.println();

        otto.addCategoryPreference(agensiOlahraga.getAgencyName(), "Sepak Bola", DeliveryMethod.APP);
        otto.addCategoryPreference(agensiCuaca.getAgencyName(), "Hujan", DeliveryMethod.EMAIL);
        System.out.println();

        stewart.addCategoryPreference(agensiBerita.getAgencyName(), "Politik", DeliveryMethod.EMAIL);
        System.out.println();

        agensiBerita.publishNews("Liputan debat dijadwalkan malam ini.", "Politik");
        System.out.println();

        agensiBerita.publishNews("Hasil pemilu telah masuk.", "Politik");
        System.out.println();

        agensiBerita.publishNews("Ponsel pintar baru dirilis minggu ini.", "Teknologi");
        System.out.println();

        agensiCuaca.publishWeather("Hujan deras diperkirakan besok.", "Hujan");
        System.out.println();

        agensiCuaca.publishWeather("Badai tropis mendekati pesisir.", "Badai");
        System.out.println();

        agensiOlahraga.publishSports("Jadwal liga sepak bola diumumkan.", "Sepak Bola");
        System.out.println();

        agensiOlahraga.addSubscriber(stewart);
        stewart.addCategoryPreference(agensiOlahraga.getAgencyName(), "Sepak Bola", DeliveryMethod.APP);
        System.out.println();

        agensiOlahraga.publishSports("Penyerang bintang menandatangani kontrak baru.", "Sepak Bola");
        System.out.println();

        otto.removeCategoryPreference(agensiCuaca.getAgencyName(), "Hujan");
        System.out.println();

        otto.removeCategoryPreference(agensiBerita.getAgencyName(), "Ekonomi");
        agensiBerita.publishNews("Prospek ekonomi tetap stabil.", "Ekonomi");
        System.out.println();

        stewart.removeCategoryPreference("Informasi Antariksa", "Eksplorasi");
        agensiCuaca.publishWeather("Langit cerah di atas.", "Cerah");
        System.out.println();

        gro.removeCategoryPreference(agensiCuaca.getAgencyName(), "Badai");
        agensiCuaca.publishWeather("Sistem badai telah melemah.", "Badai");
        System.out.println();

        gro.setDeliveryMethod(agensiBerita.getAgencyName(), DeliveryMethod.SMS);
        System.out.println();

        agensiBerita.publishNews("Terkini: reli pasar berlanjut.", "Keuangan");
        System.out.println();

        gro.addCategoryPreference(agensiCuaca.getAgencyName(), "Panas", DeliveryMethod.EMAIL);
        agensiCuaca.publishWeather("Suhu meningkat di atas rata-rata.", "Panas");
    }
}
