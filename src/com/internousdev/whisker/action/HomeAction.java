package com.internousdev.whisker.action;

import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.TweetUtil;

public class HomeAction extends BaseAction {


	public String execute(){

		UserDTO user = (UserDTO)session.get("user");

		session.put("profile", user);

		TweetUtil.select(user.getId(), session);

		return "success";
	}
}
