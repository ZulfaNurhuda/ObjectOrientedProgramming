class InsufficientManaException extends Exception {
    // Exception yang di-throw ketika mana character tidak cukup
    private int currentMana;
    private int requiredMana;

    public InsufficientManaException(int currentMana, int requiredMana) {
        // Todo: Constructor dengan message: "Mana tidak cukup! Mana saat ini: <currentMana>, Mana dibutuhkan: <requiredMana>"
        // lalu inisialisasi currentMana dan requiredMana
        super("Mana tidak cukup! Mana saat ini: " + currentMana + ", Mana dibutuhkan: " + requiredMana);
        this.currentMana = currentMana;
        this.requiredMana = requiredMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }
    
    public int getRequiredMana() {
        return requiredMana;
    }
}