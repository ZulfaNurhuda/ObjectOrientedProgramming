public abstract class Bird extends Animal {
    private double wingSpan;
    
    public Bird(String name, int age, double wingSpan) {
        super(name, age);
        this.wingSpan = wingSpan;
    }
    
    public double getWingSpan() {
        return wingSpan;
    }
}