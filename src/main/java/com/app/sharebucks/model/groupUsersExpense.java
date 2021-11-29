package com.app.sharebucks.model;

public class groupUsersExpense {
	
	private int ID;
	

	private int groupID;

	private int expenseID;

	private int userID;

	private int owesAmount;
	
	private boolean isResolvedpayment;

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupId(int groupID) {
		this.groupID = groupID;
	}

	public int getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(int expenseID) {
		this.expenseID = expenseID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getOwesAmount() {
		return owesAmount;
	}

	public void setOwesAmount(int owesAmount) {
		this.owesAmount = owesAmount;
	}

	public boolean isResolvedpayment() {
		return isResolvedpayment;
	}

	public void setResolvedpayment(boolean isResolvedpayment) {
		this.isResolvedpayment = isResolvedpayment;
	}

}
