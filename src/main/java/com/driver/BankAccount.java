package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {

    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits == 0) {
            if (sum == 0) {
                return "";
            } else {
                throw new IllegalArgumentException("Account Number can not be generated");
            }
        } else if (digits * 9 < sum || digits > sum) {
            throw new IllegalArgumentException("Account Number can not be generated");
        } else {
            for (int digit = 0; digit <= 9; digit++) {
                try {
                    String newNumber = generateAccountNumber(digits - 1, sum - digit);
                    if (newNumber != null) {
                        return digit + newNumber;
                    }
                } catch (IllegalArgumentException e) {
                    continue;
                }
            }
            throw new IllegalArgumentException("Account Number can not be generated");
        }
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount <= balance - minBalance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient Balance");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}