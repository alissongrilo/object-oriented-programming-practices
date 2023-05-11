public class BankAccount {
    private static int lastIdCreated = 100;

    private int id;
    private double limit;
    private double balance;
    public Client owner;

    public BankAccount(Client client, double limit, double balance) {
        this(client, limit);
        this.balance = balance;
    }

    public BankAccount(Client client, double limit) {
        this.limit = limit;
        this.balance = 0;
        owner = client;
        lastIdCreated += 1;
        id = lastIdCreated;
    }

    public int getId() {
        return id;
    }

    public boolean transfer(double value, BankAccount destinationAccount) {
        if ((value < 0) || (balance - value + limit < 0)) {
            return false;
        } else {
            withdraw(value);
            destinationAccount.deposit(value);
        }
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double value) {
        if ((value < 0) || (balance - value + limit < 0)) {
            return false;
        } else {
            balance -= value;
        }
        return true;
    }

    public boolean deposit(double value) {
        if (value < 0) {
            return false;
        } else {
            balance += value;
        }
        return true;
    }
}
