<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags" %>
<!DOCTYPE>

<html>
<head>
	<meta charset= "UTF-8">
	<title>ホーム</title>
</head>

<body>
	<img src= "./img/mitarashi_dango.png">

	（o・<a href= '<s:url action= "GoLoginAction" />'>▽</a>・o）
	<s:if test= "session.loginFlg"><s:property value= "session.userId" />さんようこそー（o・▽・o）</s:if>

	</body>
</html>
