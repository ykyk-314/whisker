<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/profile.css">

<title>profileEdit</title>

</head>
<body>

	<jsp:include page="header.jsp" />


	<s:form action="ProfileEditAction" method="post"
		enctype="multipart/form-data" id="profileEdit">

		<div class="editBox">

			<p class="subTitle">プロフィールを編集</p>

			<!-- プロフィール画像 -->
			<img class="currentImg" src="<s:property value='%{#session.profile.photoPath}' />" /> <br>
			<s:file name="photo" accept="image/png" />
			<br>
			<s:if test="%{#session.error.containsKey('photo')}">
				<s:iterator value="%{#session.error.photo}">
					<s:property />
					<br>
				</s:iterator>
			</s:if>

			<!-- 表示名 -->
			<s:textfield name="name" value="%{#session.user.name}" class="text"/>
			<br>
			<s:if test="%{#session.error.containsKey('name')}">
				<s:iterator value="%{#session.error.name}">
					<s:property />
					<br>
				</s:iterator>
			</s:if>

			<!-- 紹介文 -->
			<s:textarea name="introductions"
				value="%{#session.user.introductions}" class="text"/>
			<br>
			<s:if test="%{#session.error.containsKey('introductions')}">
				<s:iterator value="%{#session.error.introductions}">
					<s:property />
					<br>
				</s:iterator>
			</s:if>

			<!-- submit -->
			<s:submit value="更新" class="update_btn"/>
			<br>
		</div>
	</s:form>

</body>
</html>