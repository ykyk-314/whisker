package com.internousdev.whisker.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UserUtil {


	/*
	 * プロフィール画像をサーバーにアップロード
	 */
	public static void uploadPhoto(int userId, File file) throws IOException {
		String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images/users/" +userId);
		System.out.println("Image Location:" + filePath);
		File fileToCreate = new File(filePath, "photo.png");

		FileUtils.copyFile(file, fileToCreate);
	}

	/*
	 * デフォルトのプロフィール画像をユーザー用の位置にコピー
	 */
	public static void copyDefaultPhoto(int userId) throws IOException {
		String defaultFilePath = ServletActionContext.getServletContext().getRealPath("/").concat("images/default");
		File defaultFile = new File(defaultFilePath, "photo.png");

		String createFilePath = ServletActionContext.getServletContext().getRealPath("/").concat("images/users/" + userId);
		File createFile = new File(createFilePath, "photo.png");

		FileUtils.copyFile(defaultFile, createFile);
	}

	/*
	 * プロフィール画像が存在するか
	 */
	public static boolean existsPhoto(int userId) {
		String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images/users/" + userId);
		File file = new File(filePath, "photo.png");
		return file.exists();
	}
}