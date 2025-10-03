public class Main {
    public static void main(String[] args) {
        System.out.println("=== GAME CHARACTER SYSTEM ===\n");
        
        // Membuat karakter
        Warrior warrior1 = new Warrior("Aragorn", 85);
        Warrior warrior2 = new Warrior("Conan", 90);
        
        Mage mage1 = new Mage("Gandalf", 95);
        Mage mage2 = new Mage("Merlin", 88);
        
        Paladin paladin1 = new Paladin("Arthas", 75, 80);
        Paladin paladin2 = new Paladin("Uther", 70, 85);
        
        System.out.println("--- TEST: Attack Info ---");
        warrior1.showAttackInfo();
        mage1.showAttackInfo();
        paladin1.showAttackInfo();
        
        System.out.println("\n--- TEST: Perform Attack ---");
        warrior1.performAttack();
        mage1.performAttack();
        paladin1.performAttack();
        
        System.out.println("\n--- TEST: Character Stats ---");
        warrior1.showPhysicalStats();
        mage1.showMagicalStats();
        paladin1.showPhysicalStats();
        paladin1.showMagicalStats();
        
        System.out.println("\n--- TEST: Power Enhancement ---");
        System.out.println("Sebelum refineBlade:");
        warrior1.showPhysicalStats();
        warrior1.refineBlade();
        System.out.println("Setelah refineBlade:");
        warrior1.showPhysicalStats();
        
        System.out.println("\nSebelum meditate:");
        mage1.showMagicalStats();
        mage1.meditate();
        System.out.println("Setelah meditate:");
        mage1.showMagicalStats();
        
        System.out.println("\nPaladin dapat menggunakan kedua enhancement:");
        System.out.print("Sebelum - ");
        paladin1.showPhysicalStats();
        System.out.print("Sebelum - ");
        paladin1.showMagicalStats();
        
        paladin1.refineBlade();
        paladin1.meditate();
        
        System.out.print("Setelah - ");
        paladin1.showPhysicalStats();
        System.out.print("Setelah - ");
        paladin1.showMagicalStats();
        
        System.out.println("\n--- TEST: Strength Comparison ---");
        
        System.out.println("\nWarrior vs Warrior:");
        int result1 = warrior1.compareStrength(warrior2);
        printComparisonResult("Aragorn", "Conan", result1);
        
        System.out.println("\nMage vs Mage:");
        int result2 = mage1.compareStrength(mage2);
        printComparisonResult("Gandalf", "Merlin", result2);
        
        System.out.println("\nPaladin vs Paladin:");
        int result3 = paladin1.compareStrength(paladin2);
        printComparisonResult("Arthas", "Uther", result3);

        System.out.println("\nWarrior vs Mage:");
        int result4 = warrior1.compareStrength(mage1);
        printComparisonResult("Aragorn", "Gandalf", result4);
        
        System.out.println("\n--- TEST: Polymorphism ---");
        Attack[] fighters = {warrior1, mage1, paladin1};
        
        System.out.println("Semua karakter menyerang:");
        for (Attack fighter : fighters) {
            fighter.performAttack();
        }
        
        System.out.println("\n=== TEST SELESAI ===");
    }
    
    // Helper method untuk menampilkan hasil perbandingan
    private static void printComparisonResult(String name1, String name2, int result) {
        if (result == -2) {
            System.out.println("Tidak dapat dibandingkan antara " + name1 + " dan " + name2);
            return;
        }
        if (result > 0) {
            System.out.println(name1 + " lebih kuat dari " + name2);
        } else if (result < 0) {
            System.out.println(name1 + " lebih lemah dari " + name2);
        } else {
            System.out.println(name1 + " sama kuat dengan " + name2);
        }
    }
    
}