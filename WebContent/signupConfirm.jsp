<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>twitter demo</title>
	</head>
	<body>
		<h1>新規登録確認</h1>
		<ul>
			<li>
				<p>ログインID</p>
			</li>
			<li>
				<s:property value="%{#session.signupDto.loginId}" />
			</li>
			<li>
				<p>パスワード</p>
			</li>
			<li>
				<s:property value="%{#session.signupDto.password}" />
			</li>
			<li>
				<p>表示名</p>
			</li>
			<li>
				<s:property value="%{#session.signupDto.name}" />
			</li>
		</ul>
		<a href="SignupCompleteAction">
			登録
		</a>
	</body>
</html>