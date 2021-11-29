package com.app.sharebucks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.sharebucks.model.userFriendAssoc;

@Repository
public class userFriendsImpl implements userFriendsDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int createUserFriend(userFriendAssoc userfriend) {
		String insert_sql = "INSERT into `UserAndFriendAssoc`(friendID, userID) VALUES (:friendID, :userID)";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("friendID", userfriend.getFriendID());
		queryParams.addValue("userID", userfriend.getUserID());
		
		final KeyHolder holder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(insert_sql, queryParams, holder, new String[] {"GENERATED_GROUP_ID" });
		
		Number userfriendAssocID= holder.getKey();
		
		return userfriendAssocID.intValue();
	}

	@Override
	public List<userFriendAssoc> getUserFriendsByUserID(int userID) {
		// We have to get Names of friends not friendID 
		String select_sql = "select friendID from `UserAndFriendAssoc` WHERE userId = :userId";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("userId", userID);
		return jdbcTemplate.query(select_sql, queryParams, new BeanPropertyRowMapper<userFriendAssoc>(userFriendAssoc.class));
	}

}
