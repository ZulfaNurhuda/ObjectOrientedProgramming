public class Parrot extends Bird {
    private boolean canTalk;
    
    public Parrot(String name, int age, double wingSpan, boolean canTalk) {
        super(name, age, wingSpan);
        this.canTalk = canTalk;
    }
    
    @Override
    public String makeSound() {
        return "Squawk! Squawk!";
    }
    
    public boolean canTalk() {
        return canTalk;
    }
}