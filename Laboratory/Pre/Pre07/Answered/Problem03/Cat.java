public class Cat extends Mammal {
    private boolean isIndoor;
    
    public Cat(String name, int age, String furColor, boolean isIndoor) {
        super(name, age, furColor);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
}