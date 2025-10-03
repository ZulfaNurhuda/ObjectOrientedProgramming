public class COD extends Pembayaran implements Payable {
    
    /* Konstruktor */
    public COD(int balance) {
        super(balance);
    }

    public void pay(int amount) {
        if (amount > 0 && super.getBalance() >= amount) {
            super.setBalance(super.getBalance() - amount);
            System.out.printf("[COD] Paid: %d. Remaining balance: %d\n", amount, super.getBalance());
        } else {
            System.out.println("[COD] Payment failed. Insufficient balance or invalid amount.");
        }
    }
}
