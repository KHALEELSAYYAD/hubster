package com.hubster.todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.TodoModel;
import com.hubster.request.FulfillmentState;
import com.hubster.request.InvocationSource;
import com.hubster.request.LexRequest;
import com.hubster.request.LexResponse;
import com.hubster.request.Request;


public class TodoHandler extends AbstractLexRequestHandler {

	private final TodoDaoImpl todoService = TodoDaoImpl.instance;
	private static final String NAME = "Name";
	
	

	/*public LexResponse handleRequest(Request input, Context context) {

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

		return getMessage(list.toString(),"Fulfilled");
	}*/
	
    @Override
    public com.hubster.request.LexResponse handleRequest(com.hubster.request.LexRequest lexRequest,
    		Map<String, String> sessionAttributes) {
    try {
            if ("gettodo".equals(lexRequest.getIntent().getName())) {
                return getAllTodos(lexRequest,sessionAttributes);
            } else if ("HelloIntent".equals(lexRequest.getIntent().getName())) {
                return processTodo(lexRequest,sessionAttributes);
            } else if ("GoodbyeIntent".equals(lexRequest.getIntent().getName())) {
                return deleteTodo(lexRequest,sessionAttributes);
            } else {
                return createElicitIntentDialogActionResponse();
            }
        } catch (Exception e) {
            return getMessage("Sorry, I'm having a problem fulfilling your request.  Please try again later.",FulfillmentState.Failed);
        }
    }
    
    public LexResponse getAllTodos(LexRequest lexRequest, Map<String, String> sessionAttributes) {
    	 String name = lexRequest.getIntent().getSlots().get(NAME);
    	 List<TodoModel> list=null;
    	  if (InvocationSource.FulfillmentCodeHook.equals(lexRequest.getInvocationSource())) {
             // The slot should not be empty if the InvocationSource is Fulfillment Code Hook
    		  sessionAttributes.put("CHID", name);
    		  Request req = new Request();
    		  req.setChassinId(Integer.parseInt(name));
    		   list = todoService.getAllTodos(req);
    		  
         } else {
             throw new RuntimeException("Unknown Invocation Source: " + lexRequest.getInvocationSource());
         }
    
    	 return getMessage(list.toString(), FulfillmentState.Fulfilled);
    }
  public LexResponse processTodo(LexRequest lexRequest,Map<String, String> sessionAttributes) {
    	
    	return null;
    }
  public LexResponse deleteTodo(LexRequest lexRequest,Map<String, String> sessionAttributes) {
  	
  	return null;
  }

 
 
  protected LexResponse getMessage(String str,FulfillmentState failed) {
	  return createCloseDialogActionResponse(failed, "Hello " + str);
	   
  }

@Override
public LexResponse handleRequest(LexRequest lexRequest, Context context) {
	Map<String, String> sessionAttributes=new HashMap<String, String>();
	context.getLogger().log("=======XXXXXXXX========="+lexRequest.toString());
	  try {
          if ("gettodo".equals(lexRequest.getIntent().getName())) {
              return getAllTodos(lexRequest,sessionAttributes);
          } else if ("HelloIntent".equals(lexRequest.getIntent().getName())) {
              return processTodo(lexRequest,sessionAttributes);
          } else if ("GoodbyeIntent".equals(lexRequest.getIntent().getName())) {
              return deleteTodo(lexRequest,sessionAttributes);
          } else {
              return createElicitIntentDialogActionResponse();
          }
      } catch (Exception e) {
          return getMessage("Sorry, I'm having a problem fulfilling your request.  Please try again later.",FulfillmentState.Failed);
      }
}


}


