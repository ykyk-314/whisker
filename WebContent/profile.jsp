<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<ul>
		<li><s:property value="%{#session.profile.loginId}" /></li>
		<li><s:property value="%{#session.profile.password}" /></li>
		<li><s:property value="%{#session.profile.name}" /></li>
		<li><s:property value="%{#session.profile.introductions}" /></li>
		<li><s:property value="%{#session.profile.logined}" /></li>
		<li><s:property value="%{#session.profile.createdAt}" /></li>
		<li><s:property value="%{#session.profile.updatedAt}" /></li>
	</ul>
</div>