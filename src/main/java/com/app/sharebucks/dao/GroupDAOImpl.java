package com.app.sharebucks.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.sharebucks.model.Group;

import ch.qos.logback.core.util.SystemInfo;


@Repository
public class GroupDAOImpl implements GroupDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int createGroupForUser(Group group) {
		// TODO Auto-generated method stub
		System.out.println("========group====="+ group.getName());
		String sql = "INSERT into `Group`(name, createdDate, createdBy, groupType) VALUES (:name, :createdDate, :createdBy, :groupType)";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("createdBy", group.getCreatedBy());
		queryParams.addValue("name", group.getName());
		queryParams.addValue("createdDate", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
		queryParams.addValue("groupType", group.getGroupType());
		
		final KeyHolder holder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(sql, queryParams, holder, new String[] {"GENERATED_GROUP_ID" });
		
		Number groupId = holder.getKey();
		
		return groupId.intValue();

	}

	@Override
	public Group getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> getUserGroupsByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from `Group` as g join GroupUsers as gu on g.groupId = gu.groupId where userId = :userId";
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("userId", userId);
		return jdbcTemplate.query(sql, queryParams, new BeanPropertyRowMapper<Group>(Group.class));
	}
	

}
