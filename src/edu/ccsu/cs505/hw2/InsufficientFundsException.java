package edu.ccsu.cs505.hw2;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String errMsg) {
        super(errMsg);
    }
}
