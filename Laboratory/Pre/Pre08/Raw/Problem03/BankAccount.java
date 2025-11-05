public class BankAccount {
    private String owner;
    private double balance;

    /* TODO : Lengkapi konstruktor BankAccount(String owner, double balance)
       Konstruktor ini membuat akun baru dengan pemilik dan saldo awal.
       - Jika saldo awal negatif, lempar InvalidAmountException.
       Tidak ada nilai kembalian (void). */
    public BankAccount(String owner, double balance) throws InvalidAmountException {
        // Type your code
    }

    /* TODO : Lengkapi method getOwner()
       Mengembalikan nama pemilik akun (String). */
    public String getOwner() {
        // Type your code
        return null;
    }

    /* TODO : Lengkapi method getBalance()
       Mengembalikan saldo akun (double). */
    public double getBalance() {
        // Type your code
        return 0;
    }

    /* TODO : Lengkapi method deposit(double amount)
       Menambah saldo akun.
       - Jika amount < 0, lempar InvalidAmountException.
       Tidak ada nilai kembalian. */
    public void deposit(double amount) throws InvalidAmountException {
        // Type your code
    }

    /* TODO : Lengkapi method withdraw(double amount)
       Mengurangi saldo akun.
       - Jika amount < 0, lempar InvalidAmountException.
       - Jika saldo < amount, lempar InsufficientBalanceException.
       Tidak ada nilai kembalian. */
    public void withdraw(double amount)
        throws InvalidAmountException, InsufficientBalanceException {
        // Type your code
    }

    /* TODO : Lengkapi method toString()
       Mengembalikan string deskripsi akun dalam format:
       "<nama> - Saldo: Rp<saldo>"
       Contoh: "Andi - Saldo: Rp500000.0" */
    @Override
    public String toString() {
        // Type your code
        return null;
    }
}
