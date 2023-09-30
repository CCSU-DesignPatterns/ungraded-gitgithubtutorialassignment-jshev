package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * Abstract class Account, which BankAccount and CreditAccount extend.
 * The helper handler in the Chain of Responsibility pattern.
 * Has an abstract method deduct which takes an amount as an argument and returns nothing but can throw an InsufficientFundsException.
 **/
public abstract class Account {
    protected Account firsAccount;
    public double balance;

    /**
     * abstract method which takes an amount as an argument and returns nothing but can throw an InsufficientFundsException.
     * @param amount the amount to be deducted from that account
     * @throws InsufficientFundsException
     * if amount is more than BankAccount's balance or more than CreditAccount's limit, it will be deducted and passed to the next account in the chain
     * if amount is more than the sum of all BankAccounts' balances and CreditAccounts' limits, it will throw InsufficientFundsException
     **/
    public abstract void deduct(double amount) throws InsufficientFundsException;

    /**
     * @param nextChain next Account in the Chain of Responsibility
     * sets next Account in the Chain of Responsibility
     **/
    public abstract void setNextChain(Account nextChain);

}
