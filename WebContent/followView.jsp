<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/accountList.css">
<title>followView</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="subTitle">FOLLOW LIST</div>

	<s:if test="%{#session.follows.isEmpty()}">
		<br>
			フォローしている人がいません
		</s:if>
	<s:else>

		<ul class="listBox">
			<s:iterator value="#session.follows">
				<li class="list"><a
					href="<s:url action='HomeAction'>
				<s:param name="userId" value='id'/>
				</s:url>"
					class="users"><s:property value="name" /></a></li>
				<li class="kat"><a
					href="<s:url action='DefollowAction'>
				<s:param name='userId' value='id'/>
				</s:url>"
					class="defo"> フォロー<br>解除 </a></li>
			</s:iterator>
		</ul>
	</s:else>

</body>
</html>