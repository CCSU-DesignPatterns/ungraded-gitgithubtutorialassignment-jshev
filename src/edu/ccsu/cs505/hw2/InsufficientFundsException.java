package edu.ccsu.cs505.hw2;

/**
 * @author Julie Shevchenko
 * InsufficientFundsException class, which extends Exception.
 **/
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String errMsg) {
        super(errMsg);
    }
}
