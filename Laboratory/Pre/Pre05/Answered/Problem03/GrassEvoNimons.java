/**
 * GrassEvoNimons.java
 * Bentuk evolusi dari Pokenimons tipe grass.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar menjadi turunan dari bentuk grass
 * sebelumnya.
 */
public class GrassEvoNimons extends GrassNimons {
    /**
     * Menciptakan bentuk evolusi tipe grass.
     *
     * @param name nama Pokenimons
     * @param hp   HP awal
     *
     *             TODO: Panggil konstruktor induk yang sesuai.
     */
    public GrassEvoNimons(String name, int hp) {
        super(name, hp);
    }

    /**
     * Nama skill khusus bentuk evolusi grass.
     *
     * TODO: Kembalikan nama skill untuk bentuk evolusi grass, yaitu "Solar Beam".
     * 
     * @return nama skill
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected String skillName() {
        return "Solar Beam";
    }

    /**
     * Base damage untuk skill bentuk evolusi grass.
     *
     * TODO: Kembalikan base damage skill bentuk evolusi grass, yaitu 20.
     * 
     * @return nilai damage dasar
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    @Override
    protected int skillBaseDamage() {
        return 20;
    }
}
