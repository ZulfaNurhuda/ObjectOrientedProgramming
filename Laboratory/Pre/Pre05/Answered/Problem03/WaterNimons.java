/**
 * WaterNimons.java
 * Representasi Pokenimons bertipe WATER.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang
 * digunakan
 * - Kelas ini menyerang jarak dekat
 */
public class WaterNimons extends Pokenimons {
    /**
     * Membuat instance WaterNimons baru.
     *
     * TODO: Buatlah konstruktor ini dengan menggunakan super untuk
     * menginisialisasi tipe WATER.
     * 
     * @param name nama Pokenimons
     * @param hp   HP awal
     */
    public WaterNimons(String name, int hp) {
        super(name, hp, Type.WATER);
    }

    /**
     * Mengembalikan nama skill unik milik WaterNimons.
     *
     * TODO: Kembalikan nama skill WaterNimons, yaitu "Water Gun".
     * 
     * @return nama skill
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected String skillName() {
        return "Water Gun";
    }

    /**
     * Base damage untuk skill WaterNimons.
     *
     *         TODO: Kembalikan base damage skill WaterNimons, yaitu 12.
     * 
     * @return nilai damage dasar
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected int skillBaseDamage() {
        return 12;
    }

    // WaterNimons tidak dapat berevolusi
}