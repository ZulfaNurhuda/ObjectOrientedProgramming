/**
 * GrassNimons.java
 * Representasi Pokenimons bertipe GRASS.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang digunakan
 * - Kelas ini menyerang jarak jauh
 */
public class GrassNimons {
  /**
   * Membuat instance GrassNimons baru.
   *
   * @param name nama Pokenimons
   * @param hp   HP awal
   *
   * TODO: Buatlah konstruktor ini dengan menggunakan super untuk menginisialisasi tipe GRASS.
   */
  public GrassNimons(String name, int hp) {
    
  }

  /**
   * Mengembalikan nama skill unik milik GrassNimons.
   *
   * @return nama skill
   *
   * TODO: Kembalikan nama skill GrassNimons, yaitu "Leaf Blade".
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected String skillName() {
    return "TODO";
  }

  /**
   * Mengembalikan base damage untuk skill GrassNimons.
   *
   * @return nilai damage dasar
   *
   * TODO: Kembalikan nilai base damage untuk skill GrassNimons, yaitu 12.
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected int skillBaseDamage() {
    return 0;
  }

  /**
   * Evolusi GrassNimons.
   *
   * Aturan yang diharapkan:
   * - Jika fainted (HP 0), tidak dapat berevolusi; cetak pesan "<nama_pokenimons> has fainted and cannot evolve.".
   * - Jika sudah berada pada bentuk akhir, kembalikan bentuk saat ini dan cetak pesan "<nama_pokenimons> is already in final form.".
   * - Jika level telah mencapai minimal level 5, cetak pesan "<nama_pokenimons> evolves into GrassEvoNimons!"
   *   lalu kembalikan bentuk evolusi dengan HP bertambah 10 dan level dipertahankan.
   * - Jika belum memenuhi syarat, cetak pesan "<nama_pokenimons> is not ready to evolve.".
   * 
   * For your exploration: manfaatkan instanceof untuk melakukan guard.
   *
   * @return objek bentuk saat ini atau bentuk evolusi
   *
   * TODO: Implementasikan seluruh logika di atas sesuai spesifikasi.
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  public Pokenimons evolve() {
    return null;
  }
}
