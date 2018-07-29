package com.internousdev.whisker.action;

import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.UserUtil;

public class LoginAction extends BaseAction {

	private String loginId;
	private String password;

	public String execute() throws Exception {

		clearError();

		if (loginId.equals("")) {
			putError("loginId", "IDを入力してください");
		}

		if (password.equals("")) {
			putError("password", "パスワードを入力してください");
		}

		UserDAO dao = new UserDAO();

		if (dao.exists(loginId, password)) {

			if (dao.login(loginId, password)) {
				UserDTO user = dao.select(loginId, password);
				session.put("user", user);

				if (!UserUtil.existsPhoto(user.getId())){
					UserUtil.copyDefaultPhoto(user.getId());
				}
			} else {
				putError("login", "ログインに失敗しました");
			}

		}else{

			putError("login", "ID またはパスワードを正しく入力してください");
		}

		if (isError()) {
			return "error";
		} else {
			return "success";
		}
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
