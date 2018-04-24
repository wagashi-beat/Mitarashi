<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags" %>
<!DOCTYPE>

<html>
<head>
	<meta charset= "UTF-8">
	<title>ログイン</title>


<style type="text/css">
	p.error {
	color: red;
	}

</style>

</head>

<body>
	ログ（o・▽・o）イン（o・▽・o）だよー（o・▽・o）

	<s:form action= "LoginAction">

	<!-- 未入力エラー -->
	<p class= "error">
	<s:if test= '#session.errorLog != "" '>
		<s:property value= "session.errorLog" />
	</s:if>
	</p>

	<!-- IDに関するエラー -->
	<p class= "error">
	<s:if test= "errorLogIdList != null">
		<s:iterator value= "errorLogIdList">
			<s:property value= "errorLogId" />
		</s:iterator>
	</s:if>
	</p>

	<!-- ユーザーID入力フォーム -->
	<input type= "text" name= "userId" value= '<s:property value= "#session.loginMemoryId" />'  placeholder= "ユーザーID" />


	<!-- パスワードに関するエラー -->
	<p class= "error">
	<s:if test= "errorLogPassList != null">
		<s:iterator value= "errorLogPassList">
			<s:property value= "errorLogPass" />
		</s:iterator>
	</s:if>
	</p>

	<!-- パスワード入力フォーム -->
	<input type= "password" name= "password" value= "" placeholder= "パスワード" /><br>


	<!-- ID保存チェックボックス -->
	<input type= "checkbox" name= "loginMemory" value= "1" /> ログインIDを保存


	<!-- サブミットボタン -->
	<input type= "submit" name= "submit" value= "enter" />



	</s:form>
</body>
</html>