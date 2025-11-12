import java.io.IOException;
import java.util.List;

/**
 * Layanan checkout untuk sistem Tokopaedi.
 *
 * Tugas:
 * - Simpan daftar produk dan gateway pembayaran.
 * - Cari produk berdasarkan id (throw checked exception jika tidak ditemukan).
 * - Proses checkout dengan validasi input, pengecekan stok, pemanggilan
 * gateway,
 * chaining exception (IOException -> Exception yang menangani kegagalan
 * pembayaran), dan rollback stok pada finally.
 */
public class CheckoutService {
	private final List<Product> products;
	private final PaymentGateway gateway;

	/**
	 * Constructor.
	 *
	 * Langkah-langkah:
	 * 1. Simpan parameter ke field.
	 *
	 * @param products daftar produk
	 * @param gateway  gateway pembayaran
	 */
	public CheckoutService(List<Product> products, PaymentGateway gateway) {
		// TODO: simpan ke field this.products dan this.gateway
		this.products = products;
		this.gateway = gateway;
	}

	/**
	 * Mencari produk berdasarkan id.
	 *
	 * Langkah-langkah:
	 * 1. Loop seluruh products
	 * 2. Jika ada yang id-nya sama dengan productId, kembalikan produk tersebut
	 * 3. Jika tidak ditemukan, lempar Exception yang menangani jika produk tidak
	 * ditemukan dengan pesan "Product <productId> not found"
	 *
	 * @param productId id produk
	 * @return produk yang ditemukan
	 */
	private Product find(String productId) throws ProductNotFoundException {
		// TODO: implement sesuai langkah-langkah di atas
		Product foundProduct = null;
		for (int i = 0; i < products.size() && foundProduct == null; i++) {
			Product product = products.get(i);
			if (product.getId().equals(productId)) {
				foundProduct = product;
			}
		}
		if (foundProduct == null) {
			throw new ProductNotFoundException("Product " + productId + " not found");
		}
		return foundProduct; // TODO: ganti dengan return produk yang ditemukan atau lempar Exception yang menangani jika produk tidak ditemukan
	}

	/**
	 * Melakukan proses checkout.
	 *
	 * Langkah-langkah:
	 * 1. Validasi input (UNCHECKED EXCEPTION):
	 *    - productId tidak null/blank -> jika invalid lempar Exception yang berasal
	 *      dari kesalahan klien dengan pesan "productId kosong"
	 *    - qty > 0 -> jika invalid lempar Exception yang berasal dari kesalahan klien
	 *      dengan pesan "qty harus > 0"
	 *    - card tidak null/blank -> jika invalid lempar Exception yang berasal dari
	 *      kesalahan klien dengan pesan "card kosong"
	 * 2. Cari produk via find(productId) (memungkinkan lempar Exception pada method
	 *    find) -> cara memanggil find(productId) bisa dengan this.find(productId) lalu
	 *    masukkan ke variabel Product p
	 * 3. Jika stok kurang dari qty, lempar Exception yang menangani kondisi stok
	 *    kurang dengan pesan "Stock <stock> < <qty>" (CHECKED EXCEPTION)
	 * 4. Siapkan flag reserved=false, paid=false
	 * 5. try {
	 *     - Kurangi stok produk dengan qty dan set reserved=true
	 *     - Hitung amount (100 per unit: amount=100*qty)
	 *     - try { gateway.charge(card, amount); set paid=true }
	 *    	 catch (IOException io) { lempar Exception yang menangani kegagalan pembayaran
	 *       dengan pesan "Payment failed via gateway" dan io sebagai cause (CHAINED
	 *       EXCEPTION) }
	 *    } finally {
	 *      - Jika berhasil reserve tapi pembayaran gagal, rollback stok (tambah kembali
	 *        produk dengan productId yang sama sebanyak qty)
	 *    }
	 * 
	 * NOTE: Perhatikan bahwa unchecked exception tidak ditulis di throws namun
	 * tetap bisa dilempar
	 *
	 * @param productId id produk
	 * @param qty       jumlah yang dipesan
	 * @param card      nomor kartu
	 */
	public void checkout(String productId, int qty, String card) throws ProductNotFoundException, InsufficientStockException, PaymentFailedException {
		// TODO: implement semua langkah di atas (validasi, reserve, charge, chaining, rollback)
		if (productId == null || productId.trim().isEmpty()) {
			throw new InvalidRequestException("productId kosong");
		}
		if (qty <= 0) {
			throw new InvalidRequestException("qty harus > 0");
		}
		if (card == null || card.trim().isEmpty()) {
			throw new InvalidRequestException("card kosong");
		}

		Product product = null;

		try {
			product = find(productId);
		} catch (ProductNotFoundException e) {
			throw e;
		}

		if (product.getStock() < qty) {
			throw new InsufficientStockException("Stock " + product.getStock() + " < " + qty);
		}

		boolean reserved = false;
		boolean paid = false;

		try {
			product.reduce(qty);
			reserved = true;
			int amount = 100 * qty;
			try { 
				gateway.charge(card, amount);
				paid = true;
			} catch (IOException io) {
				throw new PaymentFailedException("Payment failed via gateway", io);
			}
		} finally {
			if (reserved && !paid) {
				product.add(qty);
			}
		}
	}
}
