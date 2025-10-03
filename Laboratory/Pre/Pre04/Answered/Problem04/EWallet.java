public class EWallet extends Pembayaran implements Payable, Refundable {

    /* Konstruktor */
    public EWallet(int balance) {
        super(balance);
    }

    public void pay(int amount) {
        if (amount > 0 && super.getBalance() >= amount) {
            super.setBalance(super.getBalance() - amount);
            System.out.printf("[EWallet] Paid: %d. Remaining balance: %d\n", amount, super.getBalance());
        } else {
            System.out.println("[EWallet] Payment failed. Insufficient balance or invalid amount.");
        }
    }

    public void refund(int amount) {
        if (amount > 0) {
            super.setBalance(super.getBalance() + amount);
            System.out.printf("[EWallet] Refunded: %d. New balance: %d\n", amount, super.getBalance());
        } else {
            System.out.println("[EWallet] Refund failed. Invalid amount.");
        }
    }
}
