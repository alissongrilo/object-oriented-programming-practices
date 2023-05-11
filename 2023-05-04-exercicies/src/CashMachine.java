import java.util.Scanner;

public class CashMachine {

    private Scanner scanner;
    private BankAccount[] accounts;

    public CashMachine() {
        scanner = new Scanner(System.in);
        accounts = new BankAccount[2];
    }

    public void execute() {
        int option;
        do {
            menu();
            option = Integer.parseInt(scanner.nextLine());
            executeSelectedOption(option);
        } while (option != 6);
    }

    private void menu() {
        System.out.println("1. Criar Conta");
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Transferencia de contas");
        System.out.println("6. Sair");
    }

    private double promptForValue() {
        double value;
        System.out.println("Enter value: ");
        value = Double.parseDouble(scanner.nextLine());
        return value;
    }

    private Client createClient() {
        Client client;
        String name, document;

        System.out.println("Enter your name: ");
        name = scanner.nextLine();

        System.out.println("Enter your document: ");
        document = scanner.nextLine();

        client = new Client(name, document);
        return client;
    }

    private BankAccount createBankAccount() {
        BankAccount account;
        int accountType = 0;

        while (accountType != 1 && accountType != 2) {
            System.out.println("Set your account type: ");
            System.out.println("1. Account with balance \n2. Account without balance");
            accountType = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Enter the account limit: ");
        double limit = Double.parseDouble(scanner.nextLine());

        if (accountType == 1) {
            System.out.println("Enter the account balance: ");
            double balance = Double.parseDouble(scanner.nextLine());
            account = new BankAccount(createClient(), limit, balance);
        } else {
            account = new BankAccount(createClient(), limit);
        }

        System.out.println("The account id is: " + account.getId());
        return account;
    }

    private int promptForAccountId() {
        int id;
        System.out.println("Enter account id: ");
        id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    private int promptForAccountId(String phrase) {
        int id;
        System.out.println("Enter " + phrase + " account id: ");
        id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    private int getIndexById(int id, BankAccount[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void printErrorMessage() {
        System.out.println("Error.");
    }

    private void executeSelectedOption(int option) {
        if (option == 1) {

            accounts[0] = createBankAccount();
            System.out.println("\nCreate another account: \n");
            accounts[1] = createBankAccount();

        } else if ((accounts[0] == null || accounts[1] == null) && option != 6) {
            printErrorMessage();
        } else if (option == 2) {
            int id = promptForAccountId();

            try {
                System.out.println(accounts[getIndexById(id, accounts)].owner.getName());
                System.out.println(accounts[getIndexById(id, accounts)].getBalance());
            } catch (Exception e) {
                printErrorMessage();
            }
        } else if (option == 3) {
            int id = promptForAccountId();

            try {
                if (!accounts[getIndexById(id, accounts)].deposit(promptForValue())) {
                    printErrorMessage();
                }
            } catch (Exception e) {
                printErrorMessage();
            }
        } else if (option == 4) {
            int id = promptForAccountId();

            try {
                if (!accounts[getIndexById(id, accounts)].withdraw(promptForValue())) {
                    printErrorMessage();
                }
            } catch (Exception e) {
                printErrorMessage();
            }

        } else if (option == 5) {
            int originAccountId = promptForAccountId("origin");
            int destinyAccountId = promptForAccountId("destiny");

            try {
                if (originAccountId == accounts[getIndexById(originAccountId, accounts)].getId() &&
                        destinyAccountId == accounts[getIndexById(destinyAccountId, accounts)].getId()) {

                    if (!accounts[getIndexById(originAccountId, accounts)].transfer(promptForValue(),
                            accounts[getIndexById(destinyAccountId, accounts)])) {
                                printErrorMessage();
                    }
                }
            } catch (Exception e) {
                printErrorMessage();
            }
        }
    }
}
