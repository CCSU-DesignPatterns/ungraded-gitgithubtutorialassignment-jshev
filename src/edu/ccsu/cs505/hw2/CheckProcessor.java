package edu.ccsu.cs505.hw2;

public class CheckProcessor {
    public void processCheck(Account acc, double amount) {
        try {
            acc.deduct(amount);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
}
