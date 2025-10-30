import java.util.ArrayList;
import java.util.List;

public class ZooManagementSystem {
    public static void main(String[] args) {

        Dog buddy = new Dog("Buddy", 3, "Brown", "Golden Retriever");
        Enclosure<Dog> dogEnclosure = new Enclosure<>("D001", buddy);
        dogEnclosure.showEnclosureInfo();
        
        Cat whiskers = new Cat("Whiskers", 2, "White", true);
        FeedingSchedule<Cat> catSchedule = new FeedingSchedule<>(whiskers, 3);
        catSchedule.showSchedule();
        catSchedule.increaseFeedingTimes();
        
        Parrot polly = new Parrot("Polly", 5, 0.8, true);
        List<Animal> animalList = new ArrayList<>();
        animalList.add(buddy);
        animalList.add(whiskers);
        animalList.add(polly);
        ZooManager.printAllAnimals(animalList);
        
        List<Mammal> mammalList = new ArrayList<>();
        ZooManager.addMammals(mammalList, whiskers);
        ZooManager.addMammals(mammalList, buddy);
        
        int count = ZooManager.countAnimals(animalList);
        System.out.println("Total hewan di kebun binatang: " + count);
        
        Enclosure<Animal> generalEnclosure = new Enclosure<>("G001", null);
        ZooManager.transferAnimal(dogEnclosure, generalEnclosure);
        
        ZooManager.showGenericInfo(generalEnclosure);
    }
}
