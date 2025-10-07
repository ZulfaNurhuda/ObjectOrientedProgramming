/**
 * Pokenimons.java
 * Abstraksi dasar untuk semua makhluk Pokenimons.
 */
public abstract class Pokenimons {
    // TODO: Definisikan field sesuai kebutuhan (nama, hp, level, type). Level awal
    // adalah 1. Buatlah atribut name dan type menjadi tidak boleh diubah-ubah.
    private final String name;
    private final Type type;
    private int hp;
    private int level;

    /**
     * Konstruktor dasar Pokenimons.
     *
     * TODO: Inisialisasi field dan lakukan batas bawah HP minimal 1.
     * 
     * @param name nama makhluk
     * @param hp   HP awal (batas bawah minimal 1)
     * @param type tipe unsur
     */
    public Pokenimons(String name, int hp, Type type) {
        // TODO: Isi inisialisasi properti dasar
        this.name = name;
        this.type = type;
        this.hp = Math.max(1, hp);
        level = 1;
    }

    // ===== Akses dasar =====
    // TODO: Buatlah getter untuk nama, HP, level, dan tipe.
    /**
     * Getter untuk nama Pokenimons
     * 
     * @return nama Pokenimons
     */
    public String getName() {
        return name;
    }

    /**
     * Getter untuk HP Pokenimons
     * 
     * @return HP Pokenimons
     */
    public int getHp() {
        return hp;
    }

    /**
     * Getter untuk level Pokenimons
     * 
     * @return level Pokenimons
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter untuk tipe Pokenimons
     * 
     * @return tipe Pokenimons
     */
    public Type getType() {
        return type;
    }

    /**
     * TODO: Implementasikan sesuai definisi fainted.
     * 
     * @return true jika HP <= 0.
     */
    public boolean isFainted() {
        return (hp <= 0);
    }

    /**
     * Setter untuk HP Pokenimons
     * 
     * @param hp HP Pokenimons
     */
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    /**
     * Setter untuk level Pokenimons
     * 
     * @param level level Pokenimons
     */
    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    /**
     * Menerapkan damage ke Pokenimons ini.
     *
     * Aturan yang diharapkan:
     * - Damage negatif dianggap 0.
     * - HP tidak boleh menjadi negatif (batas bawah 0).
     * - Kurangi HP dengan damage yang diterima.
     * - Cetak log berbentuk: "<nama_pokenimons> took <jumlah_damage> dmg (HP:
     * <hp_setelah>)".
     *
     * TODO: Implementasikan sesuai aturan di atas.
     * 
     * @param dmg besaran damage mentah
     */
    public void takeDamage(int dmg) {
        dmg = Math.max(0, dmg);
        hp = Math.max(0, hp - dmg);
        System.out.println(name + " took " + dmg + " dmg (HP: " + hp + ")");
    }

    /**
     * Level up sederhana.
     *
     * Aturan yang diharapkan: level +1, HP +5, dan cetak log naik level
     * "<nama_pokenimons> leveled up to <level_baru>!".
     *
     * TODO: Implementasikan sesuai aturan.
     */
    public void levelUp() {
        level++;
        hp += 5;
        System.out.println(name + " leveled up to " + level + "!");
    }

    /**
     * Perilaku evolusi default: tidak berevolusi.
     * Subclass yang bisa berevolusi dapat override dan mengembalikan objek bentuk
     * baru.
     *
     * TODO: Cetak log yang sesuai bila tidak bisa berevolusi
     * "<nama_pokenimons> cannot evolve.".
     * 
     * @return objek ini (default)
     */
    public Pokenimons evolve() {
        System.out.println(name + " cannot evolve.");
        return this;
    }

