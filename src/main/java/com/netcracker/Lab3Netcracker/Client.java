package com.netcracker.Lab3Netcracker;

import java.math.BigDecimal;
import java.util.Random;

public class Client {

	/**
	 * true - client want to put money on his account
	 * false - client want to get money from his account
	 */
	private boolean toPut;
	
	private Integer money;
	
	/**
	 * Amount of money cashier needs to serve the client (in milliseconds)
	 */
	private Integer serviceTime; 
	
	/**
	 * Creates a client with random values 
	 */
	public Client() {
		Random rnd = new Random();
		toPut = Math.random() < 0.5;
		money = rnd.nextInt(200) + 100;
		serviceTime = rnd.nextInt(10000) + 10000;
	}

	public Long getServiceTime() {
		return new Long(serviceTime);
	}

	public Integer getMoney() {
		return money;
	}

	public boolean getIsToPut() {
		return toPut;
	}

}
