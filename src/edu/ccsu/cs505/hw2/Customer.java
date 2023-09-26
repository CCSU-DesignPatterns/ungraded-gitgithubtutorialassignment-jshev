package edu.ccsu.cs505.hw2;

import java.util.Arrays;

public class Customer implements PayingParty {

    private Account[] accounts = {};
    private CheckProcessor cp = new CheckProcessor();

    public static Account[] append(Account[] array, Account value) {
        Account[] result = Arrays.copyOf(array, array.length + 1);
        result[result.length - 1] = value;
        return result;
    }

    public void addAccount(Account acc) {
        accounts = append(accounts, acc);
    }

    @Override
    public void pay(double amount) {
        cp.processCheck(accounts[0], amount);
    }
    
}
