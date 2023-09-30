package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * CreditAccount class, which extends Account.
 * Overrides setNextChain and deduct methods 
 **/
public class CreditAccount extends Account{
    private double creditBalance;
    private double creditLimit;
    private Account chainAccount;

    /** 
     * constructor for CreditAccount
     * takes balance, limit, and chain and sets creditBalance, creditLimit, and chainAccount variables to those values
     * @param name accountName
     * @param balance accountBalance
     * @param chain chainAccount
     **/
    public CreditAccount(double balance, double limit, Account chain) {
        creditBalance = balance;
        creditLimit = limit;
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

    /**
     * adds to balance on this card only (no CoR)
     * @param amount amount to be charges to credit card
     * @returns creditLeft, which is the limit minus the balance
     **/
    public double charge(double amount) {
        double creditLeft = creditLimit - creditBalance;
        return creditLeft;
    }

    @Override
    public int hashCode() {
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
