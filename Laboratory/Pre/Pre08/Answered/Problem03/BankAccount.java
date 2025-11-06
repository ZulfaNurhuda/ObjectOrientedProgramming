public class BankAccount {
    private String owner;
    private double balance;

    /* TODO : Lengkapi konstruktor BankAccount(String owner, double balance)
       Konstruktor ini membuat akun baru dengan pemilik dan saldo awal.
       - Jika saldo awal negatif, lempar InvalidAmountException("Saldo awal tidak boleh negatif.").
       Tidak ada nilai kembalian (void). */
    public BankAccount(String owner, double balance) throws InvalidAmountException {
        // Type your code
        if (balance < 0) {
            throw new InvalidAmountException("Saldo awal tidak boleh negatif.");
        }

        this.owner = owner;
        this.balance = balance;
    }

    /* TODO : Lengkapi method getOwner()
       Mengembalikan nama pemilik akun (String). */
    public String getOwner() {
        // Type your code
        return owner;
    }

    /* TODO : Lengkapi method getBalance()
       Mengembalikan saldo akun (double). */
    public double getBalance() {
        // Type your code
        return balance;
    }

    /* TODO : Lengkapi method deposit(double amount)
       Menambah saldo akun.
       - Jika amount < 0, lempar InvalidAmountException("Nominal deposit tidak boleh negatif.").
       Tidak ada nilai kembalian. */
    public void deposit(double amount) throws InvalidAmountException {
        // Type your code
        if (amount < 0) {
            throw new InvalidAmountException("Nominal deposit tidak boleh negatif.");
        }
        balance += amount;
    }

    /* TODO : Lengkapi method withdraw(double amount)
       Mengurangi saldo akun.
       - Jika amount < 0, lempar InvalidAmountException("Nominal penarikan tidak boleh negatif.").
       - Jika saldo < amount, lempar InsufficientBalanceException("Saldo tidak mencukupi untuk penarikan.").
       Tidak ada nilai kembalian. */
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        // Type your code
        if (amount < 0.0) {
            throw new InvalidAmountException("Nominal penarikan tidak boleh negatif.");
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("Saldo tidak mencukupi untuk penarikan.");
        }
        balance -= amount;
    }

    /* TODO : Lengkapi method toString()
       Mengembalikan string deskripsi akun dalam format:
       "<nama> - Saldo: Rp<saldo>"
       Contoh: "Andi - Saldo: Rp500000.0" */
    @Override
    public String toString() {
        // Type your code
        return owner + " - Saldo: Rp" + balance;
    }
}
