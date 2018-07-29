<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">
<title>Whisker新規登録</title>
</head>
<body>
	<h1 class="subTitle">アカウントの作成</h1>
	<s:form class="Form" action="SignupConfirmAction">

		<ul class="input">

			<!-- ID -->
			<li>
				<dl>
					<dt class="label">ユーザーID</dt>
					<dt>
						<s:textfield name="loginId" placeholder="ユーザーID"
							value="%{#session.signupDto.loginId}" class="textbox" />
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
			<!-- パスワード -->
			<li>
				<dl>
					<dt class="label">パスワード</dt>
					<dt>
						<s:textfield name="password" placeholder="パスワード"
							value="%{#session.signupDto.password}" class="textbox" />
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
			<!-- 表示名 -->
			<li>
				<dl>
					<dt class="label">表示名</dt>
					<dt>
						<s:textfield name="name" placeholder="表示名"
							value="%{#session.signupDto.name}" class="textbox" />
					</dt>
					<!-- エラー表示 -->
					<s:if test="%{#session.error.containsKey('name')}">
						<s:iterator value="%{#session.error.name}">
							<dd class="error">
								<s:property />
							</dd>
						</s:iterator>
					</s:if>
				</dl>
			</li>
			<!-- サブミットボタン -->
			<li><s:submit value="入力内容を確認" class="button" /></li>
		</ul>
	</s:form>
</body>
</html>