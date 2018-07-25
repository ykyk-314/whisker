package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.TweetDAO;
import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.TweetUtil;

public class TweetAction extends BaseAction {

	private String message;

	public String execute(){

		UserDTO user = (UserDTO)session.get("user");

		TweetDAO dao = new TweetDAO();

		if (dao.insert(user.getId(), message)){

			TweetUtil.select(user.getId(), session);

			return "success";
		}else{
			return "error";
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
