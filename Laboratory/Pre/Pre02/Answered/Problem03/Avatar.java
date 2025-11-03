class Avatar {
    // TODO: Deklarasi atribut: namaSkin (String), level (int)
    public String namaSkin;
    public int level;

    // TODO: Constructor set namaSkin dan level
    Avatar(String namaSkin, int level) {
        // HINT: this.namaSkin = namaSkin; dst.
        this.namaSkin = namaSkin;
        this.level = level;
    }

    // TODO: Naikkan level (level++) dan cetak:
    // "Skin <namaSkin> naik ke level <level>."
    public void upgradeLevel() {
        // HINT: Urutan: tingkatkan level, lalu cetak
        this.level++;
        System.out.printf("Skin %s naik ke level %d.\n", this.namaSkin, this.level);
    }
}