import java.io.*;
import java.util.*;

/**
 * FORMAT INPUT:
 * <Number of operations>
 * <Operation 1>
 * <Operation 2>
 * ...
 * <Operation n>
 * 
 */

/**
 * Contoh operasi:
 * CREATE <type> <name> <hp> <attack> <param1> [param2]
 * CREATE MAGE Kagura 300 80 150 50
 * CREATE TANK Tigreal 500 60 20 100
 * CREATE ASSASSIN Hayabusa 250 120 100
 */
public class MobileLegends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Baca jumlah test case atau operasi
            int n = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Array untuk menyimpan hero-hero
            ArrayList<Hero> heroes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String command = scanner.nextLine().trim();
                String[] parts = command.split(" ");

                /** List operasi yang didukung */

                switch (parts[0].toUpperCase()) {
                    /**
                     * CREATE <type> <name> <hp> <attack> <param1> [param2]
                     * CREATE MAGE Kagura 300 80 150 50
                     */
                    case "CREATE":
                        createHero(parts, heroes);
                        break;
                    /**
                     * DISPLAY <name>
                     */
                    case "DISPLAY":
                        displayHero(parts, heroes);
                        break;
                    /**
                     * ATTACK <name>
                     */
                    case "ATTACK":
                        attackHero(parts, heroes);
                        break;
                    /**
                     * SKILL <name>
                     */
                    case "SKILL":
                        useSkill(parts, heroes);
                        break;
                    /**
                     * LEVELUP <name>
                     */
                    case "LEVELUP":
                        levelUpHero(parts, heroes);
                        break;
                    /**
                     * SPECIAL <name> <ability>
                     */
                    case "SPECIAL":

                        useSpecialAbility(parts, heroes);
                        break;
                    /**
                     * DAMAGE <name> <damage_amount>
                     */
                    case "DAMAGE":
                        takeDamageHero(parts, heroes);
                        break;
                    /**
                     * LIST - display all heroes
                     */
                    case "LIST":
                        listAllHeroes(heroes);
                        break;
                    default:
                        System.out.println("Invalid command: " + parts[0]);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // CREATE <type> <name> <hp> <attack> <param1> [param2]
    // CREATE MAGE Kagura 300 80 150 50
    // CREATE TANK Tigreal 500 60 20 100
    // CREATE ASSASSIN Hayabusa 250 120 100
    private static void createHero(String[] parts, ArrayList<Hero> heroes) {
        try {
            String type = parts[1].toUpperCase();
            String name = parts[2];
            int hp = Integer.parseInt(parts[3]);
            int attack = Integer.parseInt(parts[4]);

            Hero hero = null;

            switch (type) {
                case "MAGE":
                    int mana = Integer.parseInt(parts[5]);
                    int spellPower = Integer.parseInt(parts[6]);
                    hero = new Mage(name, hp, attack, mana, spellPower);
                    break;
                case "TANK":
                    int armor = Integer.parseInt(parts[5]);
                    int shield = Integer.parseInt(parts[6]);
                    hero = new Tank(name, hp, attack, armor, shield);
                    break;
                case "ASSASSIN":
                    int energy = Integer.parseInt(parts[5]);
                    hero = new Assassin(name, hp, attack, energy);
                    break;
                default:
                    System.out.println("Unknown hero type: " + type);
                    return;
            }

            heroes.add(hero);
            System.out.println("Created " + type.toLowerCase() + " " + name);

        } catch (Exception e) {
            System.out.println("Error creating hero: " + e.getMessage());
        }
    }

    // DISPLAY <name>
    private static void displayHero(String[] parts, ArrayList<Hero> heroes) {
        String name = parts[1];
        Hero hero = findHero(name, heroes);
        if (hero != null) {
            hero.displayInfo();
        } else {
            System.out.println("Hero " + name + " not found");
        }
    }

    // ATTACK <name>
    private static void attackHero(String[] parts, ArrayList<Hero> heroes) {
        String name = parts[1];
        Hero hero = findHero(name, heroes);
        if (hero != null) {
            hero.attack();
        } else {
            System.out.println("Hero " + name + " not found");
        }
    }

    // SKILL <name>
    private static void useSkill(String[] parts, ArrayList<Hero> heroes) {
        String name = parts[1];
        Hero hero = findHero(name, heroes);
        if (hero != null) {
            hero.specialSkill();
        } else {
            System.out.println("Hero " + name + " not found");
        }
    }

    // LEVELUP <name>
    private static void levelUpHero(String[] parts, ArrayList<Hero> heroes) {
        String name = parts[1];
        Hero hero = findHero(name, heroes);
        if (hero != null) {
            hero.levelUp();
        } else {
            System.out.println("Hero " + name + " not found");
        }
    }

    // SPECIAL <name> <ability>
    // SPECIAL Kagura MEDITATION
    // SPECIAL Tigreal TAUNT
    // SPECIAL Hayabusa BACKSTAB
    private static void useSpecialAbility(String[] parts, ArrayList<Hero> heroes) {
        String name = parts[1];
        String ability = parts[2].toUpperCase();
        Hero hero = findHero(name, heroes);

        if (hero == null) {
            System.out.println("Hero " + name + " not found");
            return;
        }

        try {
            switch (hero.getRole().toUpperCase()) {
                case "MAGE":
                    Mage mage = (Mage) hero;
                    if (ability.equals("MEDITATION")) {
                        mage.meditation();
                    } else {
                        System.out.println("Unknown ability for Mage: " + ability);
                    }
                    break;
                case "TANK":
                    Tank tank = (Tank) hero;
                    if (ability.equals("TAUNT")) {
                        tank.taunt();
                    } else {
                        System.out.println("Unknown ability for Tank: " + ability);
                    }
                    break;
                case "ASSASSIN":
                    Assassin assassin = (Assassin) hero;
                    if (ability.equals("BACKSTAB")) {
                        assassin.backstab();
                    } else {
                        System.out.println("Unknown ability for Assassin: " + ability);
                    }
                    break;
                default:
                    System.out.println("Unknown hero type: " + hero.getRole());
            }
        } catch (ClassCastException e) {
            System.out.println("Error casting hero: " + e.getMessage());
        }
    }

    // DAMAGE <name> <damage_amount>
    private static void takeDamageHero(String[] parts, ArrayList<Hero> heroes) {
        String name = parts[1];
        int damage = Integer.parseInt(parts[2]);
        Hero hero = findHero(name, heroes);

        if (hero == null) {
            System.out.println("Hero " + name + " not found");
            return;
        }

        if (hero instanceof Tank) {
            Tank tank = (Tank) hero;
            tank.takeDamage(damage);
        } else {
            // For non-tank heroes, just reduce HP directly
            int newHp = hero.getHp() - damage;
            if (newHp < 0)
                newHp = 0;
            hero.setHp(newHp);
            System.out.println(name + " takes " + damage + " damage! HP: " + newHp);
        }
    }

    // LIST - display all heroes
    private static void listAllHeroes(ArrayList<Hero> heroes) {
        System.out.println("=== HERO LIST ===");
        if (heroes.isEmpty()) {
            System.out.println("No heroes found");
        } else {
            for (int i = 0; i < heroes.size(); i++) {
                System.out.print((i + 1) + ". ");
                heroes.get(i).displayInfo();
            }
        }
    }

    private static Hero findHero(String name, ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.getName().equalsIgnoreCase(name)) {
                return hero;
            }
        }
        return null;
    }
}