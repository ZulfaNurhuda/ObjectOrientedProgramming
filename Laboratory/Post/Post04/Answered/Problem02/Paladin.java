public class Paladin implements PhysicalAttack, MagicalAttack, StrengthComparable {
    // TODO: Buat atribut private String name, int physicalPower, int magicalPower
    private String name;
    private int physicalPower;
    private int magicalPower;
    
    // TODO: Buat constructor yang menerima name, physicalPower, dan magicalPower
    // Set semua atribut dengan parameter yang diterima
    public Paladin(String name, int physicalPower, int magicalPower) {
        this.name = name;
        this.physicalPower = physicalPower;
        this.magicalPower = magicalPower;
    }
    
    // TODO: Override method performAttack()
    // Tampilkan: "<name> menyerang dengan pedang dan sihir sekaligus! memberikan <physicalPower> damage fisik dan <magicalPower> damage sihir!"
    @Override
    public void performAttack() {
        System.out.printf("%s menyerang dengan pedang dan sihir sekaligus! memberikan %d damage fisik dan %d damage sihir!\n", name, physicalPower, magicalPower);
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

    // TODO: Override method getMagicalPower()
    // Buat getter untuk magicalPower
    @Override
    public int getMagicalPower() {
        return magicalPower;
    }

    // TODO: Override method setMagicalPower(int power)
    // Buat setter untuk magicalPower
    @Override
    public void setMagicalPower(int power) {
        magicalPower = power;
    }

    // TODO: Override method showAttackInfo()
    // Tampilkan: "<name> adalah Paladin, ahli dalam serangan fisik dan sihir!"
    @Override
    public void showAttackInfo() {
        System.out.printf("%s adalah Paladin, ahli dalam serangan fisik dan sihir!\n", name);
    }
    
    // TODO: Override method compareStrength(StrengthComparable other)
    // Jika other adalah instance dari Paladin:
    //   - Cast other menjadi Paladin
    //   - total power = physicalPower + magicalPower 
    //   - Bandingkan total power:
    //     - Jika this.totalPower < other.totalPower, return -1
    //     - Jika this.totalPower == other.totalPower, return 0
    //     - Jika this.totalPower > other.totalPower, return 1
    // Jika other bukan instance dari Paladin, return -2
    @Override
    public int compareStrength(StrengthComparable other) {
        int compareResult;
        if (other instanceof Paladin) {
            Paladin otherPaladin = (Paladin) other;
            int selfTotalPower = physicalPower + magicalPower;
            int otherTotalPower = otherPaladin.getPhysicalPower() + otherPaladin.getMagicalPower();
            if (selfTotalPower < otherTotalPower) {
                compareResult = -1;
            } else if (selfTotalPower > otherTotalPower) {
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