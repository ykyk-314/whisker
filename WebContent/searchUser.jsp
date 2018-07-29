<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/accountList.css">

<title>searchUser</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="subTitle">ユーザー検索結果</div>

	<s:if test="%{#session.search.isEmpty()}">
		<br>
			検索結果はありません
		</s:if>

	<s:else>

		<ul class="listBox">
			<s:iterator value="#session.search">

				<li class="list"><a
					href="<s:url action='HomeAction'>
					<s:param name='userId' value='id'/></s:url>"
					class="users"> <s:property value="name" />
				</a></li>

			</s:iterator>
		</ul>
	</s:else>
</body>
</html>