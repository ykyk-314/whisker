<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>twitter demo</title>
	</head>
	<body>
		Home

		<jsp:include page="header.jsp" />
		<jsp:include page="profile.jsp" />
		<jsp:include page="tweetField.jsp" />
		<jsp:include page="tweetView.jsp" />
		<%-- <jsp:include page="footer.jsp" /> --%>

	</body>
</html>