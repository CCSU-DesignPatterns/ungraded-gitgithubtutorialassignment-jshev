package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * My main method.
 * Creates new customer.
 * Creates a Checking BankAccount with $200.
 * Creates a Savings BankAccount with $50.
 * Creates three CreditAccounts, each with a limit of $50.
 * Adds accounts to customer.
 * Customer tries to pay $150. -- Success.
 * Customer tries to pay $220. -- Success.
 * Customer tries to pay $5000. -- InsufficentFundsException.
 * @param args The command line arguments.
 **/
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        CreditAccount c3 = new CreditAccount(0, 50, null);
        CreditAccount c2 = new CreditAccount(0, 50, c3);
        CreditAccount c1 = new CreditAccount(0, 50, c2);
        BankAccount savings = new BankAccount("Savings", 50, c1);
        BankAccount checking = new BankAccount("Checking", 200, savings);
        customer.addAccount(checking);
        customer.addAccount(savings);
        customer.addAccount(c1);
        customer.addAccount(c2);
        customer.addAccount(c3);

        customer.pay(150);
        customer.pay(220);
        customer.pay(5000);
    }
}