/**
 * FireNimons.java
 * Representasi Pokenimons bertipe FIRE.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang
 * digunakan
 * - Kelas ini menyerang jarak dekat
 */
public class FireNimons extends Pokenimons {
    /**
     * Membuat instance FireNimons baru.
     *
     * TODO: Buatlah konstruktor ini dengan menggunakan super untuk
     * menginisialisasi tipe FIRE.
     * 
     * @param name nama Pokenimons
     * @param hp   HP awal
     */
    public FireNimons(String name, int hp) {
        super(name, hp, Type.FIRE);
    }

    /**
     * Mengembalikan nama skill unik milik FireNimons.
     *
     * TODO: Kembalikan nama skill FireNimons, yaitu "Flamethrower".
     * 
     * @return nama skill
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected String skillName() {
        return "Flamethrower";
    }

    /**
     * Mengembalikan base damage untuk skill FireNimons.
     *
     * TODO: Kembalikan nilai base damage untuk skill FireNimons, yaitu 12.
     * 
     * @return nilai damage dasar
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected int skillBaseDamage() {
        return 12;
    }

    /**
     * Evolusi FireNimons.
     *
     * Aturan yang diharapkan:
     * - Jika fainted (HP 0), tidak dapat berevolusi; cetak pesan "<nama_pokenimons>
     * has fainted and cannot evolve.".
     * - Jika sudah berada pada bentuk akhir, kembalikan bentuk saat ini dan cetak
     * pesan "<nama_pokenimons> is already in final form.".
     * - Jika level telah mencapai minimal level 10, cetak pesan "<nama_pokenimons>
     * evolves into FireEvoNimons!"
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
        } else if (this instanceof FireEvoNimons) {
            System.out.println(getName() + " is already in final form.");
            finalForm = this;
        } else if (getLevel() >= 10) {
            System.out.println(getName() + " evolves into FireEvoNimons!");
            finalForm = new FireEvoNimons(getName(), getHp() + 10);
            finalForm.setLevel(getLevel());
        } else {
            System.out.println(getName() + " is not ready to evolve.");
            finalForm = this;
        }
        return finalForm;
    }
}
