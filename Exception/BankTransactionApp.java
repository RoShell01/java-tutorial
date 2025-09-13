import java.util.*;

public class BankTransactionApp {

    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }

        public InsufficientFundsException(String message, Throwable cause) {
            super(message, cause);
        }
    }

      static class InvalidTransactionFormatException extends RuntimeException {
        public InvalidTransactionFormatException(String message) {
            super(message);
        }

        public InvalidTransactionFormatException(String message, Throwable cause) {
            super(message, cause);
        }
    }

      static class Account {
        private final String accountId;
        private double balance;

        public Account(String accountId, double balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
            balance += amount;
        }

        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdraw amount must be positive");
            }
            if (balance < amount) {
                throw new InsufficientFundsException("Insufficient funds in account " + accountId);
            }
            balance -= amount;
        }

        public String getAccountId() {
            return accountId;
        }

        public double getBalance() {
            return balance;
        }
    }

    
    static class TransactionProcessor {

        public static void process(String[] transactions, Map<String, Account> accounts) {
            for (String transaction : transactions) {
                try {
                    String[] tokens = transaction.split(",");
                    if (tokens.length != 3) {
                        throw new InvalidTransactionFormatException("Invalid transaction format: \"" + transaction + "\"");
                    }

                    String accountId = tokens[0].trim();
                    String operation = tokens[1].trim().toUpperCase();
                    String amountStr = tokens[2].trim();

                    double amount;
                    try {
                        amount = Double.parseDouble(amountStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid amount in transaction: \"" + transaction + "\"");
                        continue;
                    }

                    Account account = accounts.get(accountId);
                    if (account == null) {
                        System.out.println("Error: Account not found: \"" + accountId + "\"");
                        continue;
                    }

                    switch (operation) {
                        case "DEPOSIT":
                            try {
                                account.deposit(amount);
                                System.out.printf("Processed: %s DEPOSIT %.2f -> new balance %.2f%n",
                                        accountId, amount, account.getBalance());
                            } catch (IllegalArgumentException e) {
                                System.out.printf("Error: Illegal argument for %s in \"%s\": %s%n",
                                        accountId, transaction, e.getMessage());
                            }
                            break;

                        case "WITHDRAW":
                            try {
                                account.withdraw(amount);
                                System.out.printf("Processed: %s WITHDRAW %.2f -> new balance %.2f%n",
                                        accountId, amount, account.getBalance());
                            } catch (IllegalArgumentException e) {
                                System.out.printf("Error: Illegal argument for %s in \"%s\": %s%n",
                                        accountId, transaction, e.getMessage());
                            } catch (InsufficientFundsException e) {
                                System.out.printf("Error: Insufficient funds for %s when withdrawing %.2f%n",
                                        accountId, amount);
                            }
                            break;

                        default:
                            throw new InvalidTransactionFormatException(
                                    "Invalid transaction operation: \"" + operation + "\" in \"" + transaction + "\"");
                    }

                } catch (InvalidTransactionFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    
    public static void main(String[] args) {
        
        Map<String, Account> accounts = new HashMap<>();
        accounts.put("A1001", new Account("A1001", 500.00));
        accounts.put("A1002", new Account("A1002", 100.00));

           String[] transactions = {
                "A1001,DEPOSIT,200.00",
                "A1002,WITHDRAW,50.00",
                "A1001,WITHDRAW,800.00",     
                "A1003,DEPOSIT,abc",         
                "A1002,TRANSFER,10",      
                "badformatline",             
                "A1002,WITHDRAW,-20"         
        };

        
        TransactionProcessor.process(transactions, accounts);

        
        System.out.println("\nFinal balances:");
        for (Account account : accounts.values()) {
            System.out.printf("%s: %.2f%n", account.getAccountId(), account.getBalance());
        }
    }
}