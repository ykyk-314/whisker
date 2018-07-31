package com.internousdev.whisker.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction  extends ActionSupport implements SessionAware {

	protected Map<String, Object> session;
	protected Map<String, List<String>> error = new HashMap<>();

	protected void putError(String key, String value){

		List<String> list = null;

		if (error.containsKey(key)){
			list = error.get(key);
		} else {
			list = new ArrayList<String>();
			error.put(key, list);
		}

		list.add(value);

		if (!session.containsKey("error")){
			session.put("error", error);
		}
	}

	protected void clearError(){

		if (session.containsKey("error")){
			session.remove("error");
		}

		error.clear();
	}

	protected void printError(){
		System.out.println("エラー一覧:\n" + error.toString());
	}

	protected boolean isError(){
		return error.size() > 0;
	}

	protected boolean isError(String key){
		return error.containsKey(key);
	}

	public Map<String, List<String>> getError(){
		return error;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;

		clearError();

		if (session.containsKey("action")) {
			String action = (String)session.get("action");
			session.put("preAction", action);
		}else {
			session.put("preAction", "");
		}

		session.put("action", this.getClass().getSimpleName());
	}
}
