<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="tweetView">


	<s:if test="%{#session.tweets.isEmpty()}">
		ツイートがありません
	</s:if>

	<ul>
		<s:iterator value="%{#session.tweets}">
			<li><div class="tw_name"><s:property value="%{name}"  /></div><!-- 投稿アカウント名 -->
				<div class="tw_con"><s:property value="%{content}" escape="false"/></div><!-- 投稿内容 -->
				<a
				href='<s:url action="LikeAction">
				<s:param name="tweetId" value="%{id}"/>
				</s:url>'class="like_icon">
					いいね
					</a>
				<span class="like_count"><s:property value="%{likeCount}" /></span><!-- like数 -->
			</li>
		</s:iterator>
	</ul>
</div>