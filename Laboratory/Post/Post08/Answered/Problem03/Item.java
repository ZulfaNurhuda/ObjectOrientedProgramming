public class Item {
	private String name;
	private double price;
	private int stock;
	private double discount; // discount percentage (0-100)

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param price
	 * @param stock
	 * @throws InvalidQuantityException jika stok negatif, dengan pesan
	 *                                  "Stok tidak boleh negatif."
	 * @throws InvalidPriceException    jika harga negatif, dengan pesan
	 *                                  "Harga tidak boleh negatif."
	 */
	public Item(String name, double price, int stock) throws InvalidQuantityException, InvalidPriceException {
		if (stock < 0) {
			throw new InvalidQuantityException("Stok tidak boleh negatif.");
		}
		if (price < 0) {
			throw new InvalidPriceException("Harga tidak boleh negatif.");
		}
		this.name = name;
		this.price = price;
		this.stock = stock;
		discount = 0;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public double getDiscount() {
		return discount;
	}

	/**
	 * Set diskon untuk item
	 * 
	 * @param discount
	 * @throws InvalidDiscountException jika diskon tidak antara 0-100, dengan pesan
	 *                                  "Diskon harus antara 0-100%."
	 */
	public void setDiscount(double discount) throws InvalidDiscountException {
		if (discount < 0 || discount > 100) {
			throw new InvalidDiscountException("Diskon harus antara 0-100%.");
		}
		this.discount = discount;
	}

	public double getFinalPrice() {
		return price * (1 - discount / 100);
	}

	/**
	 * Menambahkan stok ke item
	 * 
	 * @param quantity
	 * @throws InvalidQuantityException jika quantity negatif, dengan pesan
	 *                                  "Jumlah stok yang ditambahkan tidak boleh
	 *                                  negatif."
	 */
	public void addStock(int quantity) throws InvalidQuantityException {
		if (quantity < 0) {
			throw new InvalidQuantityException("Jumlah stok yang ditambahkan tidak boleh negatif.");
		}
		stock += quantity;
	}

	/**
	 * Mengurangi stok item
	 * 
	 * @param quantity
	 * @throws InvalidQuantityException jika quantity negatif, dengan pesan
	 *                                  "Jumlah stok yang dikurangi tidak boleh
	 *                                  negatif."
	 * @throws OutOfStockException      jika stok tidak mencukupi, dengan pesan
	 *                                  "Stok tidak mencukupi. Tersedia: <stock>,
	 *                                  Diminta: <quantity>"
	 */
	public void reduceStock(int quantity) throws InvalidQuantityException, OutOfStockException {
		if (quantity < 0) {
			throw new InvalidQuantityException("Jumlah stok yang dikurangi tidak boleh negatif.");
		}
		if (stock < quantity) {
			throw new OutOfStockException("Stok tidak mencukupi. Tersedia: " + stock + ", Diminta: " + quantity);
		}
		stock -= quantity;
	}

	@Override
	public String toString() {
		if (discount > 0) {
			return name + " - Harga: Rp" + price + " (Diskon: " + discount + "%, Final: Rp" + getFinalPrice() + "), Stok: " + stock;
		}
		return name + " - Harga: Rp" + price + ", Stok: " + stock;
	}
}
