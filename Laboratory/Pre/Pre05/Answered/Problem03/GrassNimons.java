/**
 * GrassNimons.java
 * Representasi Pokenimons bertipe GRASS.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang
 * digunakan
 * - Kelas ini menyerang jarak jauh
 */
public class GrassNimons extends Pokenimons implements RangedAttacker {
    /**
     * Membuat instance GrassNimons baru.
     *
     * TODO: Buatlah konstruktor ini dengan menggunakan super untuk
     * menginisialisasi tipe GRASS.
     * 
     * @param name nama Pokenimons
     * @param hp   HP awal
     */
    public GrassNimons(String name, int hp) {
        super(name, hp, Type.GRASS);
    }

    /**
     * Mengembalikan nama skill unik milik GrassNimons.
     *
     * TODO: Kembalikan nama skill GrassNimons, yaitu "Leaf Blade".
     * 
     * @return nama skill
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected String skillName() {
        return "Leaf Blade";
    }

    /**
     * Mengembalikan base damage untuk skill GrassNimons.
     *
     * TODO: Kembalikan nilai base damage untuk skill GrassNimons, yaitu 12.
     *
     * @return nilai damage dasar
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected int skillBaseDamage() {
        return 12;
    }

    /**
     * Evolusi GrassNimons.
     *
     * Aturan yang diharapkan:
     * - Jika fainted (HP 0), tidak dapat berevolusi; cetak pesan "<nama_pokenimons>
     * has fainted and cannot evolve.".
     * - Jika sudah berada pada bentuk akhir, kembalikan bentuk saat ini dan cetak
     * pesan "<nama_pokenimons> is already in final form.".
     * - Jika level telah mencapai minimal level 5, cetak pesan "<nama_pokenimons>
     * evolves into GrassEvoNimons!"
     * lalu kembalikan bentuk evolusi dengan HP bertambah 10 dan level
     * dipertahankan.
     * - Jika belum memenuhi syarat, cetak pesan "<nama_pokenimons> is not ready to
     * evolve.".
     * 
     * For your exploration: manfaatkan instanceof untuk melakukan guard.
     *
     * TODO: Implementasikan seluruh logika di atas sesuai spesifikasi.
     * 
     * @return objek bentuk saat ini atau bentuk evolusi
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    public Pokenimons evolve() {
        Pokenimons finalForm;
        if (isFainted()) {
            System.out.println(getName() + " has fainted and cannot evolve.");
            finalForm = this;
        } else if (this instanceof GrassEvoNimons) {
            System.out.println(getName() + " is already in final form.");
            finalForm = this;
        } else if (getLevel() >= 5) {
            System.out.println(getName() + " evolves into GrassEvoNimons!");
            finalForm = new GrassEvoNimons(getName(), getHp() + 10);
            finalForm.setLevel(getLevel());
        } else {
            System.out.println(getName() + " is not ready to evolve.");
            finalForm = this;
        }
        return finalForm;
    }
}
