package com.JavaCoreLearning.threadLearning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsynchBankTest {
    public  static final int NACCOUNTS = 10;
    public  static final double INITIAL_BALANCE = 2000;
    
    public static void main(String[] args) {
	
	Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
	for(int i=0; i<NACCOUNTS; i++) {
	    TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
	    Thread t = new Thread(r);
	    t.start();
 	}

    }

}
class Bank {
	private final double[] accounts;
	private Lock bankLock = new ReentrantLock();
	public Bank(int n, double initialBalance) {
	  accounts = new double[n];
	  for(int i=0; i<accounts.length; i++){
	      accounts[i] = initialBalance;
	  }
	}
	public void transfer(int from, int to, double amount){
	   
	    bankLock.lock();
	    
	    try{
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d ", amount, from, to);
		accounts[to] += amount;
		System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
	    } finally {
		bankLock.unlock();
	    }
	}
	private double getTotalBalance() {
	    double sum = 0;
	    for(double a : accounts) {
		sum += a;
	    }
	    return sum;
	}
	public int size() {
	    return accounts.length;
	}
   }
class TransferRunnable implements Runnable {
    Bank bank;
    int fromAccount;
    double maxAmount;
    private int DELAY = 10;
    public TransferRunnable(Bank b, int from, double max) {
	bank = b;
	fromAccount = from;
	maxAmount = max;
    }
    public void run() {
	try {
	    while(true) {
		int toAccount = (int) (bank.size() * Math.random());
		double amount = maxAmount * Math.random();
		bank.transfer(fromAccount, toAccount, amount);
		Thread.sleep((int)(DELAY * Math.random()));
	    } 
	} catch(Exception e) {
		e.printStackTrace();
	}
    }
}