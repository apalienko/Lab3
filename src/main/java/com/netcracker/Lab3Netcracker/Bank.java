package com.netcracker.Lab3Netcracker;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.concurrent.Semaphore;

public class Bank extends Thread{

	private Depository dep;
	
	private CashierThread[] cashiers;
	
	private ClientsQueue cq;
	
	private Semaphore sem = new Semaphore(1);
	
	public Bank() {
		dep = new Depository();
		cashiers = new CashierThread[4];
		cq = new ClientsQueue(sem);
		cq.start();
		
		for(int i = 0; i < 4; i++) {
			cashiers[i] = new CashierThread(dep, i + 1, sem, cq);
			cashiers[i].start();
		}
	}
	
	@Override
	public void run() {
		
		while(true) {
			

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/*
			int i = 0;
			boolean cashierNotFound = true;
			while(i < 4 && cashierNotFound) {
				if(!cashiers[i].getIsWorking()) {
					cashiers[i].setCurClient(clientsQueue.pop());
					cashiers[i].notify();
					cashierNotFound = false;
					
					System.out.println("Cashier №" + (i + 1) + " service the client");
				}
				i++;
			}
			*/
			dep.putCash(200);
			
			
		}
		
	}
	
}
