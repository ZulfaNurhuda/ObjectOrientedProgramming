public class Assassin extends Hero {
    // TODO: Buat atribut int energy, boolean isStealthed
    private int energy;
    private boolean isStealthed;

    // TODO: Buat constructor yang menerima name, hp, attackPower, energy
    // Gunakan pula constructor parent dengan role "Assassin"
    // isStealthed default false
    public Assassin(String name, int hp, int attackPower, int energy) {
        super(name, hp, attackPower, "Assassin");
        this.energy= energy;
        isStealthed = false;
    }

    // TODO: Override method attack()
    // Jika stealth, damage = attackPower * 1.5, stealth hilang setelah attack
    // Tampilkan pesan dengan format "<name> menyerang dari bayangan dengan damage <damage>!"
    // Contoh "Hayabusa menyerang dari bayangan dengan damage 187!"
    // Jika tidak stealth: gunakan method attack parent
    @Override
    public void attack() {
        if (isStealthed) {
            int damage = (int) ((double) super.getAttackPower() * 1.5);
            setIsStealthed(false);
            System.out.printf("%s menyerang dari bayangan dengan damage %d!\n", super.getName(), damage);
        } else {
            super.attack();
        }
    }

    // TODO: Override method specialSkill()
    // Jika energy cukup (>= 20), aktifkan stealth dan kurangi energy 20, Tampilkan pesan dengan format
    // "<name> menghilang dalam bayangan! Serangan berikutnya akan lebih kuat!"
    // Contoh : "Hayabusa menghilang dalam bayangan! Serangan berikutnya akan lebih kuat!"
    // Jika tidak cukup, tampilkan pesan tidak cukup energy
    // "<name> tidak memiliki cukup energy untuk Shadow Clone!"
    // Contoh : "Hayabusa tidak memiliki cukup energy untuk Shadow Clone!"
    @Override
    public void specialSkill() {
        if (energy >= 20) {
            setIsStealthed(true);
            energy -= 20;
            System.out.printf("%s menghilang dalam bayangan! Serangan berikutnya akan lebih kuat!\n", super.getName());
        } else {
            System.out.printf("%s tidak memiliki cukup energy untuk Shadow Clone!\n", super.getName());
        }
    }

    // TODO: Buat method levelUp() yang override parent
    // Panggil super.levelUp() dulu, tampilkan pesan bonus (tanpa menambah stat tambahan)
    // Tampilkan pesan bonus: "Bonus Assassin: +0.05 critical chance, +5 attack power!"
    @Override
    public void levelUp() {
        super.levelUp();
        System.out.println("Bonus Assassin: +0.05 critical chance, +5 attack power!");
    }

    // TODO: Buat method backstab() untuk serangan khusus
    // Hanya bisa digunakan jika stealth, damage = attackPower * 2.5, habiskan stealth
    // Jika stealth: "<name> melakukan backstab dengan damage <damage>!"
    // Contoh: "Hayabusa melakukan backstab dengan damage 312!"
    // Jika tidak stealth: "<name> harus stealth terlebih dahulu untuk backstab!"
    public void backstab() {
        if (isStealthed) {
            int damage = (int) (super.getAttackPower() * 2.5);
            setIsStealthed(false);
            System.out.printf("%s melakukan backstab dengan damage %d!\n", super.getName(), damage);
        } else {
            System.out.printf("%s harus stealth terlebih dahulu untuk backstab!\n", super.getName());
        }
    }

    // TODO: Buat getter dan setter untuk energy dan isStealthed
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int newEnergy) {
        energy = newEnergy;
    }

    public boolean getIsStealthed() {
        return isStealthed;
    }

    public void setIsStealthed(boolean newIsStealthed) {
        isStealthed = newIsStealthed;
    }
}