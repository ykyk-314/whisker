package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.SignupDAO;
import com.internousdev.whisker.dto.SignupDTO;
import com.internousdev.whisker.util.InputChecker;

public class SignupConfirmAction extends BaseAction {

	private String loginId;
	private String password;
	private String name;

	public String execute(){

		clearError();

		SignupDAO dao = new SignupDAO();

		if (loginId == null || loginId.equals("")){
			putError("loginId", "入力してください");
		} else {
			if (!InputChecker.length(loginId, 8, 16)){
				putError("loginId", "8文字から16文字で入力してください");
			}else{
				if (dao.existsLoginId(loginId)){
					putError("loginId", "既に使用されているIDです");
				}
			}
		}

		if (password == null || password.equals("")){
			putError("password", "入力してください");
		}else{
			if (!InputChecker.length(password, 8, 16)){
				putError("password", "8文字から16文字で入力してください");
			}
		}

		if (name == null || name.equals("")){
			putError("name", "入力してください");
		}else{
			if (!InputChecker.length(name, 8, 16)){
				putError("name", "8文字から16文字で入力してください");
				System.out.println("wee");
			}
		}

		if (isError()){
			return "error";
		}else{

			SignupDTO dto = new SignupDTO();
			dto.setLoginId(loginId);
			dto.setPassword(password);
			dto.setName(name);

			session.put("signupDto", dto);

			return "success";
		}
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
