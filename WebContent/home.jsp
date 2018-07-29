<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title><s:property value="%{#session.user.name}"/> | WHISKER</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="main" class="cf">

		<div id="sub_column">
			<jsp:include page="profile.jsp" />
		</div>
		<!-- notImg  <i class="far fa-user-circle"></i> -->

		<div id="main_column">
			<jsp:include page="tweetField.jsp" />
			<jsp:include page="tweetView.jsp" />
		</div>

	</div>
	<%-- <jsp:include page="footer.jsp" /> --%>


</body>
</html>