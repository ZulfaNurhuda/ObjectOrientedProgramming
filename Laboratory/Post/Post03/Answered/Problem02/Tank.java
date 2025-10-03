public class Tank extends Hero {
    // TODO: Buat atribut: armor, shield
    private int armor;
    private int shield;

    // TODO: Buat constructor yang menerima name, hp, attackPower, armor, shield
    // Gunakan super() untuk panggil constructor parent dengan role "Tank"
    public Tank(String name, int hp, int attackPower, int armor, int shield) {
        super(name, hp, attackPower, "Tank");
        this.armor = armor;
        this.shield = shield;
    }

    // TODO: Override method specialSkill()
    // Tank menggunakan "Shield Wall", tampilkan format:
    // "<name> activates Shield Wall! Shield: <shield>"
    // Contoh: "Tigreal activates Shield Wall! Shield: 100"
    @Override
    public void specialSkill() {
        System.out.printf("%s activates Shield Wall! Shield: %d\n", super.getName(), shield);
    }

    // TODO: Buat method levelUp() yang override parent
    // Panggil super.levelUp() dulu, lalu tambah armor +5, shield +30, hp bonus +30
    // Tampilkan pesan bonus: "Bonus Tank: +5 armor, +30 shield, +30 bonus HP!"
    @Override
    public void levelUp() {
        super.levelUp();
        armor += 5;
        shield += 30;
        super.setHp(super.getHp() + 30);
        System.out.println("Bonus Tank: +5 armor, +30 shield, +30 bonus HP!");
    }

    // TODO: Buat method taunt() untuk menarik perhatian musuh
    // Format: "<name> berteriak dan menarik perhatian semua musuh! Armor: <armor>"
    // Contoh: "Tigreal berteriak dan menarik perhatian semua musuh! Armor: 25"
    public void taunt() {
        System.out.printf("%s berteriak dan menarik perhatian semua musuh! Armor: %d\n", super.getName(), armor);
    }

    // TODO: Buat method takeDamage(int damage)
    // Armor mengurangi damage terlebih dahulu, lalu shield menyerap sisa damage
    // Format: "<name> menerima <effectiveDamage> damage! HP: <hp>, Shield:
    // <shield>"
    // Contoh: "Tigreal menerima 35 damage! HP: 415, Shield: 55"

    public void takeDamage(int damageAmount) {
        int remainingDamage = Math.max(0, damageAmount - armor);
        if (shield >= remainingDamage) {
            shield -= remainingDamage;
        } else {
            int damageToHp = remainingDamage - shield;
            shield = 0;
            super.setHp(Math.max(0, super.getHp() - damageToHp));
        }
        System.out.printf("%s menerima %d damage! HP: %d, Shield: %d\n", super.getName(), remainingDamage,
                super.getHp(), shield);
    }

    // TODO: Buat getter dan setter untuk armor dan shield
    public int getArmor() {
        return armor;
    }

    public void setArmor(int newArmor) {
        armor = newArmor;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int newShield) {
        shield = newShield;
    }
}