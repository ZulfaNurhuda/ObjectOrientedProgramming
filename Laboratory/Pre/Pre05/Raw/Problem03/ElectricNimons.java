/**
 * ElectricNimons.java
 * Representasi Pokenimons bertipe ELECTRIC.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar mewarisi kelas induk abstrak yang digunakan
 * - Kelas ini menyerang jarak jauh
 *
 * Catatan: ElectricNimons tidak dapat berevolusi.
 */
public class ElectricNimons {
  /**
   * Membuat instance ElectricNimons baru.
   *
   * @param name nama Pokenimons
   * @param hp   HP awal
   *
   * TODO: Buatlah konstruktor ini dengan menggunakan super untuk menginisialisasi tipe ELECTRIC.
   */
  public ElectricNimons(String name, int hp) {
    
  }

  /**
   * Mengembalikan nama skill unik milik ElectricNimons.
   *
   * @return nama skill
   *
   * TODO: Kembalikan nama skill ElectricNimons, yaitu "Thunder Shock".
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected String skillName() {
    return "TODO";
  }

  /**
   * Mengembalikan base damage untuk skill unik ElectricNimons.
   *
   * @return nilai damage dasar
   *
   * TODO: Kembalikan nilai base damage untuk skill ElectricNimons, yaitu 12.
   */
  // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
  protected int skillBaseDamage() { 
    return 0;
  }
}
  