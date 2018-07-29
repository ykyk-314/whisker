package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.FollowDAO;
import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.TweetUtil;

public class HomeAction extends BaseAction {

	private String userId;

	public String execute() throws Exception{

		UserDTO user = (UserDTO)session.get("user");
		UserDTO profile = null;
		boolean isFollowing = false;

		if(userId !=null){
			UserDAO userDao = new UserDAO();
			profile = userDao.select(Integer.parseInt(userId));

			if(profile !=null){
				FollowDAO followDao = new FollowDAO();
				isFollowing = followDao.isFollowing(user.getId(), profile.getId());

			}else{
				throw new Exception();
			}

			TweetUtil.select(profile.getId(), session);

		}else{
			profile = user;
			TweetUtil.select(profile.getId(), session);
		}

		boolean isUser = user.getId() == profile.getId();

		session.put("profile", profile);
		session.put("isUser", isUser);
		session.put("isFollowing", isFollowing);

		System.out.println(user.getName());
		System.out.println(profile.getName());
		System.out.println(isFollowing);

		TweetUtil.select(user.getId(), session);

		return "success";
	}

	public void setUserId(String userId){
		this.userId = userId;
	}
}
