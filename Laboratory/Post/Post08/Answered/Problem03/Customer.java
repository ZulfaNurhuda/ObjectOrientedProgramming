public class Customer {
	private String name;
	private double balance;
	private int orderCount;
	private static final int MAX_ORDERS_PER_CUSTOMER = 10;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param balance
	 * @throws InvalidQuantityException jika saldo negatif, dengan pesan
	 *                                  "Saldo tidak boleh negatif."
	 */
	public Customer(String name, double balance) throws InvalidQuantityException {
		if (balance < 0) {
			throw new InvalidQuantityException("Saldo tidak boleh negatif.");
		}
		this.name = name;
		this.balance = balance;
		orderCount = 0;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * Menambah jumlah order untuk customer
	 * 
	 * @throws OrderLimitExceededException jika jumlah order melebihi batas
	 *                                     maksimum, dengan pesan
	 *                                     "Customer '<name>' telah mencapai batas
	 *                                     maksimum order (<max_orders>)."
	 */
	public void incrementOrderCount() throws OrderLimitExceededException {
		if (orderCount >= MAX_ORDERS_PER_CUSTOMER) {
			throw new OrderLimitExceededException("Customer '" + name + "' telah mencapai batas maksimum order (" + MAX_ORDERS_PER_CUSTOMER + ").");
		}
		orderCount++;
	}

	/**
	 * Menambahkan saldo ke customer
	 * 
	 * @param amount
	 * @throws InvalidQuantityException jika amount negatif, dengan pesan
	 *                                  "Jumlah top-up tidak boleh negatif."
	 */
	public void addBalance(double amount) throws InvalidQuantityException {
		if (amount < 0) {
			throw new InvalidQuantityException("Jumlah top-up tidak boleh negatif.");
		}
		balance += amount;
	}

	/**
	 * Mengurangi saldo customer
	 * 
	 * @param amount
	 * @throws InvalidQuantityException     jika amount negatif, dengan pesan
	 *                                      "Jumlah pengurangan tidak boleh
	 *                                      negatif."
	 * @throws InsufficientBalanceException jika saldo tidak mencukupi, dengan pesan
	 *                                      "Saldo tidak mencukupi. Saldo:
	 *                                      Rp<balance>, Dibutuhkan: Rp<amount>"
	 */
	public void deductBalance(double amount) throws InvalidQuantityException, InsufficientBalanceException {
		if (amount < 0) {
			throw new InvalidQuantityException("Jumlah pengurangan tidak boleh negatif.");
		}
		if (balance < amount) {
			throw new InsufficientBalanceException("Saldo tidak mencukupi. Saldo: Rp" + balance + ", Dibutuhkan: Rp" + amount);
		}
		balance -= amount;
	}

	@Override
	public String toString() {
		return name + " - Saldo: Rp" + balance + ", Orders: " + orderCount;
	}
}
