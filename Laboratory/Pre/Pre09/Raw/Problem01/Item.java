public class Item implements Comparable<Item> {

    // Tidak perlu ada yang diimplementasikan

    private String name;
    private String type;
    private int quantity;
    private double weight;
    private int rarity;

    public Item(String name, String type, int quantity, double weight, int rarity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.weight = weight;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public int getRarity() {
        return rarity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void removeQuantity(int amount) {
        this.quantity = Math.max(0, this.quantity - amount);
    }

    @Override
    public int compareTo(Item other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("%s [%s] x%d (Weight: %.1f, Rarity: %d*)",
                name, type, quantity, weight, rarity);
    }
}
