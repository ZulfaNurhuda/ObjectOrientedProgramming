
public abstract class Hero {
    // TODO: Buat atribut berikut String name,int  level,int  hp,int  attackPower, String role
    private String name;
    private int level;
    private int hp;
    private int attackPower;
    private String role;

    // TODO: Buat constructor yang menerima name, hp, attackPower, role
    // Level default = 1
    public Hero(String name, int hp, int attackPower, String role) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.role = role;
        level = 1;
    }

    // TODO: Buat method displayInfo() yang menampilkan info hero
    // Gunakan format "<role> <name> - Level: <level>, HP: <hp>, Attack: <attackPower>"
    // Contoh: "Mage Kagura - Level: 1, HP: 300, Attack: 80"
    public void displayInfo() {
        System.out.printf("%s %s - Level: %d, HP: %d, Attack: %d\n", role, name, level, hp, attackPower);
    }

    // TODO: Buat method attack() dasar
    // Tampilkan pesan "<name> melakukan serangan dasar dengan damage <attackPower>!"
    // Contoh: "Kagura melakukan serangan dasar dengan damage 80!"
    public void attack() {
        System.out.printf("%s melakukan serangan dasar dengan damage %d!\n", name, attackPower);
    }

    // TODO: Buat method levelUp() yang menaikkan level dan stats dasar
    // Naikkan level, Naikkan hp sebanyak 50, naikkan attackPower sebanyak 10, tampilkan pesan level up
    // Format: "<name> naik ke level <level>!"
    // Contoh: "Kagura naik ke level 2!"
    public void levelUp() {
        level++;
        hp += 50;
        attackPower += 10;
        System.out.printf("%s naik ke level %d!\n", name, level);
    }

    // TODO: Implementasikan method abstract berikut di subclass
    public abstract void specialSkill();

    // TODO: Buat getter dan setter untuk semua atribut
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int newLevel) {
        level = newLevel;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int newHp) {
        hp = newHp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int newAttackPower) {
        attackPower = newAttackPower;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String newRole) {
        role = newRole;
    }
}