package com.app.sharebucks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.sharebucks.model.Group;
import com.app.sharebucks.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public boolean validateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from `User` where emailId = :emailId and password = :password";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("emailId", emailId);
		queryParams.addValue("password", password);
		Integer count = jdbcTemplate.queryForObject(sql, queryParams, Integer.class);
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		String sql = "select * from `User` where emailId = :emailId";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("emailId", emailId);
		return jdbcTemplate.queryForObject(sql, queryParams, new BeanPropertyRowMapper<User>(User.class));
	}
	
	
}
