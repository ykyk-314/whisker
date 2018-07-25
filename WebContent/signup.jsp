<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>twitter demo</title>
	</head>
	<body>
		<h1>新規登録</h1>
		<s:form action="SignupConfirmAction">
			<ul>
				<!-- ID -->
				<li>
					<dl>
						<dt>
							<s:textfield name="loginId" placeholder="ID" value="%{#session.signupDto.loginId}" />
						</dt>
						<!-- エラー表示 -->
						<s:if test="%{#session.error.containsKey('loginId')}">
							<s:iterator value="%{#session.error.loginId}">
								<dd>
									<s:property />
								</dd>
							</s:iterator>
						</s:if>
					</dl>
				</li>
				<!-- パスワード -->
				<li>
					<dl>
						<dt>
							<s:textfield name="password" placeholder="パスワード" value="%{#session.signupDto.password}" />
						</dt>
						<!-- エラー表示 -->
						<s:if test="%{#session.error.containsKey('password')}">
							<s:iterator value="%{#session.error.password}">
								<dd>
									<s:property />
								</dd>
							</s:iterator>
						</s:if>
					</dl>
				</li>
				<!-- 表示名 -->
				<li>
					<dl>
						<dt>
							<s:textfield name="name" placeholder="表示名" value="%{#session.signupDto.name}" />
						</dt>
						<!-- エラー表示 -->
						<s:if test="%{#session.error.containsKey('name')}">
							<s:iterator value="%{#session.error.name}">
								<dd>
									<s:property />
								</dd>
							</s:iterator>
						</s:if>
					</dl>
				</li>
				<!-- サブミットボタン -->
				<li>
					<s:submit value="確認" />
				</li>
			</ul>
		</s:form>
	</body>
</html>