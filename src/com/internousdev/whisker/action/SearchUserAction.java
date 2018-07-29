package com.internousdev.whisker.action;

import java.util.List;

import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.UserDTO;

public class SearchUserAction extends BaseAction {

	private String keyword;

	public String execute(){

		UserDTO user = (UserDTO)session.get("user");

		UserDAO dao = new UserDAO();
		List<UserDTO> list = dao.searchByName(keyword, user.getId());

		for(int i = 0; i < list.size(); i++){
			UserDTO dto = list.get(i);
			System.out.println(dto.getName());
		}

		session.put("search", list);

		return "success";
	}

	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
}
