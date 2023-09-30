package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * CheckProcessor class
 **/
public class CheckProcessor {

    /**
     * processes check
     * @param acc first account in CoR
     * @param amount the total amount to be deducted from customer's accounts
     * catches InsufficientFundsException
     **/
    public void processCheck(Account acc, double amount) {
        try {
            acc.deduct(amount);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
}
