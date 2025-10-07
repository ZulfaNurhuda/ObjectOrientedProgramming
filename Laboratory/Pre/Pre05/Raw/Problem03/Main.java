public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Pokenimons Battle ===");
        System.out.println();
        
        // ------------------------------------------------------------
        // Instansiasi Pokenimons
        // For your exploration, coba cari tahu kenapa saat menginstansiasi suatu tipe Pokenimons, di-assign ke variabel bertipe Pokenimons?
        // Apa bedanya jika di-assign ke variabel bertipe Pokenimons sesuai dengan sub-tipe Pokenimons?
        // Misalnya kenapa bukan
        // FireNimons fire   = new FireNimons("Pyron", 45); ? Apa alasannya?
        // ------------------------------------------------------------
        Pokenimons fire   = new FireNimons("Pyron", 45);
        Pokenimons water  = new WaterNimons("Aquon", 48);
        Pokenimons grass  = new GrassNimons("Leafy", 42);
        Pokenimons elec   = new ElectricNimons("Zappy", 40);

        System.out.println("Initial describe():");
        fire.printDescription();
        water.printDescription();
        grass.printDescription();
        elec.printDescription();
        System.out.println();

        // ------------------------------------------------------------
        // Dynamic Binding: useSkill() dipilih berdasarkan OBJEK
        //    (meski referensi bertipe Pokenimons)
        // Ini juga berkaitan dengan pertanyaan sebelumnya.
        // ------------------------------------------------------------
        System.out.println("Dynamic Binding: useSkill (tipe unggul/lemah/netral)");
        // FIRE -> GRASS  (x2.0)
        fire.useSkill(grass);
        // WATER -> FIRE  (x2.0)
        water.useSkill(fire);
        // FIRE -> WATER (x0.5)
        fire.useSkill(water);
        // ELECTRIC -> GRASS (x0.5)
        elec.useSkill(grass);
        // FIRE -> ELECTRIC (x1.0)
        fire.useSkill(elec);
        // GRASS -> ELECTRIC (x1.0)
        grass.useSkill(elec);
        System.out.println();

        // ------------------------------------------------------------
        // Marker Interface: [RANGED]/[MELEE] saat attack()
        //    WaterNimons & ElectricNimons implements RangedAttacker
        // ------------------------------------------------------------
        System.out.println("Marker Interface (RangedAttacker) via attack():");
        fire.attack(elec);   // [MELEE]
        water.attack(fire);  // [MELEE]
        elec.attack(grass);  // [RANGED]
        grass.attack(water); // [RANGED]
        System.out.println();

        // ------------------------------------------------------------
        // LEVEL UP + EVOLVE (dengan instanceof guard)
        //    - Evolusi dapat terjadi jika level >= 5 atau level >= 10
        //    - Evolusi mengembalikan objek baru tapi referensinya tetap Pokenimons
        // ------------------------------------------------------------
        System.out.println("Level Up + Evolve:");
        grass.printDescription();
        grass = grass.evolve(); // Tidak dapat berevolusi karena level < 5
        // Level up Leafy ke 7 lalu evolve ke GrassEvoNimons
        System.out.println("Level up Leafy 7x...");
        for (int i = 0; i < 7; i++) { grass.levelUp(); grass.printDescription(); }
        grass = grass.evolve(); // sekarang bisa jadi GrassEvoNimons
        grass.printDescription();
        // Tes double evolve prevention
        grass = grass.evolve(); // harus "already in final form."
        System.out.println();

        // Level up Pyron ke 10 lalu evolve ke FireEvoNimons
        fire.printDescription();
        fire = fire.evolve(); // Tidak dapat berevolusi karena level < 10
        System.out.println("Level up Pyron 9x...");
        for (int i = 0; i < 9; i++) { fire.levelUp(); fire.printDescription(); }
        fire = fire.evolve(); // FireEvoNimons
        fire.printDescription();
        fire = fire.evolve(); // sudah final form
        System.out.println();

        // Percobaan evolve ke ElectricNimons dan WaterNimons
        elec.printDescription();
        elec = elec.evolve(); // Tidak dapat berevolusi karena memang tidak dapat berevolusi
        water.printDescription();
        water = water.evolve(); // Tidak dapat berevolusi karena memang tidak dapat berevolusi
        System.out.println();

        // ------------------------------------------------------------
        // SETELAH EVOLUSI: jurus dan damage berbeda (dynamic binding tetap berjalan)
        //    GrassEvoNimons: Solar Beam (20 base) | FireEvoNimons: Flame Storm (25 base)
        // ------------------------------------------------------------
        System.out.println("After Evolution: useSkill() berubah sesuai bentuk baru");
        // Target baru untuk demo yang masih cukup HP
        Pokenimons target1 = new WaterNimons("Brook", 60);
        grass.useSkill(target1); // Solar Beam vs Water -> x2, damage 40
        fire.useSkill(target1);  // Flame Storm vs Water -> x0.5, damage 13
        System.out.println();

        // ------------------------------------------------------------
        // ARRAY POLYMORPHIC LOOP: semua disimpan sebagai Pokenimons,
        //    tapi perilaku tetap spesifik subclass ketika useSkill()
        // ------------------------------------------------------------
        System.out.println("Polymorphic Array Loop (semua bertipe Pokenimons):");
        Pokenimons fire2 = new FireNimons("Flame", 45);
        Pokenimons grass2 = new GrassNimons("Pine", 42);
        Pokenimons[] party = { fire, water, grass, elec, fire2, grass2 };
        Pokenimons dummy = new GrassNimons("Dummy", 125);
        for (Pokenimons p : party) {
            System.out.print(" -> ");
            p.useSkill(dummy); // setiap objek memanggil skill yang berbeda
        }
        System.out.println();

        // --------------------------------------------------------------------------------------
        // FAINTED GUARD: jika HP habis, tidak bisa beraksi, diattack, dan tidak dapat berevolusi
        // --------------------------------------------------------------------------------------
        System.out.println("Fainted guard:");
        fire.printDescription();
        elec.printDescription();
        dummy.printDescription();
        fire.useSkill(dummy);     // habiskan HP dummy
        elec.useSkill(dummy);     // dummy tidak dapat diattack karena sudah fainted
        fire.attack(elec);       // habiskan HP elec
        elec.attack(fire);       // elec tidak dapat beraksi karena sudah fainted
        fire.useSkill(fire2);
        fire.useSkill(fire2);
        fire2.evolve();
        System.out.println();

        // ------------------------------------------------------------
        // RANGKUMAN AKHIR
        // ------------------------------------------------------------
        System.out.println("Final States:");
        System.out.println("Party:");
        for (Pokenimons p : party) p.printDescription();
        System.out.println("Dummy: "); dummy.printDescription();

        System.out.println("\n=== GAME OVER ===");
    }
}
