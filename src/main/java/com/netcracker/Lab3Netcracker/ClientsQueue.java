package com.netcracker.Lab3Netcracker;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class ClientsQueue extends Thread{

	private volatile ArrayDeque<Client> clientsQueue = new ArrayDeque<Client>();
	
	private Semaphore sem;
	
	public ClientsQueue(Semaphore sem) {
		this.sem = sem;
	}
	
	@Override 
	public void run() {
		
		while(true) {
			
			clientsQueue.push(new Client());
			
			System.out.println("Новый клиент в очереди");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public Client getClient() {
		
		while(clientsQueue.size() == 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return clientsQueue.pop();
	}
	
}
