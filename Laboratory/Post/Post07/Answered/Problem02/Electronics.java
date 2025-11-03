/**
 * Electronics product type
 */
public class Electronics extends Product {
  private int warrantyMonths;

  public Electronics(String productId, String name, double weight, int warrantyMonths) {
    // TODO: Instantiate Objek
    super(productId, name, weight);
    this.warrantyMonths = warrantyMonths;
  }

  public int getWarrantyMonths() {
    // TODO: return warrantyMonths
    return warrantyMonths;
  }

  @Override
  public String getCategory() {
    return "Electronics";
  }

  @Override
  public String toString() {
    return super.toString() + String.format(" [Warranty: %d months]", warrantyMonths);
  }
}
