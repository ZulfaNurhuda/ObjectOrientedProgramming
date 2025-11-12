public class Main {
    public static void main(String[] args) {
        Character mage = new Character("Merlin", 100);
        Character wizard = new Character("Gandalf", 80);
        
        try {
            mage.restoreMana(-20);
        } catch (InvalidManaAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            wizard.castSpell(150);
        } catch (InsufficientManaException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Current Mana: " + e.getCurrentMana() + ", Required: " + e.getRequiredMana());
        } catch (InvalidManaAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            SpellService.comboSpell(mage, 60, 80);
        } catch (SpellCastFailedException e) {
            SpellService.displayException(e);
        }
        
        try {
            SpellService.comboSpell(wizard, 30, 40);
            System.out.println("Mana " + wizard.getName() + " tersisa: " + wizard.getMana());
        } catch (SpellCastFailedException e) {
            SpellService.displayException(e);
        }
    }
}