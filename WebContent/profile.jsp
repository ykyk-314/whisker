<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="profile">

	<div class="myImage">
		<img src="<s:property value='%{#session.profile.photoPath}' />" />
	</div>
	<!-- プロフィール画像 -->


	<ul class="prof">

		<li class="contents"><s:property value="%{#session.profile.name}" /></li>
		<!-- アカウント名 -->
		<li class="contents"><s:property
				value="%{#session.profile.loginId}" /></li>
		<!-- ID -->
		<li class="contents"><s:property
				value="%{#session.profile.introductions}" /></li>
		<!-- 紹介文 -->
		<s:if test="%{!#session.isUser}">
			<!-- フォローしていれば -->
			<s:if test="%{#session.isFollowing}">
				<li class="follow"><a
					href='<s:url action="DefollowAction"><s:param name="userId" value="%{#session.profile.id}"/></s:url>'>
						フォロー解除 </a></li>
			</s:if>
			<s:else>
				<li class="follow"><a
					href='<s:url action="FollowAction"><s:param name="userId" value="%{#session.profile.id}"/></s:url>'>
						フォローする </a></li>
			</s:else>
		</s:if>
		<!-- ログインユーザーなら -->
		<s:if test="%{#session.isUser}">
			<li class="edit"><a href="GoProfileEditAction" class="link_btn">プロフィール編集</a></li>
		</s:if>
	</ul>
</div>