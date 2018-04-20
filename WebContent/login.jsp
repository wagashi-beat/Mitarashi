<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags" %>
<!DOCTYPE>

<html>
<head>
	<meta charset= "UTF-8">
	<title>ログイン</title>
</head>

<body>
	（o・▽・o）

	<s:form action= "LoginAction">

	<input type= "text" name= "userId" value= "" placeholder= "ユーザーID" />
	<input type= "password" name= "password" value= "" placeholder= "パスワード" />

	<input type= "checkbox" name= "loginMemory" value= "1" />

	<input type= "submit" name= "submit" value= "enter" />

	</s:form>
</body>
</html>