import java.util.ArrayList;
import java.util.List;

/**
 * Generic Container class that can hold items of type T
 * 
 * @param <T> the type of items this container holds
 */
public class Container<T> {
  private String containerId;
  private List<T> items;
  private int maxCapacity;

  public Container(String containerId, int maxCapacity) {
    // TODO: Instantiate Objek
    this.containerId = containerId;
    this.maxCapacity = maxCapacity;
    items = new ArrayList<T>(maxCapacity);
  }

  /**
   * Adds an item to the container
   * 
   * Hint:
   * - Check if the current size is less than maxCapacity before adding.
   * - If there's space, add the item to the items list and return true.
   * - If full, return false.
   * 
   * @param item the item to add
   * @return true if item was added successfully, false if container is full
   */
  public boolean addItem(T item) {
    // TODO: Implement
    boolean isSuccess = false;
    if (items.size() < maxCapacity) {
      items.add(item);
      isSuccess = true;
    }
    return isSuccess;
  }

  /**
   * Removes an item from the container
   * 
   * Hint:
   * - Attempt to remove the item from the items list.
   * - Return true if the item was present and removed, false otherwise.
   * 
   * @param item the item to remove
   * @return true if item was removed, false otherwise
   */
  public boolean removeItem(T item) {
    // TODO: Implement
    return items.remove(item);
  }

  /**
   * Gets all items in the container
   * 
   * Hint:
   * - Return a new list containing all items in the container.
   * 
   * @return list of items
   */
  public List<T> getItems() {
    // TODO: Implement
    return new ArrayList<T>(items);
  }

  /**
   * Checks if container is full
   * 
   * @return true if full, false otherwise
   */
  public boolean isFull() {
    // TODO: Implement
    return items.size() >= maxCapacity;
  }

  /**
   * Checks if container is empty
   * 
   * @return true if empty, false otherwise
   */
  public boolean isEmpty() {
    // TODO: Implement
    return items.isEmpty();
  }

  /**
   * Gets current number of items
   * 
   * @return number of items
   */
  public int getCurrentSize() {
    // TODO: Implement
    return items.size();
  }

  /**
   * Gets maximum capacity
   * 
   * @return max capacity
   */
  public int getMaxCapacity() {
    // TODO: Implement
    return maxCapacity;
  }

  /**
   * Gets container ID
   * 
   * @return container ID
   */
  public String getContainerId() {
    // TODO: Implement
    return containerId;
  }

  /**
   * Clears all items from container
   */
  public void clear() {
    // TODO: Implement
    items.clear();
  }

  @Override
  public String toString() {
    return String.format("Container[%s] (%d/%d items)", containerId, items.size(), maxCapacity);
  }
}
