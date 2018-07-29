package com.internousdev.whisker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.whisker.dao.SignupDAO;
import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.SignupDTO;
import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SignupCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() throws Exception{

		SignupDAO signUpDao = new SignupDAO();
		SignupDTO signUpDto = (SignupDTO)session.get("signupDto");

		if (signUpDao.insert(signUpDto)){

			UserDAO userDao = new UserDAO();

			String loginId = signUpDto.getLoginId();
			String password = signUpDto.getPassword();

			if (userDao.login(loginId, password)){
				UserDTO user = userDao.select(loginId, password);
				session.put("user", user);

				UserUtil.copyDefaultPhoto(user.getId());
			}
		}/*else{

		}*/

		session.remove("signupDto");

		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
