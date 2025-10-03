public abstract class Animal implements IAnimal {

    private String name;
    private String species;
    private String habitat;
    protected String sound;

    enum AnimalType {
        MAMMAL,
        AVES,
        REPTILE
    }

    private AnimalType animalType;

    /**
     * Fungsi untuk membersihkan input teks.
     * 
     * Jika teks null atau hanya berisi spasi, kembalikan nilai fallback.
     * 
     * @param text
     * @param fallback
     * @return
     */
    private static String sanitizeText(String text, String fallback) {
        if (text == null) {
            return fallback;
        }
        String trimmed = text.trim();
        return trimmed.isEmpty() ? fallback : trimmed;
    }

    /**
     * Konstruktor untuk kelas Animal.
     * 
     * @param name
     * @param species
     * @param habitat
     * @param animalType
     */
    protected Animal(String name, String species, String habitat, String sound, AnimalType animalType) {
        // TODO: lengkapi constructor ini
        this.name = sanitizeText(name, "Unknown Name");
        this.species = sanitizeText(species, "Unknown Species");
        this.habitat = sanitizeText(habitat, "Unknown Habitat");
        this.sound = sanitizeText(sound, "...");
        this.animalType = animalType;
    }

    /**
     * Getter untuk nama hewan.
     * 
     * @return nama hewan
     */
    public String getName() {
        // TODO: lengkapi method ini
        return name;
    }

    /**
     * Getter untuk spesies hewan.
     * 
     * @return spesies hewan
     */
    public String getSpecies() {
        // TODO: lengkapi method ini
        return species;
    }

    /**
     * Getter untuk habitat hewan.
     * 
     * @return habitat hewan
     */
    public String getHabitat() {
        // TODO: lengkapi method ini
        return habitat;
    }

    /**
     * Getter untuk jenis hewan.
     * 
     * @return jenis hewan
     */
    public AnimalType getAnimalType() {
        // TODO: lengkapi method ini
        return animalType;
    }

    /**
     * Mengembalikan representasi string dari objek Animal.
     * 
     * @return representasi string dari objek Animal
     */
    @Override
    public String toString() {
        return "Animal Info:\n" +
                "--------------------\n" +
                "Name: " + name + "\n" +
                "Species: " + species + "\n" +
                "Habitat: " + habitat + "\n" +
                "--------------------";
    }

    /**
     * Metode untuk suara hewan.
     * 
     * @return suara hewan
     */
    public String sound() {
        // TODO: lengkapi method ini
        return sound;
    }
}
