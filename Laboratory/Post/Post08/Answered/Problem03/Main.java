/**
 * Driver class untuk menguji OrderingSystem dengan berbagai exception cases.
 * Output dirancang untuk maksimal 50 baris.
 */
public class Main {
	public static void main(String[] args) {
		// Inisialisasi sistem
		OrderingSystem system = new OrderingSystem();

		System.out.println("=== ORDERING SYSTEM TEST ===\n");

		try {
			// Setup data awal
			setupData(system);

			// Test Case 1: Order berhasil
			testSuccessfulOrder(system);

			// Test Case 2: Item tidak ditemukan
			testItemNotFound(system);

			// Test Case 3: Stok habis
			testOutOfStock(system);

			// Test Case 4: Saldo tidak cukup
			testInsufficientBalance(system);

			// Test Case 5: Quantity tidak valid
			testInvalidQuantity(system);

			// Test Case 6: Customer tidak ditemukan
			testCustomerNotFound(system);

			// Test Case 7: Duplicate item
			testDuplicateItem(system);

			// Test Case 8: Order dengan diskon
			testOrderWithDiscount(system);

			System.out.println("\n=== TEST SELESAI ===");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Setup data awal: items dan customers
	 */
	private static void setupData(OrderingSystem system) throws Exception {
		// Tambah items
		system.addItem(new Item("Laptop", 5000000, 3));
		system.addItem(new Item("Mouse", 100000, 10));
		system.addItem(new Item("Keyboard", 300000, 0)); // Stok kosong

		// Item dengan diskon
		Item headset = new Item("Headset", 500000, 5);
		headset.setDiscount(20); // Diskon 20%
		system.addItem(headset);

		// Tambah customers
		system.addCustomer(new Customer("Budi", 2000000));
		system.addCustomer(new Customer("Ani", 500000));
	}

	// Test 1: Order berhasil
	private static void testSuccessfulOrder(OrderingSystem system) {
		System.out.println("[1] Order Berhasil:");
		try {
			system.processOrder("Budi", "Mouse", 2);
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 2: Item tidak ditemukan
	private static void testItemNotFound(OrderingSystem system) {
		System.out.println("\n[2] Item Tidak Ditemukan:");
		try {
			system.processOrder("Budi", "Monitor", 1);
		} catch (ItemNotFoundException e) {
			System.out.println("   [CHECK] " + e.getMessage());
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 3: Stok habis
	private static void testOutOfStock(OrderingSystem system) {
		System.out.println("\n[3] Stok Habis:");
		try {
			system.processOrder("Budi", "Keyboard", 1);
		} catch (OutOfStockException e) {
			System.out.println("   [CHECK] " + e.getMessage());
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 4: Saldo tidak cukup
	private static void testInsufficientBalance(OrderingSystem system) {
		System.out.println("\n[4] Saldo Tidak Cukup:");
		try {
			system.processOrder("Ani", "Laptop", 1);
		} catch (InsufficientBalanceException e) {
			System.out.println("   [CHECK] " + e.getMessage());
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 5: Quantity tidak valid
	private static void testInvalidQuantity(OrderingSystem system) {
		System.out.println("\n[5] Quantity Tidak Valid:");
		try {
			system.processOrder("Budi", "Mouse", -5);
		} catch (InvalidQuantityException e) {
			System.out.println("   [CHECK] " + e.getMessage());
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 6: Customer tidak ditemukan
	private static void testCustomerNotFound(OrderingSystem system) {
		System.out.println("\n[6] Customer Tidak Ditemukan:");
		try {
			system.processOrder("Zaki", "Mouse", 1);
		} catch (CustomerNotFoundException e) {
			System.out.println("   [CHECK] " + e.getMessage());
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 7: Duplicate item
	private static void testDuplicateItem(OrderingSystem system) {
		System.out.println("\n[7] Duplicate Item:");
		try {
			system.addItem(new Item("Mouse", 150000, 5));
		} catch (DuplicateItemException e) {
			System.out.println("   [CHECK] " + e.getMessage());
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	// Test 8: Order dengan diskon
	private static void testOrderWithDiscount(OrderingSystem system) {
		System.out.println("\n[8] Order dengan Diskon:");
		try {
			system.processOrder("Budi", "Headset", 1);
		} catch (Exception e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}
}
