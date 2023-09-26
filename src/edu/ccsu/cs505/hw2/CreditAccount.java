package edu.ccsu.cs505.hw2;

public class CreditAccount extends Account{

    private double creditBalance;
    private double creditLimit;
    private Account chainAccount;

    public CreditAccount(double balance, double limit, Account chain) {
        creditBalance = balance;
        creditLimit = limit;
        chainAccount = chain;
    }

    @Override
    public void setNextChain(Account nextChain) {
        this.chainAccount = nextChain;
    }

    @Override
    public void deduct(double amount) throws InsufficientFundsException {
        double creditLeft = creditLimit - creditBalance;
        if (amount <= creditLeft) {
            double remaining = creditLeft - amount;
            System.out.println("Credit card paid $" + amount + ". $" + remaining + " left before limit.");
        } else {
            if (chainAccount == null) {
                throw new InsufficientFundsException("Insufficient funds.");
            } else {
                double remaining = amount - creditLeft;
                System.out.println("Credit card paid $" + creditLeft + ". $" + remaining + " still needs to be paid.");
                this.chainAccount.deduct(remaining);
            }
        }
    }

    public double charge(double amount) {
        double creditLeft = creditLimit - creditBalance;
        return creditLeft;
    }

    @Override
    public int hashCode() {
        //return 1;
        return (int) creditBalance + (int) creditLimit + chainAccount.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else {
            CreditAccount bankAcc = (CreditAccount) other;
            if (this.creditBalance == bankAcc.creditBalance && this.creditLimit == bankAcc.creditLimit && this.chainAccount == bankAcc.chainAccount) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        //return getClass().getName() + "@" + Integer.toHexString(hashCode());
        return this.creditBalance + " " + this.creditLimit + " " + this.chainAccount.toString();
    }
    
}
