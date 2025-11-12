import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", 2));

        PaymentGateway gw = new PaymentGateway() {
            @Override
            public void charge(String card, int amount) throws IOException {
                // gagal kalau kartu berakhiran "0000"
                if (card.endsWith("0000"))
                    throw new IOException("timeout");
                // selain itu dianggap sukses
            }
        };

        CheckoutService svc = new CheckoutService(products, gw);
        CheckoutController ctrl = new CheckoutController(svc);

        // UNCHECKED: Bad Request
        ctrl.post(null, 1, "43211234"); // 400 Bad Request
        System.out.println();

        ctrl.post("", 1, "43211234"); // 400 Bad Request
        System.out.println();

        ctrl.post("P001", 0, "43211234"); // 400 Bad Request
        System.out.println();

        ctrl.post("P001", 1, null); // 400 Bad Request
        System.out.println();

        ctrl.post("P001", 1, ""); // 400 Bad Request
        System.out.println();

        // CHECKED + CHAINED: gagal pembayaran, stok harus rollback
        ctrl.post("P001", 1, "43210000"); // 402 Payment Required + cause=IOException
        System.out.println();

        // Happy path
        ctrl.post("P001", 1, "43211234"); // 200 OK
        System.out.println();

        // CHECKED: stok kurang
        ctrl.post("P001", 2, "43211234"); // 409 Conflict
        System.out.println();

        // CHECKED: produk tidak ada
        ctrl.post("P404", 1, "43211234"); // 404 Not Found

    }
}