    /**
     * Serangan fisik generik.
     *
     * Petunjuk:
     * - Bila penyerang fainted, cetak log "<nama_pokenimons> has fainted and cannot
     * act." dan batalkan.
     * - Bila target fainted, cetak log "<nama_pokenimons> has fainted and cannot be
     * attacked." dan batalkan.
     * - Tentukan penanda [RANGED] atau [MELEE] berdasarkan Pokenimons menyerang
     * jarak jauh atau dekat.
     * - Gunakan damage dasar 10 dan kalikan dengan multiplier berdasarkan tipe
     * penyerang terhadap target. Jangan lupa untuk casting ke int.
     * - Cetak log aksi "[<RANGED/MELEE>] <nama_pokenimons> uses Tackle on
     * <nama_target> (x<mult>)" lalu terapkan damage. Gunakan method fmt(double)
     * untuk memformat multiplier.
     *
     * TODO: Implementasikan seluruh langkah di atas.
     */
    public final void attack(Pokenimons target) {
        if (isFainted()) {
            System.out.println(name + " has fainted and cannot act.");
        } else if (target.isFainted()) {
            System.out.println(target.getName() + " has fainted and cannot be attacked.");
        } else {
            String rangeType = (this instanceof RangedAttacker) ? "[RANGED]" : "[MELEE]";
            double mult = typeMultiplierAgainst(target.getType());
            int damage = (int) Math.round(10 * mult);
            System.out.println(rangeType + " " + name + " uses Tackle on " + target.getName() + " (x" + fmt(mult) + ")");
            target.takeDamage(damage);
        }
    }

    /**
     * Template method untuk mengeksekusi skill unik tiap subclass.
     *
     * Petunjuk:
     * - Bila penyerang fainted, cetak log "<nama_pokenimons> has fainted and cannot
     * act." dan batalkan.
     * - Bila target fainted, cetak log "<nama_pokenimons> has fainted and cannot be
     * attacked." dan batalkan.
     * - Ambil nama skill dari hook skillName() dan base damage dari
     * skillBaseDamage().
     * - Kalikan base damage dengan multiplier tipe terhadap target. Jangan lupa
     * untuk casting ke int.
     * - Cetak log aksi "<nama_pokenimons> uses <nama_skill> on <nama_target>
     * (x<mult>)" lalu terapkan damage. Gunakan method fmt(double) untuk memformat
     * multiplier.
     *
     * TODO: Implementasikan sesuai petunjuk di atas.
     */
    public final void useSkill(Pokenimons target) {
        if (isFainted()) {
            System.out.println(name + " has fainted and cannot act.");
        } else if (target.isFainted()) {
            System.out.println(target.getName() + " has fainted and cannot be attacked.");
        } else {
            double mult = typeMultiplierAgainst(target.getType());
            int damage = (int) Math.round(skillBaseDamage() * mult);
            System.out.println(name + " uses " + skillName() + " on " + target.getName() + " (x" + fmt(mult) + ")");
            target.takeDamage(damage);
        }
    }

    // ===== Hooks untuk subclass =====
    protected abstract String skillName();
    protected abstract int skillBaseDamage();

    // ===== Efektivitas tipe =====
    /**
     * Menghitung multiplier efektivitas berdasarkan tipe penyerang (this.type) vs
     * tipe target.
     */
    protected double typeMultiplierAgainst(Type def) {
        if (this.getType() == Type.FIRE && def == Type.GRASS)
            return 2.0;
        if (this.getType() == Type.WATER && def == Type.FIRE)
            return 2.0;
        if (this.getType() == Type.GRASS && def == Type.WATER)
            return 2.0;
        if (this.getType() == Type.ELECTRIC && def == Type.WATER)
            return 2.0;

        if (this.getType() == Type.FIRE && def == Type.WATER)
            return 0.5;
        if (this.getType() == Type.WATER && def == Type.GRASS)
            return 0.5;
        if (this.getType() == Type.GRASS && def == Type.FIRE)
            return 0.5;
        if (this.getType() == Type.ELECTRIC && def == Type.GRASS)
            return 0.5;

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
     * TODO: Cetak deskripsi singkat berisi nama kelas konkret, nama, tipe, level,
     * dan HP.
     * Format: "<Nama_kelas_konkret> @<nama> (<tipe>) L<level> HP=<hp>"
     * 
     * For your exploration: Manfaatkan instanceof untuk mendapatkan nama kelas
     * konkret, serta coba cari tahu tentang method getClass().getSimpleName() jika
     * bukan merupakan subclass manapun dari Pokenimons.
     */
    public final void printDescription() {
        System.out.println(this.getClass().getSimpleName() + " @" + name + " (" + type + ") L" + level + " HP=" + hp);
    }
}
