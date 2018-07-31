<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">

<title>login</title>
</head>
<body>
	<div class="backImg1"></div>
	<div class="backImg2"></div>
	<div class="backImg3"></div>
	<h1 class="subTitle">Whisker へログイン</h1>

	<s:form class="Form" action="LoginAction">

		<ul class="input">
			<!-- 入力エラー -->
			<s:if test="%{#session.error.containsKey('login')}">
				<s:iterator value="%{#session.error.login}">
					<li class="error inputError"><s:property /></li>
				</s:iterator>
			</s:if>

			<!-- ID入力 -->
			<li>
				<dl>
					<dt class="label">ユーザーID</dt>
					<dt>
						<s:textfield name="loginId" placeholder="ユーザーIDを入力"
							class="textbox" />
					</dt>
					<!-- 空白エラー -->
					<s:if test="%{#session.error.containsKey('loginId')}">
						<s:iterator value="%{#session.error.loginId}">
							<dd class="error">
								<s:property />
							</dd>
						</s:iterator>
					</s:if>
				</dl>
			</li>

			<!-- パスワード入力 -->
			<li>
				<dl>
					<dt class="label">パスワード</dt>
					<dt>
						<s:password name="password" placeholder="パスワードを入力" class="textbox" />
					</dt>
					<!-- 空白エラー -->
					<s:if test="%{#session.error.containsKey('password')}">
						<s:iterator value="%{#session.error.password}">
							<dd class="error">
								<s:property />
							</dd>
						</s:iterator>
					</s:if>
				</dl>
			</li>

			<!-- サブミットボタン -->
			<li><s:submit value="ログイン" class="button" /></li>


			<!-- 新規登録へのリンク -->
			<li><a href="SignupAction" class="link"> 新規アカウント作成 </a></li>

		</ul>
	</s:form>
</body>
</html>