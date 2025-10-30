public class FeedingSchedule<T extends Animal> {
    private T animal;
    private int feedingTimes;
    
    // TODO: Buat constructor yang menerima animal (tipe T) dan feedingTimes
    // Set kedua atribut dengan parameter yang diterima
    public FeedingSchedule(T animal, int feedingTimes) {
        this.animal = animal;
        this.feedingTimes = feedingTimes;
    }
    
    // TODO: Buat method showSchedule()
    // Tampilkan: "<animal.getName()> diberi makan <feedingTimes> kali per hari"
    public void showSchedule() {
        System.out.println(animal.getName() + " diberi makan " + feedingTimes + " kali per hari");
    }
    
    // TODO: Buat method increaseFeedingTimes()
    // Tambahkan 1 ke feedingTimes
    // Tampilkan: "Jadwal makan <animal.getName()> ditambah menjadi <feedingTimes> kali per hari"
    public void increaseFeedingTimes() {
        feedingTimes++;
        System.out.println("Jadwal makan " + animal.getName() + " ditambah menjadi " + feedingTimes + " kali per hari");
    }
    
    // TODO: Buat getter untuk animal dan feedingTimes
    public T getAnimal() {
        return animal;
    }
    
    public int getFeedingTimes() {
        return feedingTimes;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void setFeedingTimes(int feedingTimes) {
        this.feedingTimes = feedingTimes;
    }
}