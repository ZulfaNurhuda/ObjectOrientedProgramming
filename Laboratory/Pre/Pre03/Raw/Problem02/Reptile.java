public class Reptile extends Animal {
    public enum ScaleType {
        SMOOTH,
        ROUGH,
        KEELED,
        GRANULAR
    }

    private final ScaleType scaleType;

    /**
     * Konstruktor untuk kelas Reptile.
     * 
     * @param name
     * @param species
     * @param habitat
     * @param sound
     * @param scaleType jika null maka di-set ke ScaleType.SMOOTH
     */
    public Reptile(String name, String species, String habitat, String sound, ScaleType scaleType) {
        // TODO: lengkapi method ini
    }

    public ScaleType getScaleType() {
        // TODO: lengkapi method ini
    }

    /**
     * Mengembalikan sound hewan.
     * 
     * Hint: Panggil method sound() dari superclass (Animal)
     */
    @Override
    public String sound() {
        // TODO: lengkapi method ini
    }
}
