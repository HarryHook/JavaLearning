package com.JavaCoreLearning.threadLearning;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 2000;

    public static void main(String[] args) {

	Bank1 b = new Bank1(NACCOUNTS, INITIAL_BALANCE);
	for (int i = 0; i < NACCOUNTS; i++) {
	    TransferRunnable1 r = new TransferRunnable1(b, i, INITIAL_BALANCE);
	    Thread t = new Thread(r);
	    t.start();
	}

    }

}

class Bank1 {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    //private Condition sufficientFunds;

    public Bank1(int n, double initialBalance) {
	accounts = new double[n];
	for (int i = 0; i < accounts.length; i++) {
	    accounts[i] = initialBalance;
	}
	bankLock = new ReentrantLock();
	//sufficientFunds = bankLock.newCondition();
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {

	//bankLock.lock();
	try {
	    while (accounts[from] < amount) {
		//sufficientFunds.await();
		wait();
	    }
	    System.out.print(Thread.currentThread());
	    accounts[from] -= amount;
	    System.out.printf(" %10.2f from %d to %d ", amount, from, to);
	    accounts[to] += amount;
	    System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
	    //sufficientFunds.signalAll();
	    notifyAll();
	} finally {
	    //bankLock.unlock();
	    
	}
    }

    private synchronized double getTotalBalance() {
	//bankLock.lock();
	try {
	    double sum = 0;
	    for (double a : accounts) {
		sum += a;
	    }
	    return sum;
	} finally {
	   // bankLock.unlock();
	}

    }

    public int size() {
	return accounts.length;
    }
}

class TransferRunnable1 implements Runnable {
    Bank1 bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable1(Bank1 b, int from, double max) {
	bank = b;
	fromAccount = from;
	maxAmount = max;
    }

    public void run() {
	try {
	    while (true) {
		int toAccount = (int) (bank.size() * Math.random());
		double amount = maxAmount * Math.random();
		bank.transfer(fromAccount, toAccount, amount);
		Thread.sleep((int) (DELAY * Math.random()));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}