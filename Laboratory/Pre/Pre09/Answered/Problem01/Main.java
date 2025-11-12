import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Create inventory with 5 rows x 4 columns, max weight 100 kg
    Inventory inventory = new Inventory(5, 4, 100.0);

    // Create sample items
    Item sword = new Item("Excalibur Sword", "Weapon", 1, 5.5, 5);
    Item potion = new Item("Health Potion", "Consumable", 10, 0.2, 2);
    Item armor = new Item("Dragon Armor", "Armor", 1, 15.0, 5);
    Item bow = new Item("Elven Bow", "Weapon", 1, 2.5, 4);
    Item shield = new Item("Iron Shield", "Armor", 1, 8.0, 3);
    Item manaPotion = new Item("Mana Potion", "Consumable", 5, 0.2, 2);
    Item gem = new Item("Ruby Gem", "Material", 3, 0.1, 4);
    Item scroll = new Item("Teleport Scroll", "Consumable", 2, 0.1, 3);
    Item helmet = new Item("Steel Helmet", "Armor", 1, 3.5, 2);
    Item ring = new Item("Magic Ring", "Accessory", 1, 0.05, 5);

    // Demo 1: Adding items
    System.out.println("\n【DEMO 1: Adding Items to Inventory】");
    inventory.addItem("A1", sword);
    inventory.addItem("A2", potion);
    inventory.addItem("B1", armor);
    inventory.addItem("B3", bow);
    inventory.addItem("C2", shield);
    inventory.addItem("D1", manaPotion);
    inventory.addItem("D3", gem);
    inventory.addItem("E1", scroll);
    inventory.addItem("E2", helmet);
    inventory.addItem("A3", ring);

    inventory.displayGrid();

    // Demo 2: Display detailed inventory
    System.out.println("\n【DEMO 2: Detailed Inventory】");
    inventory.displayDetailedInventory();

    // Demo 3: Search operations
    System.out.println("\n【DEMO 3: Search Operations】");
    System.out.println("\n--- Search by name 'Potion' ---");
    Map<String, Item> potionResults = inventory.searchByName("Potion");
    potionResults.forEach((pos, item) -> System.out.println("[" + pos + "] " + item));

    System.out.println("\n--- Filter by type 'Weapon' ---");
    Map<String, Item> weapons = inventory.filterByType("Weapon");
    weapons.forEach((pos, item) -> System.out.println("[" + pos + "] " + item));

    System.out.println("\n--- Filter by rarity >= 4 (Legendary & Epic) ---");
    Map<String, Item> rareItems = inventory.filterByRarity(4);
    rareItems.forEach((pos, item) -> System.out.println("[" + pos + "] " + item));

    // Demo 4: Sorting operations
    System.out.println("\n【DEMO 4: Sorting Operations】");

    System.out.println("\n--- Sort by Name (Alphabetical) ---");
    List<Map.Entry<String, Item>> sortedByName = inventory.sortByName();
    sortedByName.forEach(entry -> System.out.println("[" + entry.getKey() + "] " + entry.getValue().getName()));

    System.out.println("\n--- Sort by Rarity (Highest first) ---");
    List<Map.Entry<String, Item>> sortedByRarity = inventory.sortByRarity();
    sortedByRarity.forEach(entry -> System.out.println("[" + entry.getKey() + "] " + entry.getValue().getName() +
        " (" + entry.getValue().getRarity() + "*)"));

    System.out.println("\n--- Sort by Weight (Lightest first) ---");
    List<Map.Entry<String, Item>> sortedByWeight = inventory.sortByWeight();
    sortedByWeight.forEach(entry -> System.out.println("[" + entry.getKey() + "] " + entry.getValue().getName() +
        " (" + entry.getValue().getWeight() + " kg)"));

    // Demo 5: Advanced filtering
    System.out.println("\n【DEMO 5: Advanced Filtering】");

    System.out.println("\n--- Top 3 Heaviest Items ---");
    List<Map.Entry<String, Item>> heaviest = inventory.getHeaviestItems(3);
    heaviest.forEach(entry -> System.out.println("[" + entry.getKey() + "] " + entry.getValue().getName() +
        " - " + entry.getValue().getWeight() + " kg"));

    System.out.println("\n--- Top 3 Lightest Items ---");
    List<Map.Entry<String, Item>> lightest = inventory.getLightestItems(3);
    lightest.forEach(entry -> System.out.println("[" + entry.getKey() + "] " + entry.getValue().getName() +
        " - " + entry.getValue().getWeight() + " kg"));

    System.out.println("\n--- Legendary Items (5*) ---");
    List<Map.Entry<String, Item>> legendary = inventory.getLegendaryItems();
    legendary.forEach(entry -> System.out.println("[" + entry.getKey() + "] " + entry.getValue()));

    // Demo 6: Statistics
    System.out.println("\n【DEMO 6: Statistics】");
    inventory.displayStatistics();

    System.out.println("--- Total Quantity by Type ---");
    Map<String, Integer> quantityByType = inventory.getTotalQuantityByType();
    quantityByType.forEach((type, qty) -> System.out.println(type + ": " + qty + " total units"));

    // Demo 7: Moving items
    System.out.println("\n【DEMO 7: Moving Items】");
    System.out.println("\nMoving Excalibur Sword from A1 to C1...");
    inventory.moveItem("A1", "C1");
    inventory.displayGrid();

    // Demo 8: Auto-add feature
    System.out.println("\n【DEMO 8: Auto-Add to First Empty Slot】");
    Item newItem = new Item("Ancient Tome", "Book", 1, 1.5, 4);
    inventory.autoAddItem(newItem);
    System.out.println("First empty slot: " + inventory.getFirstEmptySlot());

    // Demo 9: Check operations
    System.out.println("\n【DEMO 9: Check Operations】");
    System.out.println("Has 'Dragon Armor'? " + inventory.hasItem("Dragon Armor"));
    System.out.println("Has 'Wooden Stick'? " + inventory.hasItem("Wooden Stick"));
    System.out.println("Total items: " + inventory.countItems());
    System.out.println("Empty slots: " + inventory.countEmptySlots());

    // Demo 10: Filter by weight range
    System.out.println("\n【DEMO 10: Filter by Weight Range】");
    System.out.println("\n--- Items between 0.1 kg and 5.0 kg ---");
    Map<String, Item> mediumWeight = inventory.filterByWeightRange(0.1, 5.0);
    mediumWeight.forEach(
        (pos, item) -> System.out.println("[" + pos + "] " + item.getName() + " - " + item.getWeight() + " kg"));

    // Demo 11: Remove item
    System.out.println("\n【DEMO 11: Removing Item】");
    System.out.println("\nRemoving item from B3...");
    Item removed = inventory.removeItem("B3");
    if (removed != null) {
      System.out.println("Removed: " + removed);
    }
    inventory.displayGrid();

    // Demo 12: Stacking similar items
    System.out.println("\n【DEMO 12: Stacking Similar Items】");
    // Add duplicate health potion
    inventory.addItem("B2", new Item("Health Potion", "Consumable", 5, 0.2, 2));
    System.out.println("\nBefore stacking:");
    inventory.displayDetailedInventory();

    inventory.stackSimilarItems();
    System.out.println("\nAfter stacking:");
    inventory.displayDetailedInventory();

    // Final display
    System.out.println("\n【FINAL INVENTORY STATE】");
    inventory.displayGrid();
    inventory.displayStatistics();

    // Demo 13: Get all occupied positions
    System.out.println("\n【DEMO 13: Occupied Positions】");
    Set<String> occupied = inventory.getOccupiedPositions();
    System.out.println("Occupied positions: " + occupied);

    // Demo 14: Get all items as collection
    System.out.println("\n【DEMO 14: All Items Collection】");
    Collection<Item> allItems = inventory.getAllItems();
    System.out.println("Total unique items in inventory: " + allItems.size());
  }
}
