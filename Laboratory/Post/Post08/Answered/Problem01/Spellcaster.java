interface Spellcaster {
    void restoreMana(int amount) throws InvalidManaAmountException;
    void castSpell(int manaCost) throws InsufficientManaException, InvalidManaAmountException;
}