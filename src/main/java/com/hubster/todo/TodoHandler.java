package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.config.CommonContants;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.TodoModel;
import com.hubster.request.Request;
import com.hubster.response.Response;


public class TodoHandler implements RequestHandler<Request, Response> {

	private final TodoDaoImpl todoService = TodoDaoImpl.instance;

	private Response getResponse() {
		return new Response();
	}

	@Override
	public Response handleRequest(Request input, Context context) {

		List<TodoModel> list = todoService.getAllTodos(input);
		Response res = getResponse();
		if (!list.isEmpty()) {

			res.setResCode(CommonContants.SUCCESS_CODE);
			res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setModel(list);
		} else {
			res.setResCode(CommonContants.FAIL_CODE);
			res.setResDesc(CommonContants.FAIL_DESC);
		}

		return res;
	}

}
