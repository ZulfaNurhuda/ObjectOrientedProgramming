/**
 * ElectricNimons.java
 * Representasi Pokenimons bertipe ELECTRIC.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang
 * digunakan
 * - Kelas ini menyerang jarak jauh
 *
 * Catatan: ElectricNimons tidak dapat berevolusi.
 */
public class ElectricNimons extends Pokenimons implements RangedAttacker {
    /**
     * Membuat instance ElectricNimons baru.
     *
     * TODO: Buatlah konstruktor ini dengan menggunakan super untuk
     * menginisialisasi tipe ELECTRIC.
     * 
     * @param name nama Pokenimons
     * @param hp   HP awal
     */
    public ElectricNimons(String name, int hp) {
        super(name, hp, Type.ELECTRIC);
    }

    /**
     * Mengembalikan nama skill unik milik ElectricNimons.
     *
     * TODO: Kembalikan nama skill ElectricNimons, yaitu "Thunder Shock".
     * 
     * @return nama skill
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected String skillName() {
        return "Thunder Shock";
    }

    /**
     * Mengembalikan base damage untuk skill unik ElectricNimons.
     *
     * TODO: Kembalikan nilai base damage untuk skill ElectricNimons, yaitu
     * 12.
     * 
     * @return nilai damage dasar
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected int skillBaseDamage() {
        return 12;
    }
}
