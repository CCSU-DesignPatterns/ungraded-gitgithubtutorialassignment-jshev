package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * BankAccount class, which extends Account.
 * Overrides setNextChain and deduct methods 
 **/
public class BankAccount extends Account{
    private String accountName;
    private double accountBalance;
    private Account chainAccount;

    /** 
     * constructor for BankAccount
     * takes name, balance, and chain and sets accountName, accountBalance, and chainAccount variables to those values
     * @param name accountName
     * @param balance accountBalance
     * @param chain chainAccount
     **/
    public BankAccount(String name, double balance, Account chain) {
        accountName = name;
        accountBalance = balance;
        chainAccount = chain;
    }

    /**
     * @see setNextChain(Account nextChain) Javadoc in Account class
     **/
     @Override
    public void setNextChain(Account nextChain) {
        this.chainAccount = nextChain;
    }

    /**
     * @see deduct(double amount) throws InsufficientFundsException Javadoc in Account class
     **/
    @Override
    public void deduct(double amount) throws InsufficientFundsException {
        if (amount <= accountBalance) {
            double remaining = accountBalance - amount;
            System.out.println(accountName + " paid $" + amount + ". $" + remaining + " remaining in account.");
        } else {
            double remaining = amount - accountBalance;
            System.out.println(accountName + " paid $" + accountBalance + ". $" + remaining + " still needs to be paid.");
            this.chainAccount.deduct(remaining);
        }
    }

    /**
     * adds money to BanbkAccount's balance
     * @param amount amount of money to be added
     **/
    public void makeDeposit(double amount) {
        accountBalance = accountBalance + amount;
    }

    @Override
    public int hashCode() {
        return accountName.hashCode() + (int) accountBalance + chainAccount.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else {
            BankAccount bankAcc = (BankAccount) other;
            if (this.accountName.equals(bankAcc.accountName) && this.accountBalance == bankAcc.accountBalance && this.chainAccount == bankAcc.chainAccount) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        //return getClass().getName() + "@" + Integer.toHexString(hashCode());
        return this.accountName + " " + this.accountBalance + " " + this.chainAccount.toString();
    }
    
}
