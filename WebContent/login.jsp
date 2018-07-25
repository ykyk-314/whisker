<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>twitter demo</title>
	</head>
	<body>
		<h1>ログイン画面</h1>
		<s:form action="LoginAction">
			<ul>
				<!-- ログインID入力フィールド -->
				<li>
					<s:textfield name="loginId" placeholder="ID" /><br>
				</li>
				<!-- パスワード入力フィールド -->
				<li>
					<s:password name="password" placeholder="パスワード" /><br>
				</li>
				<!-- ログインのエラー -->
				<s:if test="%{#session.error.containsKey('login')}">
					<s:iterator value="%{#session.error.login}">
						<li>
							<s:property />
						</li>
					</s:iterator>
				</s:if>
				<!-- サブミットボタン -->
				<li>
					<s:submit value="ログイン" />
				</li>
			</ul>
		</s:form>
		<!-- 新規登録へのリンク -->
		<a href="SignupAction">
			新規登録
		</a>
	</body>
</html>