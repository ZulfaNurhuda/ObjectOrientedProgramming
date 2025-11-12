class SpellService {
    public static void comboSpell(Character caster, int spell1Cost, int spell2Cost) throws SpellCastFailedException {
        // TODO: Cast spell pertama, jika gagal wrap exception ke SpellCastFailedException
        // Message: "Combo gagal saat cast spell pertama oleh <nama>"
        try {
            caster.castSpell(spell1Cost);
        } catch (Exception e) {
            throw new SpellCastFailedException("Combo gagal saat cast spell pertama oleh " + caster.getName(), e);
        }
        
        // TODO: Cast spell kedua, jika gagal wrap exception ke SpellCastFailedException
        // Message: "Combo gagal saat cast spell kedua oleh <nama>"
        try {
            caster.castSpell(spell2Cost);
        } catch (Exception e) {
            throw new SpellCastFailedException("Combo gagal saat cast spell kedua oleh " + caster.getName(), e);
        }
        
        System.out.println("Combo spell berhasil! Total mana digunakan: " + (spell1Cost + spell2Cost));
    }

    public static void displayException(Exception e) {
        System.out.println("Exception: " + e.getMessage());
        if (e.getCause() != null) {
            System.out.println("Caused by: " + e.getCause().getMessage());
        }
    }
}