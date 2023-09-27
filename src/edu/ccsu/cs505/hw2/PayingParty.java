package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * PayingParty interface, which Vendor and Customer implement
 * Has an abstract method pay which takes an amount as an argument and returns nothing
 **/
public interface PayingParty {
    /**
     * abstract method pay which takes an amount as an argument and returns nothing
     * @param amount the amount on the paying party wants to make a payment of
     **/
    public void pay(double amount);
}
