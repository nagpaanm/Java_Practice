package bank;

/*
 * You have been tasked with writing a program for a popular bank that will 
 * automate all its incoming transactions (transfer, deposit, and withdraw). 
 * The bank has n accounts numbered from 1 to n. The initial balance of each 
 * account is stored in a 0-indexed integer array balance, with the (i + 1)th 
 * account having an initial balance of balance[i].

Execute all the valid transactions. A transaction is valid if:

The given account number(s) are between 1 and n, and
The amount of money withdrawn or transferred from is less than or equal to the 
balance of the account.

Implement the Bank class:

Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
boolean transfer(int account1, int account2, long money) Transfers money dollars 
from the account numbered account1 to the account numbered account2. Return true 
if the transaction was successful, false otherwise.
boolean deposit(int account, long money) Deposit money dollars into the account 
numbered account. Return true if the transaction was successful, false otherwise.
boolean withdraw(int account, long money) Withdraw money dollars from the account 
numbered account. Return true if the transaction was successful, false otherwise.
 * 
 */


public class Bank {
	public long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(this.balance.length >= account1 && this.balance.length >= account2){
            if(this.balance[account1 - 1] >= money){
                withdraw(account1, money);
                deposit(account2, money);
                return true;
            }
        } 
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(this.balance.length < account || account <= 0 || money < 0){
            return false;
        }
        this.balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(this.balance.length < account || account <= 0 || money < 0){
            return false;
        }
        if(this.balance[account - 1] >= money){
            this.balance[account - 1] -= money;
            return true;
        }
        return false;
    }
}
