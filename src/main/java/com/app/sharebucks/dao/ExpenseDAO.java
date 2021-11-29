package com.app.sharebucks.dao;

import java.util.List;

import com.app.sharebucks.model.Expense;

public interface ExpenseDAO {

	int createGroupExpense(Expense expense);
	
	// Create expense between 2 freinds will have to think about the table for it
	int createFriendExpense(Expense expense);
	
	List<Expense> getGroupExpenseDetail(int groupID, int ExpenseID);
	
	List<Expense> getFriendExpenseDetail(int userID, int friendID);
	
	
}
