package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.SignupDAO;
import com.internousdev.whisker.dto.SignupDTO;
import com.internousdev.whisker.util.InputChecker;
import com.internousdev.whisker.util.RegexDesc;

public class SignupConfirmAction extends BaseAction {

	private String loginId;
	private String password;
	private String name;

	public String execute() throws Exception {

		clearError();

		SignupDAO dao = new SignupDAO();

		if (loginId == null || loginId.equals("")){
			putError("loginId", "入力してください");
		} else {
			if (!InputChecker.length(loginId, 1, 16)){
				putError("loginId", "1文字から16文字で入力してください");
			}else{
				if (dao.existsLoginId(loginId)){
					putError("loginId", "既に使用されているIDです");
				}
			}
			if (!InputChecker.regex(loginId, RegexDesc.format(RegexDesc.LOGIN_ID))){
				putError("loginId", "半角英数字で入力してください");
			}
		}


		if (password == null || password.equals("")){
			putError("password", "入力してください");
		}else{
			if (!InputChecker.length(password, 1, 16)){
				putError("password", "1文字から16文字で入力してください");
			}
			if (!InputChecker.regex(password, RegexDesc.format(RegexDesc.PASSWORD))){
				putError("password", "半角英数字で入力してください");
			}
		}

		if (name == null || name.equals("")){
			putError("name", "入力してください");
		}else{
			if (!InputChecker.length(name, 1, 16)){
				putError("name", "1文字から16文字で入力してください");
			}
			if (!InputChecker.regex(name, RegexDesc.format(RegexDesc.NAME))){
				putError("name", "使用不可文字が含まれています");
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
