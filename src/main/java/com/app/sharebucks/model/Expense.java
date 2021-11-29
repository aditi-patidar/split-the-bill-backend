package com.app.sharebucks.model;

import java.util.Date;

public class Expense {

	private int expenseID;
	
	private Date createdDate;
	
	private String description;
	
	private int totalAmount;
	
	private int createdByuserID;
	
	private int expenseTypeID;

	public int getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(int expenseID) {
		this.expenseID = expenseID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCreatedByuserID() {
		return createdByuserID;
	}

	public void setCreatedByuserID(int createdByuserID) {
		this.createdByuserID = createdByuserID;
	}

	public int getExpenseTypeID() {
		return expenseTypeID;
	}

	public void setExpenseTypeID(int expenseTypeID) {
		this.expenseTypeID = expenseTypeID;
	}
}
