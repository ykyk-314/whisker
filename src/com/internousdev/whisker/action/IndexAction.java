package com.internousdev.whisker.action;

import com.internousdev.whisker.dto.UserDTO;

public class IndexAction extends BaseAction {


	public String execute(){

		if (session.containsKey("user")){
			UserDTO user = (UserDTO)session.get("user");
			if (user.getLogined() == 1){
				return "success";
			}
		}

		return "login";
	}
}
