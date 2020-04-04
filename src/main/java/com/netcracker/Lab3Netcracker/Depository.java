package com.netcracker.Lab3Netcracker;

public class Depository {

	private volatile Integer cash;

	public Depository() {
		cash = 1000;
	}
	
	public synchronized void putCash(Integer money) {
		cash += money;
	}
	
	public synchronized boolean takeCash(Integer money) {
		if(cash - money > 0) {
			cash -= money;
			return true;
		}

		return false;
	}
	
/*	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}
	*/
}
