public class EcommerceBot extends CustomerServiceBot {
    private String eCommerceName;

    public EcommerceBot(String name, String eCommerceName) {
        super(name);
        this.eCommerceName = eCommerceName;
    }

    @Override
    public void respond() {
        System.out.println("Ecommerce bot " + getName() + " dari " + eCommerceName + " siap melayani Anda");
    }

    @Override
    public void displayInfo() {
        System.out.println("Ecommerce Bot " + getName() + " dari " + eCommerceName + " telah melayani " + getSessionCount() + " sesi");
    }

    public void processOrder(String order) {
        System.out.println("Memproses pesanan: " + order + " dari " + eCommerceName);
    }
}
