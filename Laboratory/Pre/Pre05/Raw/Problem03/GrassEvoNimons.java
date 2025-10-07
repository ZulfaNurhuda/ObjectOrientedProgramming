/**
 * GrassEvoNimons.java
 * Bentuk evolusi dari Pokenimons tipe grass.
 *
 * TODO:
 * - Lengkapi deklarasi kelas ini agar menjadi turunan dari bentuk grass sebelumnya.
 */
public class GrassEvoNimons {
    /**
     * Menciptakan bentuk evolusi tipe grass.
     *
     * @param name nama Pokenimons
     * @param hp   HP awal
     *
     * TODO: Panggil konstruktor induk yang sesuai.
     */
    public GrassEvoNimons(String name, int hp) { 
        
    }
  
    /**
     * Nama skill khusus bentuk evolusi grass.
     *
     * @return nama skill
     *
     * TODO: Kembalikan nama skill untuk bentuk evolusi grass, yaitu "Solar Beam".
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    protected String skillName() {
        return "TODO";
    }

    /**
     * Base damage untuk skill bentuk evolusi grass.
     *
     * @return nilai damage dasar
     *
     * TODO: Kembalikan base damage skill bentuk evolusi grass, yaitu 20.
     */
    // TODO: Aktifkan anotasi @Override setelah kelas mewarisi induk yang tepat.
    protected int    skillBaseDamage() { return 0; }
}
  