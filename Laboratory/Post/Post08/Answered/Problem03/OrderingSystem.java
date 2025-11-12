import java.util.ArrayList;
import java.util.List;

public class OrderingSystem {
	private List<Item> items;
	private List<Customer> customers;

	/**
	 * Constructor untuk OrderingSystem.
	 * Menginisialisasi ArrayList untuk items dan customers.
	 */
	public OrderingSystem() {
		items = new ArrayList<Item>();
		customers = new ArrayList<Customer>();
	}

	/**
	 * Menambahkan item ke dalam sistem pemesanan.
	 * 
	 * Langkah-langkah:
	 * 1. Periksa apakah item adalah null, jika iya lempar NullPointerException
	 * dengan pesan "Item tidak boleh null."
	 * 2. Periksa apakah sudah ada item dengan nama yang sama (case-insensitive),
	 * jika iya lempar DuplicateItemException dengan pesan
	 * "Item dengan nama '" + item.getName() + "' sudah ada."
	 * 3. Jika semua pemeriksaan lolos, tambahkan item ke ArrayList menggunakan
	 * add().
	 * 
	 * @param item Item yang akan ditambahkan
	 * @throws DuplicateItemException Jika item dengan nama yang sama sudah ada
	 * @throws NullPointerException   Jika item null
	 */
	public void addItem(Item item) throws NullPointerException, DuplicateItemException {
		if (item == null) {
			throw new NullPointerException("Item tidak boleh null.");
		}

		boolean isExists = false;
		for (Item itemx : items) {
			if (itemx.getName().equalsIgnoreCase(item.getName())) {
				isExists = true;
				break;
			}
		}
		if (isExists) {
			throw new DuplicateItemException("Item dengan nama '" + item.getName() + "' sudah ada.");
		}

		items.add(item);
	}

	/**
	 * Menambahkan customer ke dalam sistem pemesanan.
	 * 
	 * Langkah-langkah:
	 * 1. Periksa apakah customer adalah null, jika iya lempar NullPointerException
	 * dengan pesan "Customer tidak boleh null."
	 * 2. Tambahkan customer ke ArrayList menggunakan add().
	 * 
	 * @param customer Customer yang akan ditambahkan
	 * @throws NullPointerException Jika customer null
	 */
	public void addCustomer(Customer customer) throws NullPointerException {
		if (customer == null) {
			throw new NullPointerException("Customer tidak boleh null.");
		}
		customers.add(customer);
	}

	/**
	 * Mencari item berdasarkan nama.
	 * 
	 * Langkah-langkah:
	 * 1. Loop melalui semua item dalam ArrayList
	 * 2. Bandingkan nama item (case-insensitive) dengan parameter name
	 * 3. Jika ditemukan, return item tersebut
	 * 4. Jika tidak ditemukan, lempar ItemNotFoundException
	 * 
	 * @param name Nama item yang dicari
	 * @return Item yang ditemukan
	 * @throws ItemNotFoundException Jika item tidak ditemukan
	 */
	public Item findItem(String name) throws ItemNotFoundException {
		Item foundItem = null;
		for (Item item : items) {
			if (item.getName().equalsIgnoreCase(name)) {
				foundItem = item;
				break;
			}
		}
		if (foundItem == null) {
			throw new ItemNotFoundException("Item '" + name + "' tidak ditemukan.");
		}
		return foundItem;
	}

	/**
	 * Mencari customer berdasarkan nama.
	 * 
	 * Langkah-langkah:
	 * 1. Loop melalui semua customer dalam ArrayList
	 * 2. Bandingkan nama customer (case-insensitive) dengan parameter name
	 * 3. Jika ditemukan, return customer tersebut
	 * 4. Jika tidak ditemukan, lempar CustomerNotFoundException
	 * 
	 * @param name Nama customer yang dicari
	 * @return Customer yang ditemukan
	 * @throws CustomerNotFoundException Jika customer tidak ditemukan
	 */
	public Customer findCustomer(String name) throws CustomerNotFoundException {
		Customer foundCustomer = null;
		for (Customer customer : customers) {
			if (customer.getName().equalsIgnoreCase(name)) {
				foundCustomer = customer;
				break;
			}
		}
		if (foundCustomer == null) {
			throw new CustomerNotFoundException("Customer '" + name + "' tidak ditemukan.");
		}
		return foundCustomer;
	}

	/**
	 * Memproses pesanan dari customer.
	 * 
	 * Langkah-langkah:
	 * 1. Cari customer berdasarkan nama menggunakan findCustomer()
	 * 2. Increment jumlah pesanan customer
	 * 3. Cari item berdasarkan nama menggunakan findItem()
	 * 4. Hitung total harga menggunakan harga final (setelah diskon)
	 * 5. Kurangi saldo customer (bisa throw InsufficientBalanceException)
	 * 6. Kurangi stok item (bisa throw OutOfStockException)
	 * Jika berhasil, tampilkan pesan
	 * "Pesanan berhasil! " + customerName + " membeli " + quantity + " " + itemName
	 * + " seharga Rp" + total
	 * Jika gagal, lanjut ke langkah 7
	 * 7. Jika terjadi error saat mengurangi stok, rollback (add saldo yang sudah
	 * dikurangi) dan throw kembali exception yang ditangkap dari step 6
	 * 
	 * @param customerName Nama customer yang melakukan pesanan
	 * @param itemName     Nama item yang dipesan
	 * @param quantity     Jumlah item yang dipesan
	 * @throws ItemNotFoundException        Jika item tidak ditemukan
	 * @throws OutOfStockException          Jika stok tidak mencukupi
	 * @throws InvalidQuantityException     Jika quantity tidak valid
	 * @throws InsufficientBalanceException Jika saldo tidak mencukupi
	 * @throws CustomerNotFoundException    Jika customer tidak ditemukan
	 * @throws OrderLimitExceededException  Jika melebihi batas pesanan
	 */
	public void processOrder(String customerName, String itemName, int quantity) throws ItemNotFoundException, OutOfStockException, InvalidQuantityException, InsufficientBalanceException, CustomerNotFoundException, OrderLimitExceededException {
		Customer customer = null;
		Item item = null;
		double totalHarga = 0.0;
		boolean balanceDeducted = false;

		try {
			customer = findCustomer(customerName);
			customer.incrementOrderCount();

			item = findItem(itemName);
			totalHarga = item.getFinalPrice() * quantity;

			customer.deductBalance(totalHarga);
			balanceDeducted = true;
			item.reduceStock(quantity);

			System.out.println("Pesanan berhasil! " + customerName + " membeli " + quantity + " " + itemName + " seharga Rp" + totalHarga);
		} catch (OrderingSystemException e) {
			if (customer != null && balanceDeducted) {
				customer.addBalance(totalHarga);
			}
			throw e;
		}
	}

	/**
	 * Menampilkan semua item dalam sistem.
	 */
	public void displayItems() {
		System.out.println("Daftar Item:");

		if (items.isEmpty()) {
			System.out.println("(tidak ada item)");
			return;
		}

		for (Item item : items) {
			System.out.println("- " + item);
		}
	}

	/**
	 * Menampilkan semua customer dalam sistem.
	 */
	public void displayCustomers() {
		System.out.println("Daftar Customer:");

		if (customers.isEmpty()) {
			System.out.println("(tidak ada customer)");
			return;
		}

		for (Customer customer : customers) {
			System.out.println("- " + customer);
		}
	}
}
