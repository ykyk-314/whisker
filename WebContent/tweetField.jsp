<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="./css/tweet.css">

<div id="tweetField">

	<s:if test="%{#session.user.id == #session.profile.id}">
		<s:form action="TweetAction">
			<s:textarea name="message" class="text" placeholder="いま何してる？"/>
			<s:submit value="MEW!" class="submit_btn" />
		</s:form>

		<!-- エラーの表示 -->
		<s:if test="%{#session.error.contaionsKey('tweet')}">
			<s:iterator value="%{#session.error.tweet}">
				<s:property />
				<br>
			</s:iterator>
		</s:if>
	</s:if>
</div>