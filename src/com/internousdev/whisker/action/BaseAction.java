package com.internousdev.whisker.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction  extends ActionSupport implements SessionAware {

	protected Map<String, Object> session;
	protected Map<String, List<String>> error;

	protected void putError(String key, String value){

		List<String> list = null;

		if (error == null){
			error = new HashMap<>();
		}

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

		if (error != null){
			error.clear();
		}
	}

	protected void printError(){
		if (error != null){
			System.out.println("エラー一覧:\n" + error.toString());
		}else{
			System.out.println("エラー一覧");
		}
	}

	protected boolean isError(){
		if (error != null){
			return error.size() > 0;
		}else{
			return false;
		}
	}

	public Map<String, List<String>> getError(){
		return error;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
