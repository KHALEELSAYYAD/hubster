package com.hubster.dao;

import java.util.List;

import com.hubster.model.TodoModel;
import com.hubster.request.Request;

/**
 * Employee DAO interface.
 *
 * @author Igor Bolic
 */
public interface TodoDao {

    List<TodoModel> getAllTodos(Request req);
}
