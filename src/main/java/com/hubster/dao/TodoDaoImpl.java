package com.hubster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hubster.model.TodoModel;
import com.hubster.request.Request;

public enum TodoDaoImpl implements TodoDao {
	instance;

	public List<TodoModel> getAllTodos(Request req) {
		List<TodoModel> employees = new ArrayList<TodoModel>();

		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.todo_query)) {
			ps.setInt(1, req.getChassinId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TodoModel em = new TodoModel();
				em.setFormID(rs.getInt("chid"));
				em.setChallenge(rs.getString("challenge"));

				employees.add(em);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
