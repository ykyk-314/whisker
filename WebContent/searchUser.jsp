<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>search user</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	ユーザー検索結果

	<ul>
		<s:iterator value="#session.search">

			<li><a
				href="<s:url action='HomeAction'>
					<s:param name='userId' value='id'/></s:url>">
					<s:property value="name" />
				</a>
			</li>

		</s:iterator>
	</ul>

</body>
</html>