<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
<title>新規登録確認</title>
</head>
<body>
	<h1 class="subTitle">こちらの内容でよろしいですか？</h1>
	<ul class="input confirm">
		<li><div class="row_item">ログインID</div>
			<div class="row_contents">
				<s:property value="%{#session.signupDto.loginId}" />
			</div></li>
		<li><div class="row_item">パスワード</div>
			<div class="row_contents">
				<s:property value="%{#session.signupDto.password}" />
			</div></li>
		<li><div class="row_item">アカウント名</div>
			<div class="row_contents">
				<s:property value="%{#session.signupDto.name}" />
			</div></li>
		<li><div>
				<a href="SignupAction" class="back"> 修正</a>
			</div></li>
		<li><div>
				<a href="SignupCompleteAction" class="enter"> 登録 </a>
			</div></li>
	</ul>



</body>
</html>