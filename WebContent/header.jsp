<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.6/css/all.css">
<link rel="stylesheet" href="./css/header.css">

<header>

	<div class="MENU">
		<%--
	<jsp:include page="backGround.jsp" /> --%>

		<div class="menuBand">
			<div class="menu">
				<ul class="logoLine">
					<li><img src="./images/cat.png" class="cat"> <a
						href="HomeAction"><img src="./images/whisker02.png" class="logo"></a></li>
				</ul>
				<ul class="iconLine">
					<li><s:form action="SearchUserAction">
							<s:textfield name="keyword" placeholder="キーワード" class="searchBox" />
							<input type="submit" value="&#xf002;" class="fas seach_btn" />

						</s:form></li>
					<li><a href="FollowViewAction" class="link"><img
							src="./images/peopleB.png"></a></li>
					<li><a href="LogoutAction" class="link"><img
							src="./images/exit.png"></a></li>
				</ul>

			</div>
		</div>
	</div>
	<%-- <s:submit value="" class="seach_btn" /> --%>

</header>