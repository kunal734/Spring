package org.jsp.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsp.dto.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setPhone(rs.getLong(3));
			u.setPassword(rs.getString(4));
			users.add(u);
		}
		return users;
	}

}
