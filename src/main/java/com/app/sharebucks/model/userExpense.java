package com.app.sharebucks.model;

import java.util.Date;

public class userExpense {

	private int userExpenseID;
	
	private int expenseID;
	
	private boolean isResolvedPayment;
	
	private int owesAmount;
	
	private int userID;

	public int getUserExpenseID() {
		return userExpenseID;
	}

	public void setUserExpenseID(int userExpenseID) {
		this.userExpenseID = userExpenseID;
	}

	public int getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(int expenseID) {
		this.expenseID = expenseID;
	}

	public boolean isResolvedPayment() {
		return isResolvedPayment;
	}

	public void setResolvedPayment(boolean isResolvedPayment) {
		this.isResolvedPayment = isResolvedPayment;
	}

	public int getOwesAmount() {
		return owesAmount;
	}

	public void setOwesAmount(int owesAmount) {
		this.owesAmount = owesAmount;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
