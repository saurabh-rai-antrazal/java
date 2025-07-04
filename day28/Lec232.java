// package day28;

import java.util.*;

enum AccountType {
    CURRENT,
    SAVINGS
}

class BankAccount {
    AccountType accountType;
    double initialBal;

    public BankAccount(AccountType accountType) {
        this(accountType, 0);
    }

    public BankAccount(AccountType accountType, double bal) {
        this.initialBal = bal;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return accountType + "\nBalance: " + initialBal;
    }
}

class BankCustomer {
    static long lastCustomerId = 1_009_980;
    final String name;
    final long id;
    List<BankAccount> accounts = new ArrayList<>();

    public BankCustomer(String name, double currentAccountBal, double savingAccountBal) {
        this.name = name;
        this.id = lastCustomerId++;
        accounts.add(new BankAccount(AccountType.CURRENT, currentAccountBal));
        accounts.add(new BankAccount(AccountType.SAVINGS, savingAccountBal));
    }

    public void showDetails() {
        System.out.println("Customer ID   : " + this.id);
        System.out.println("Customer Name : " + this.name);
        for (BankAccount account : accounts) {
            System.out.println(account.toString());
        }
    }
}

public class Lec232 {
    public static void main(String[] args) {
        BankCustomer customer = new BankCustomer("Alice", 5000.0, 15000.0);
        customer.showDetails();
    }
}
