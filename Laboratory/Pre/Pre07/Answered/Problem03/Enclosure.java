public class Enclosure<T extends Animal> {
    private T animal;
    private String enclosureId;
    
    // TODO: Buat constructor yang menerima enclosureId dan animal (tipe T)
    // Set kedua atribut dengan parameter yang diterima
    public Enclosure(String enclosureId, T animal) {
        this.enclosureId = enclosureId;
        this.animal = animal;
    }
    
    // TODO: Buat method getAnimal() yang mengembalikan T
    // Return nilai animal
    public T getAnimal() {
        return animal;
    }
    
    // TODO: Buat method setAnimal(T animal)
    // Set atribut animal dengan parameter yang diterima
    public void setAnimal(T animal) {
        this.animal = animal;
    }
    
    // TODO: Buat method showEnclosureInfo()
    // Tampilkan: "Kandang <enclosureId>: <animal.getInfo()>"
    // Tampilkan: "Suara: <animal.makeSound()>"
    public void showEnclosureInfo() {
        System.out.println("Kandang " + enclosureId + ": " + animal.getInfo());
        System.out.println("Suara: " + animal.makeSound());
    }
    
    // TODO: Buat getter untuk enclosureId
    public String getEnclosureId() {
        return enclosureId;
    }

    public void setEnclosureId(String enclosureId) {
        this.enclosureId = enclosureId;
    }
}