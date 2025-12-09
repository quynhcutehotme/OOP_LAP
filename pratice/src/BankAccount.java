package lsp2;

interface Account{
    void deposit(double amount);
    double getBalance();
}

interface WithdrawableAccount extends Account {
    void withdraw(double amount);
}

class BankAccount implements WithdrawableAccount {
    protected double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.balance = initialBalance;
    }
    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        if (amount > balance) throw new IllegalArgumentException("Not enough money");
        balance -= amount;
    }
    @Override
    public double getBalance() {
        return balance;
    }
}


class FixedTermAccount implements Account {
    private double balance;
    public FixedTermAccount(double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.balance = initialBalance;
    }
    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
    }
    @Override
    public double getBalance() {
        return balance;
    }
}

class TestAccount {
    public static void main(String[] args) {
        BankAccount client1= new BankAccount(100);
        FixedTermAccount client2 = new FixedTermAccount(100);

        client1.withdraw(20);
        System.out.println("Available balance of client1: "+ client1.getBalance());

        client2.deposit(200);
        System.out.println("Available balance of client2: "+ client2.getBalance());






    }
}