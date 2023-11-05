package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (this.maxWithdrawalLimit < amount) {
            throw new IllegalArgumentException("Maximum Withdraw Limit Exceed");
        } else if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient Balance");
        }
        double currBal = getBalance();
        currBal -= amount;
        setBalance(currBal);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return 0.0;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        return 0.0;
    }

}
