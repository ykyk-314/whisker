package com.internousdev.whisker.action;

import java.io.File;

import com.internousdev.whisker.dao.UserDAO;
import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.UserUtil;

public class ProfileEditAction extends BaseAction {


	private File photo;
	private String photoContentType;
	private String photoFileName;

	private String name;
	private String introductions;


	public String execute() throws Exception {

		System.out.println("");
		System.out.println("ProfileEdit");
		System.out.println(name);
		System.out.println(introductions);
		System.out.println(photo);
		System.out.println(photoContentType);
		System.out.println(photoFileName);

		UserDTO user = (UserDTO)session.get("user");

		UserDAO dao = new UserDAO();

		if (name.length() == 0) {
			putError("name", "1文字以上で入力してください");
		}

		if (introductions.length() == 0) {
			putError("introductions", "1文字以上で入力してください");
		}

		if (photo != null && !photoContentType.equals("image/png")) {
			putError("photo", "pngファイルを選択してください");
		}

		if (!isError()) {

			if (photo != null) {
				UserUtil.uploadPhoto(user.getId(), photo);
			}

			// データベース更新
			if (dao.update(user.getId(), name, introductions)) {

				user = dao.select(user.getLoginId(), user.getPassword());
				session.put("user", user);
			} else {
				throw new Exception();
			}

			return "success";
		} else {
			return "error";
		}
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}
}
