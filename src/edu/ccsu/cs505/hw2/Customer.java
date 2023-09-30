package edu.ccsu.cs505.hw2;

import java.util.Arrays;

/**
 * @author Julie Shevchenko
 * Customer class, which implements PayingParty.
 * Overrides pay method 
 **/
public class Customer implements PayingParty {

    private Account[] accounts = {};
    private CheckProcessor cp = new CheckProcessor();

    /**
     * append method used in addAccount method
     * @param array array of Accounts that needs to be added to
     * @param value Account to be added to array
     **/
    public static Account[] append(Account[] array, Account value) {
        Account[] result = Arrays.copyOf(array, array.length + 1);
        result[result.length - 1] = value;
        return result;
    }

    /**
     * addAccount method, which adds account to the end of the Customer's list of Accounts
     * @param acc Account to be added to array of Accounts
     **/
    public void addAccount(Account acc) {
        accounts = append(accounts, acc);
    }

    /**
     * @see pay(double amount) Javadoc in PayingParty class
     **/
    @Override
    public void pay(double amount) {
        cp.processCheck(accounts[0], amount);
    }
    
}
