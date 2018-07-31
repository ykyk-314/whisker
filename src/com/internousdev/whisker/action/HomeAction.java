package com.internousdev.whisker.action;

import java.util.List;

import com.internousdev.whisker.dao.FollowDAO;
import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.TweetUtil;

public class HomeAction extends BaseAction {

	private String userId;

	public String execute() throws Exception {

		UserDTO user = (UserDTO)session.get("user");
		UserDTO profile = null;
		boolean isFollowing = false;


		String preAction = (String)session.get("preAction");
		if (preAction.equals("LikeAction")) {
			profile = (UserDTO)session.get("profile");

			if (session.containsKey("home")){
				if (!(boolean)session.get("home")){
					userId = String.valueOf(profile.getId());
				}
			}
		}

		session.put("home", false);

		if (userId != null){
			UserDAO userDao = new UserDAO();
			profile = userDao.select(Integer.parseInt(userId));

			if (profile != null) {
				FollowDAO followDao = new FollowDAO();
				isFollowing = followDao.isFollowing(user.getId(), profile.getId());
			}else{
				throw new Exception();
			}

			TweetUtil.select(profile.getId(), session);

		}else{
			profile = user;
			FollowDAO followDao = new FollowDAO();
			List<Integer> list = followDao.select(user.getId());	// フォローしている人のIDを取得
			list.add(user.getId());		// 自身のIDを追加
			TweetUtil.select(list, session);
			session.put("home", true);
		}

		boolean isUser = user.getId() == profile.getId();

		session.put("profile", profile);
		session.put("isUser", isUser);
		session.put("isFollowing", isFollowing);

		System.out.println(user.getName());
		System.out.println(profile.getName());
		System.out.println(isFollowing);

		return "success";
	}

	public void setUserId(String userId){
		this.userId = userId;
	}
}
