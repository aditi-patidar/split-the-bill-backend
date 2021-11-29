package com.app.sharebucks.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.app.sharebucks.model.Expense;

public class expenseImpl implements ExpenseDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public int createGroupExpense(Expense expense) {
		String sql = "INSERT into `Expense`(createdDate, description, totalAmount, createdByuserID, expenseTypeID)"
				+ " VALUES (:createdDate,:description, :totalAmount, :createdByuserID, :expenseTypeID)";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("createdBy", expense.getCreatedByuserID());
		queryParams.addValue("description", expense.getDescription());
		queryParams.addValue("createdDate", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
		queryParams.addValue("totalAmount", expense.getTotalAmount());
		queryParams.addValue("expenseTypeID", expense.getExpenseTypeID());
		
		final KeyHolder holder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(sql, queryParams, holder, new String[] {"GENERATED_EXPENSE_ID" });
		
		Number expenseID = holder.getKey();
		
		return expenseID.intValue();
	}

	@Override
	public int createFriendExpense(Expense expense) {
		return 0;
	}

	@Override
	public List<Expense> getGroupExpenseDetail(int groupID, int ExpenseID) {
		return null;
	}

	@Override
	public List<Expense> getFriendExpenseDetail(int userID, int friendID) {
		return null;
	}

}
