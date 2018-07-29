<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header>

	<a href="HomeAction" id="Home"><img src="./images/whisker02.png" class="logo"></a>

	<ul>
		<li>
			<a href="FollowViewAction" class="link_btn">フォロー</a>
		</li>

		<li>
			<s:form action="SearchUserAction">
				<s:textfield name="keyword" placeholder="キーワード" />
				<s:submit value="検索" />
			</s:form>
			<!-- <i class="fas fa-search"></i> -->
		</li>

		<li><!-- ログアウト -->
			<a href="LogoutAction" class="link_btn"><i class="fas fa-sign-out-alt door"></i></a>
		</li>
	</ul>

</header>