import java.util.ArrayList;
import java.util.List;

/**
 * Generic Shelf class that can hold containers of items extending type T
 * 
 * @param <T> the base type of items that containers on this shelf can hold
 */
public class Shelf<T> {
  private String shelfId;
  private List<Container<? extends T>> containers;
  private int maxContainers;

  public Shelf(String shelfId, int maxContainers) {
    // TODO: Instantiate Objek
    this.shelfId = shelfId;
    this.maxContainers = maxContainers;
    containers = new ArrayList<Container<? extends T>>(maxContainers);
  }

  /**
   * Adds a container to the shelf
   * Uses wildcard with upper bound to accept containers of T or any subtype of T
   * 
   * Hint:
   * - Check if the current number of containers is less than maxContainers before
   * adding.
   * - If there's space, add the container to the containers list and return true.
   * - If full, return false.
   * 
   * @param container the container to add
   * @return true if container was added, false if shelf is full
   */
  public boolean addContainer(Container<? extends T> container) {
    // TODO: Implement
    boolean isSucccess = false;
    if (containers.size() < maxContainers) {
      containers.add(container);
      isSucccess = true;
    }
    return isSucccess;
  }

  /**
   * Removes a container from the shelf
   * 
   * @param container the container to remove
   * @return true if removed, false otherwise
   */
  public boolean removeContainer(Container<? extends T> container) {
    // TODO: Implement
    return containers.remove(container);
  }

  /**
   * Gets all containers on the shelf
   * 
   * Hint:
   * - Return a new list containing all containers on the shelf.
   * 
   * @return list of containers
   */
  public List<Container<? extends T>> getContainers() {
    // TODO: Implement
    return new ArrayList<Container<? extends T>>(containers);
  }

  /**
   * Checks if shelf is full
   * 
   * @return true if full, false otherwise
   */
  public boolean isFull() {
    // TODO: Implement
    return containers.size() >= maxContainers;
  }

  /**
   * Gets current number of containers
   * 
   * @return number of containers
   */
  public int getCurrentContainerCount() {
    // TODO: Implement
    return containers.size();
  }

  /**
   * Gets total number of items across all containers
   * 
   * @return total items
   */
  public int getTotalItems() {
    // TODO: Implement
    int totalItems = 0;
    for (Container<? extends T> container : containers) {
      totalItems += container.getCurrentSize();
    }
    return totalItems;
  }

  public String getShelfId() {
    // TODO: Implement
    return shelfId;
  }

  public int getMaxContainers() {
    // TODO: Implement
    return maxContainers;
  }

  @Override
  public String toString() {
    return String.format("Shelf[%s] (%d/%d containers, %d total items)",
        shelfId, containers.size(), maxContainers, getTotalItems());
  }
}
