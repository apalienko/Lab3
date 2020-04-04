package com.netcracker.Lab3Netcracker;

import java.util.concurrent.Semaphore;

public class CashierThread extends Thread {

	/**
	 * Reference to depository Cashier is currently working with
	 */
	private Depository dep;
	
	private Client curClient = null;
	
	private boolean isWorking = false;
	
	private Integer No;
	
	private Semaphore sem;
	
	private ClientsQueue cq;
	
	public CashierThread(Depository dep, Integer No, Semaphore sem, ClientsQueue cq) {
		this.dep = dep;
		this.No = No;
		this.sem = sem;
		this.cq = cq;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				sem.acquire();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			curClient = cq.getClient();
			
			sem.release();
			
			System.out.println("Cashier №" + No + " service the client");
			
			if(curClient.getIsToPut()) {
				dep.putCash(curClient.getMoney());
				System.out.println("Cashier №" + No + " put " + curClient.getMoney());
				try {
					Thread.sleep(curClient.getServiceTime());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				if(dep.takeCash(curClient.getMoney())) {
					System.out.println("Cashier №" + No + " took " + curClient.getMoney());
					try {
						Thread.sleep(curClient.getServiceTime());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			System.out.println("Cashier №" + No + " finished servicing the client");
		
		}
			
		
	}

	public synchronized boolean getIsWorking() {
		return isWorking;
	}
	
	public void setCurClient(Client curClient) {
		this.curClient = curClient;
	}
	
}
