package edu.ccsu.cs505.hw2;

public class Vendor implements PayingParty {

    @Override
    public void pay(double amount) {
        System.out.println("Vendor made paymount of $" + amount);
    }
    
}
