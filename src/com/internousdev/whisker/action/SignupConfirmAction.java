package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.SignupDAO;
import com.internousdev.whisker.dto.SignupDTO;

public class SignupConfirmAction extends BaseAction {

	private String loginId;
	private String password;
	private String name;

	public String execute(){

		clearError();

		SignupDAO dao = new SignupDAO();

		if (loginId.equals("")){
			putError("loginId", "入力してください");
		} else {
			if (dao.existsLoginId(loginId)){
				putError("loginId", "既に使用されているIDです");
			}
		}

		if (password.equals("")){
			putError("password", "入力してください");
		}

		if (name.equals("")){
			putError("name", "入力してください");
		}

		SignupDTO dto = new SignupDTO();
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setName(name);

		session.put("signupDto", dto);

		if (isError()){
			return "error";
		}else{
			return "success";
		}
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

}
