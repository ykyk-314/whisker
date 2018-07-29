<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.6/css/all.css">
<link rel="stylesheet" href="./css/header.css">

<header>
	<a href="HomeAction" id="Home"><img src="./images/whisker02.png"
		class="logo"></a>


	<ul class="iconBand">

		<li><s:form action="SearchUserAction" class="search">


				<s:textfield name="keyword" placeholder="キーワード" class="searchBox" />

				<input type="submit" value="&#xf002;" class="fas seach_btn" />
				<%-- <s:submit value="" class="seach_btn" /> --%>

			</s:form></li>



		<li><a href="FollowViewAction" class="link"><img
				src="./images/peopleB.png"></a></li>


		<li><a href="LogoutAction" class="link"><img
				src="./images/exit.png"></a></li>
	</ul>





	<!--


<a href="SearchUserAction" class="link"><img
						src="./images/search1.png" class="search"></a>


 -->







	<%-- <ul class="iconBand">

		<li><s:form action="SearchUserAction" class="search">
				<s:textfield name="keyword" placeholder="キーワード" class="searchBox" />

				<input type="submit" value="&#xf002;" class="fas seach_btn" />
				<s:submit value="&#xf002;" class="fas seach_btn" />

			</s:form></li>
		<li><a href="FollowViewAction" class="link"><i
				class="fas fa-users follows"></i></a></li>
		<li>
			<!-- ログアウト --> <a href="LogoutAction" class="link"><i
				class="fas fa-sign-out-alt exit"></i></a>
		</li>
	</ul> --%>

</header>