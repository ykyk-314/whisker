package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.FollowDAO;
import com.internousdev.whisker.dto.UserDTO;

public class DefollowAction extends BaseAction {

	private int userId;

	public String execute() throws Exception {

		UserDTO user = (UserDTO)session.get("user");

		if (user.getId() == userId){
			throw new Exception();
		}

		FollowDAO dao = new FollowDAO();
		if (dao.delete(user.getId(), userId)) {
			String preAction = (String)session.get("preAction");
			System.out.println(preAction);
			if (preAction.equals("FollowViewAction")) {
				return "follow";
			}else {
				return "home";
			}
		} else {
			throw new Exception();
		}
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
