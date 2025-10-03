public interface Attack {
    public void performAttack();

    public default void showAttackInfo() {
        System.out.println("Karakter ini bisa melakukan serangan!");
    }

}