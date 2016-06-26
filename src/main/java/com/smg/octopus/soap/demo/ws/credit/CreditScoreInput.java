package com.smg.octopus.soap.demo.ws.credit;

import java.math.BigDecimal;

public class CreditScoreInput {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	private BigDecimal balance;
}
