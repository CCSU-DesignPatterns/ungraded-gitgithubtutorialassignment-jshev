package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * Vendor class, which implements PayingParty.
 * Overrides pay method 
 **/
public class Vendor implements PayingParty {

    /**
     * @see pay(double amount) Javadoc in PayingParty class
     **/
    @Override
    public void pay(double amount) {
        System.out.println("Vendor made paymount of $" + amount);
    }
    
}
