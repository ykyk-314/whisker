<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="tweetField">

	<s:if test="%{#session.user.id == #session.profile.id}">
		<s:form action="TweetAction">
			<s:textfield name="message" class="text" />
			<s:submit value="MEW" class="submit_btn" />
		</s:form>
	</s:if>
</div>