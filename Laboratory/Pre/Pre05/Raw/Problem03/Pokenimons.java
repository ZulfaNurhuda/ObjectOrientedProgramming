/**
 * Pokenimons.java
 * Abstraksi dasar untuk semua makhluk Pokenimons.
 */
public abstract class Pokenimons {
  // TODO: Definisikan field sesuai kebutuhan (nama, hp, level, type). Level awal adalah 1. Buatlah atribut name dan type menjadi tidak boleh diubah-ubah.
  

  /**
   * Konstruktor dasar Pokenimons.
   *
   * @param name nama makhluk
   * @param hp   HP awal (batas bawah minimal 1)
   * @param type tipe unsur
   *
   * TODO: Inisialisasi field dan lakukan batas bawah HP minimal 1.
   */
  public Pokenimons(String name, int hp, Type type) {
    // TODO: Isi inisialisasi properti dasar
  }

  // ===== Akses dasar =====
  // TODO: Buatlah getter untuk nama, HP, level, dan tipe.
  /**
   * Getter untuk nama Pokenimons
   * @return nama Pokenimons
   */
  public String getName() {
    return null;
  }

  /**
   * Getter untuk HP Pokenimons
   * @return HP Pokenimons
   */
  public int getHp() {
    return 0;
  }

  /**
   * Getter untuk level Pokenimons
   * @return level Pokenimons
   */
  public int getLevel() {
    return 0;
  }

  /**
   * Getter untuk tipe Pokenimons
   * @return tipe Pokenimons
   */
  public Type getType() {
    return null;
  }

  /**
   * @return true jika HP <= 0.
   *
   * TODO: Implementasikan sesuai definisi fainted.
   */
  public boolean isFainted() { 
    return false;
  }

  /**
   * Setter untuk HP Pokenimons
   * @param hp HP Pokenimons
   */
  public void setHp(int hp) {
    return;
  }

  /**
   * Setter untuk level Pokenimons
   * @param level level Pokenimons
   */
  public void setLevel(int level) {
    return;
  }

  /**
   * Menerapkan damage ke Pokenimons ini.
   *
   * Aturan yang diharapkan:
   * - Damage negatif dianggap 0.
   * - HP tidak boleh menjadi negatif (batas bawah 0).
   * - Kurangi HP dengan damage yang diterima.
   * - Cetak log berbentuk: "<nama_pokenimons> took <jumlah_damage> dmg (HP: <hp_setelah>)".
   *
   * @param dmg besaran damage mentah
   *
   * TODO: Implementasikan sesuai aturan di atas.
   */
  public void takeDamage(int dmg) {
    
  }

  /**
   * Level up sederhana.
   *
   * Aturan yang diharapkan: level +1, HP +5, dan cetak log naik level "<nama_pokenimons> leveled up to <level_baru>!".
   *
   * TODO: Implementasikan sesuai aturan.
   */
  public void levelUp() {
    
  }

  /**
   * Perilaku evolusi default: tidak berevolusi.
   * Subclass yang bisa berevolusi dapat override dan mengembalikan objek bentuk baru.
   *
   * @return objek ini (default)
   *
   * TODO: Cetak log yang sesuai bila tidak bisa berevolusi "<nama_pokenimons> cannot evolve.".
   */
  public Pokenimons evolve() {
    return null;
  }

  /**
   * Serangan fisik generik.
   *
   * Petunjuk:
   * - Bila penyerang fainted, cetak log "<nama_pokenimons> has fainted and cannot act." dan batalkan.
   * - Bila target fainted, cetak log "<nama_pokenimons> has fainted and cannot be attacked." dan batalkan.
   * - Tentukan penanda [RANGED] atau [MELEE] berdasarkan Pokenimons menyerang jarak jauh atau dekat.
   * - Gunakan damage dasar 10 dan kalikan dengan multiplier berdasarkan tipe penyerang terhadap target. Jangan lupa untuk casting ke int.
   * - Cetak log aksi "[<RANGED/MELEE>] <nama_pokenimons> uses Tackle on <nama_target> (x<mult>)" lalu terapkan damage. Gunakan method fmt(double) untuk memformat multiplier.
   *
   * TODO: Implementasikan seluruh langkah di atas.
   */
  public final void attack(Pokenimons target) {
    
  }

  /**
   * Template method untuk mengeksekusi skill unik tiap subclass.
   *
   * Petunjuk:
   * - Bila penyerang fainted, cetak log "<nama_pokenimons> has fainted and cannot act." dan batalkan.
   * - Bila target fainted, cetak log "<nama_pokenimons> has fainted and cannot be attacked." dan batalkan.
   * - Ambil nama skill dari hook skillName() dan base damage dari skillBaseDamage().
   * - Kalikan base damage dengan multiplier tipe terhadap target. Jangan lupa untuk casting ke int.
   * - Cetak log aksi "<nama_pokenimons> uses <nama_skill> on <nama_target> (x<mult>)" lalu terapkan damage. Gunakan method fmt(double) untuk memformat multiplier.
   *
   * TODO: Implementasikan sesuai petunjuk di atas.
   */
  public final void useSkill(Pokenimons target) {
    
  }

  // ===== Hooks untuk subclass =====
  protected abstract String skillName();
  protected abstract int    skillBaseDamage();

  // ===== Efektivitas tipe =====
  /**
   * Menghitung multiplier efektivitas berdasarkan tipe penyerang (this.type) vs tipe target.
   */
  protected double typeMultiplierAgainst(Type def) {
      if (this.getType() == Type.FIRE     && def == Type.GRASS)    return 2.0;
      if (this.getType() == Type.WATER    && def == Type.FIRE)     return 2.0;
      if (this.getType() == Type.GRASS    && def == Type.WATER)    return 2.0;
      if (this.getType() == Type.ELECTRIC && def == Type.WATER)    return 2.0;
  
      if (this.getType() == Type.FIRE     && def == Type.WATER)    return 0.5;
      if (this.getType() == Type.WATER    && def == Type.GRASS)    return 0.5;
      if (this.getType() == Type.GRASS    && def == Type.FIRE)     return 0.5;
      if (this.getType() == Type.ELECTRIC && def == Type.GRASS)    return 0.5;
  
      return 1.0; // netral
  }

  // ===== Util format multiplier =====
  protected static String fmt(double d) {
    return (Math.abs(d - Math.round(d)) < 1e-9)
        ? String.valueOf((int) Math.round(d))
        : String.format("%.1f", d);
  }

  /**
   * Menampilkan deskripsi Pokenimons.
   *
   * TODO: Cetak deskripsi singkat berisi nama kelas konkret, nama, tipe, level, dan HP.
   * Format: "<Nama_kelas_konkret> @<nama> (<tipe>) L<level> HP=<hp>"
   * 
   * For your exploration: Manfaatkan instanceof untuk mendapatkan nama kelas konkret, serta coba cari tahu tentang method getClass().getSimpleName() jika bukan merupakan subclass manapun dari Pokenimons.
   */
  public final void printDescription() {
     
  }
}
