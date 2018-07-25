package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.UserDTO;

public class LogoutAction extends BaseAction {

	public String execute(){

		UserDTO user = (UserDTO)session.get("user");

		UserDAO dao = new UserDAO();
		dao.logout(user.getLoginId());

		session.clear();

		return "success";
	}
}
