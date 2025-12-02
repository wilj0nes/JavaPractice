package com.practice.challenges.bank;

public class CheckingAcc extends Account {
    private static final int overDraft = -100;
//    private int balance;

    @Override
    public void withdrawl(int balance, int amount){
        super.withdrawl(balance, amount);

        int tempbalance= this.balance;
        if (tempbalance < overDraft) {

        }
    }

}
