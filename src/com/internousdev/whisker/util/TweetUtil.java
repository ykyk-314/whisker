package com.internousdev.whisker.util;

import java.util.List;
import java.util.Map;

import com.internousdev.whisker.dao.TweetDAO;
import com.internousdev.whisker.dto.TweetDTO;

public class TweetUtil {

	public static boolean select(int userId, Map<String, Object> session) {

		TweetDAO tweetDao = new TweetDAO();
		List<TweetDTO> tweets = tweetDao.select(userId, 50);

		if (tweets != null) {
			session.put("tweets", tweets);
			return true;
		} else {
			return false;
		}
	}

	public static boolean select(List<Integer> userIdList, Map<String, Object> session) {

		TweetDAO tweetDao = new TweetDAO();
		List<TweetDTO> tweets = tweetDao.select(userIdList, 50);

		if (tweets != null) {
			session.put("tweets", tweets);
			return true;
		} else {
			return false;
		}
	}
}
