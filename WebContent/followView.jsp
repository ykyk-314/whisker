<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/style.css">
<title>followView</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	フォロー一覧

	<ul>
		<s:iterator value="#session.follows">
			<li><a
				href=
				"<s:url action='HomeAction'>
				<s:param name="userId" value='id'/>
				</s:url>"><s:property
						value="name" /></a> &nbsp;
				<a
				href=
				"<s:url action='DefollowAction'>
				<s:param name='userId' value='id'/>
				</s:url>">
				フォロー解除
				</a>
			</li>
		</s:iterator>
	</ul>

</body>
</html>