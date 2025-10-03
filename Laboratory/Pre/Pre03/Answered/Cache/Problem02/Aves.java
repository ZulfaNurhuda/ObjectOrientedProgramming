public class Aves extends Animal {
    private boolean canFly;

    /**
     * Konstruktor untuk kelas Aves.
     * 
     * @param name
     * @param species
     * @param habitat
     * @param sound
     * @param canFly
     */
    public Aves(String name, String species, String habitat, String sound, boolean canFly) {
        // TODO: lengkapi method ini
        super(name, species, habitat, sound, AnimalType.AVES);
        this.canFly = canFly;
    }

    /**
     * Getter untuk kemampuan terbang.
     * 
     * @return true jika dapat terbang, false jika tidak
     */
    public boolean canFly() {
        // TODO: lengkapi method ini
        return this.canFly;
    }

    /**
     * Mengembalikan sound hewan.
     * 
     * Hint: Panggil method sound() dari superclass (Animal)
     */
    @Override
    public String sound() {
        // TODO: lengkapi method ini
        return super.sound();
    }
}
