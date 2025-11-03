import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse Manager class with generic methods for managing warehouse
 * operations
 */
public class WarehouseManager {

  private WarehouseManager() {}

  /**
   * Generic method to find items in a container that match a specific condition
   * Uses bounded type parameter
   * 
   * Hint:
   * - Iterate through the items in the container.
   * - Check if each item's category matches the specified category.
   * - If it matches, add it to the result list.
   * - Return the result list.
   * 
   * @param <T>       type that extends Product
   * @param container the container to search in
   * @param category  the category to filter by
   * @return list of matching products
   */
  public static <T extends Product> List<T> findByCategory(Container<T> container, String category) {
    // TODO: Implement
    List<T> itemFound = new ArrayList<T>();
    for (T item : container.getItems()) {
      if (item.getCategory().equals(category)) {
        itemFound.add(item);
      }
    }
    return itemFound;
  }

  /**
   * Generic method to calculate total weight of items in a container
   * 
   * Hint:
   * - Iterate through the items in the container.
   * - Sum the weight of each item.
   * 
   * @param <T>       type that extends Product
   * @param container the container
   * @return total weight in kg
   */
  public static <T extends Product> double calculateTotalWeight(Container<T> container) {
    // TODO: Implement
    double totalWeight = 0.0;
    for (T item : container.getItems()) {
      totalWeight += item.getWeight();
    }
    return totalWeight;
  }

  /**
   * Generic method to transfer items from one container to another
   * Uses wildcards to allow flexibility
   * 
   * Hint:
   * - Iterate through the items in the source container.
   * - For each item, attempt to add it to the destination container.
   * - If added successfully, remove it from the source container.
   * - Stop when the specified count is reached or source is empty.
   * - Return the number of items actually transferred.
   * 
   * @param <T>         the type of items
   * @param source      source container
   * @param destination destination container
   * @param count       number of items to transfer
   * @return number of items actually transferred
   */
  public static <T> int transferItems(Container<T> source, Container<T> destination, int count) {
    // TODO: Implement
    int idx = 0;
    int totalItemsTransferred = 0;
    List<T> items = source.getItems();
    while (idx < count && !source.isEmpty()) {
      T item = items.get(idx);
      if (destination.addItem(item)) {
        if (source.removeItem(item)) {
          totalItemsTransferred++;
        }
      }
      idx++;
    }
    return totalItemsTransferred;
  }

  /**
   * Generic method to count items in a shelf
   * Uses wildcard with upper bound
   * 
   * Hint:
   * - Use the shelf's method to get total items.
   * 
   * @param <T>   base type
   * @param shelf the shelf to count items from
   * @return total number of items
   */
  public static <T> int countItemsInShelf(Shelf<T> shelf) {
    // TODO: Implement
    return shelf.getTotalItems();
  }

  /**
   * Generic method to find container by ID in a shelf
   * 
   * Hint:
   * - Iterate through the containers in the shelf.
   * - Check if each container's ID matches the specified ID.
   * - If a match is found, return the container.
   * - If no match is found, return null.
   * 
   * @param <T>         base type
   * @param shelf       the shelf to search
   * @param containerId the container ID to find
   * @return the container if found, null otherwise
   */
  public static <T> Container<? extends T> findContainerById(Shelf<T> shelf, String containerId) {
    // TODO: Implement
    Container<? extends T> containerFound = null;
    List<Container<? extends T>> containers = shelf.getContainers();
    for (int i = 0; i < containers.size() && containerFound == null; i++) {
      Container<? extends T> container = containers.get(i);
      if (container.getContainerId().equals(containerId)) {
        containerFound = container;
      }
    }
    return containerFound;
  }
}
