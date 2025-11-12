/**
 * Controller untuk operasi checkout.
 * - Menerima input dari endpoint simulasi melalui metode post(...).
 * - Memanggil CheckoutService dan menerjemahkan exception menjadi kode status HTTP.
 */
public class CheckoutController {
    private final CheckoutService service;

    public CheckoutController(CheckoutService service){ 
        this.service = service;
    }

    /**
     * Menangani permintaan checkout dan mencetak status HTTP sesuai hasil.
     * @param productId id produk
     * @param qty jumlah yang dipesan
     * @param card nomor kartu
     */
    public void post(String productId, int qty, String card){
        System.out.println("[START] endpoint /checkout");

        try {
            service.checkout(productId, qty, card);
            System.out.println("200 OK");                    // Jika gagal maka tidak akan mencetak 200 OK, tetapi akan mencetak pesan error lainnya
        } catch (ProductNotFoundException e) {                 // CHECKED EXCEPTION
            System.out.println("404 Not Found: " + e.getMessage());
        } catch (InsufficientStockException e) {               // CHECKED EXCEPTION
            System.out.println("409 Conflict: " + e.getMessage());
        } catch (PaymentFailedException e) {                   // CHECKED + CHAINED EXCEPTION (cek cause)
            System.out.println("402 Payment Required: " + e.getMessage() + " | cause=" + (e.getCause()!=null?e.getCause().getClass().getSimpleName():"-"));
        } catch (InvalidRequestException e) {                  // UNCHECKED EXCEPTION
            System.out.println("400 Bad Request: " + e.getMessage());
        } finally {
            System.out.println("[END] endpoint /checkout");
        }
    }
}
