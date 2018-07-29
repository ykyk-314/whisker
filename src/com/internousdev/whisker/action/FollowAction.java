package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.FollowDAO;
import com.internousdev.whisker.dto.UserDTO;

public class FollowAction extends BaseAction {

	private int userId;

	public String execute() throws Exception {

		UserDTO user = (UserDTO)session.get("user");

		if (user.getId() == userId){
			throw new Exception();
		}

		FollowDAO dao = new FollowDAO();
		if (!dao.isFollowing(user.getId(), userId)) {
			if (dao.insert(user.getId(), userId)) {
				return "success";
			} else {
				throw new Exception();
			}
		}else {
			throw new Exception();
		}
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
