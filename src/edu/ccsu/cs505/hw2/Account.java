package edu.ccsu.cs505.hw2;

public abstract class Account {
    protected Account firsAccount;
    public double balance;

    public abstract void deduct(double amount) throws InsufficientFundsException;
    public abstract void setNextChain(Account nextChain);

}
