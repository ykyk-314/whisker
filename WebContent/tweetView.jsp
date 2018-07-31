<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="./css/tweet.css">

<div id="tweetView">


	<s:if test="%{#session.tweets.isEmpty()}">
		ツイートがありません
	</s:if>

	<ul>
		<s:iterator value="%{#session.tweets}">

			<!-- "<s:property value='%{#session.profile.photoPath}' />"  -->

			<div class="tw_name">
				<s:property value="%{name}" />
			</div>
			<!-- 投稿アカウント名 -->

			<li class="viewBox">

				<div class="tw_con">
					<s:property value="%{escapeContent}" escape="false"/><br>
				</div> <!-- 投稿内容 -->
				<div class="tw_space"></div>
				<div class="tw_like">

					<div class="like_count">
						<s:property value="%{likeCount}" />
					</div>

					<a
						href='<s:url action="LikeAction">
				<s:param name="tweetId" value="%{id}"/>
				</s:url>'
						class="like_icon"><img src="./images/meatball.png"></a>
				</div> <!-- likeボタン/like数 -->
			</li>
			<div class="tw_clear"></div>
		</s:iterator>
	</ul>
</div>