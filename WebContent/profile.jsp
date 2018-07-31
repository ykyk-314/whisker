<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="./css/profile.css">
<div id="profile">

	<h2>&Xi;&emsp;PROFILE&emsp;&Xi;</h2>

	<!-- プロフィール画像 -->
	<img src="<s:property value='%{#session.profile.photoPath}' />" />


	<ul>
		<!-- ID -->
		<li class="acId">@<s:property value="%{#session.profile.loginId}" /></li>

		<!-- アカウント名 -->
		<li class="acName"><a
			href='<s:url action="HomeAction">
			<s:param name="userId" value="%{#session.profile.id}"/></s:url>'>
				<s:property value="%{#session.profile.name}" />
		</a></li>

		<!-- 紹介文 -->
		<li class="acIntro"><s:property value="%{#session.profile.escapeIntroductions}" escape="false" /></li>

	</ul>


	<s:if test="%{!#session.isUser}">
		<!-- フォローしていれば -->
		<s:if test="%{#session.isFollowing}">

			<div class="De follow">
				<a
					href='<s:url action="DefollowAction"><s:param name="userId" value="%{#session.profile.id}"/></s:url>'>
					フォロー解除 </a>
			</div>
		</s:if>
		<s:else>
			<div class="follow">
				<a
					href='<s:url action="FollowAction"><s:param name="userId" value="%{#session.profile.id}"/></s:url>'>
					フォローする </a>
			</div>
		</s:else>
	</s:if>
	<!-- ログインユーザーなら -->
	<s:if test="%{#session.isUser}">
		<div class="edit">
			<a href="GoProfileEditAction">編集</a>
		</div>
	</s:if>

</div>