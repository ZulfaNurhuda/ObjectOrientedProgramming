class InvalidManaAmountException extends Exception {
    // Exception yang di-throw ketika nilai mana yang diberikan tidak valid (negatif atau nol)
    private int manaAmount;

    public InvalidManaAmountException(int manaAmount) {
        // Todo: Constructor dengan message: "Jumlah mana tidak valid: <manaAmount>"
        // lalu inisialisasi manaAmount
        super("Jumlah mana tidak valid: " + manaAmount);
        this.manaAmount = manaAmount;
    }

    public int getManaAmount() {
        return manaAmount;
    }
}