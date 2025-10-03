public class Warrior implements PhysicalAttack, StrengthComparable {
    // TODO: Buat atribut private String name, int physicalPower
    private String name;
    private int physicalPower;
    
    // TODO: Buat constructor yang menerima name dan physicalPower
    // Set kedua atribut dengan parameter yang diterima
    public Warrior(String name, int physicalPower) {
        this.name = name;
        this.physicalPower = physicalPower;
    }

    // TODO: Override method performAttack()
    // Tampilkan: "<name> mengayunkan pedang dengan kuat! memberikan <physicalPower> damage fisik!"
    @Override
    public void performAttack() {
        System.out.printf("%s mengayunkan pedang dengan kuat! memberikan %d damage fisik!\n", name, physicalPower);
    }

    // TODO: Override method getPhysicalPower()
    // Buat getter untuk physicalPower
    @Override
    public int getPhysicalPower() {
        return physicalPower;
    }
    
    // TODO: Override method setPhysicalPower(int power)
    // Buat setter untuk physicalPower
    @Override
    public void setPhysicalPower(int power) {
        physicalPower = power;
    }

    // TODO: Override method compareStrength(StrengthComparable other)
    // Jika other adalah instance dari Warrior:
    //   - Bandingkan physicalPower:
    //     - Jika this.physicalPower < other.physicalPower, return -1
    //     - Jika this.physicalPower == other.physicalPower, return 0
    //     - Jika this.physicalPower > other.physicalPower, return 1
    // Jika other bukan instance dari Warrior, return -2
    @Override
    public int compareStrength(StrengthComparable other) {
        int compareResult;
        if (other instanceof Warrior) {
            Warrior otherWarrior = (Warrior) other;
            if (physicalPower < otherWarrior.getPhysicalPower()) {
                compareResult = -1;
            } else if (physicalPower > otherWarrior.getPhysicalPower()) {
                compareResult = 1;
            } else {
                compareResult = 0;
            }
        } else {
            compareResult = -2;
        }
        return compareResult;
    }
}