<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags" %>
<!DOCTYPE>

<html>
<head>
	<meta charset= "UTF-8">
	<title>ユーザー新規登録確認</title>


<style type="text/css">
	p.error {
	color: red;
	}

</style>

</head>

<body>
	新規登録確認画面だよー（o・▽・o）

	<s:form action= "UserCreateConfirmAction">
	<table>
		<tr>
			<th>ユーザーID：</th>
			<td><s:property value= "session.userId" /></td>
		</tr>

		<tr>
			<th>パスワード：</th>
			<td><s:property value= "session.password" /></td>
		</tr>

		<tr>
			<th>メールアドレス：</th>
			<td><s:property value= "session.email" /></td>
		</tr>

		<tr>
			<th>姓：</th>
			<td><s:property value= "session.familyName" /></td>
		</tr>

		<tr>
			<th>名：</th>
			<td><s:property value= "session.firstName" /></td>
		</tr>

		<tr>
			<th>せい：</th>
			<td><s:property value= "session.familyNameKana" /></td>
		</tr>

		<tr>
			<th>めい：</th>
			<td><s:property value= "session.firstNameKana" /></td>
		</tr>

		<tr>
			<th>性別：</th>
			<td><s:if test= "session.sex == 0">男性</s:if>
				<s:if test= "session.sex == 1">女性</s:if></td>
		</tr>

		<tr>
			<th>生年月日：</th>
			<td><s:property value= "session.year" />年<s:property value= "session.month" />月<s:property value= "session.day" />日</td>
		</tr>

		<tr>
			<th>電話番号：</th>
			<td><s:property value= "session.telNumber" /></td>
		</tr>

		<tr>
			<th>郵便番号：</th>
			<td><s:property value= "session.postNumber" /></td>
		</tr>

		<tr>
			<th>住所：</th>
			<td><s:property value= "session.address" /></td>
		</tr>

		<tr>
			<th></th><td><input type= "submit" id= "complete" value="完了" onClick= "alert('ユーザー登録が完了したよ～（o・▽・o）')"  /></td><td><input type="button" value="修正" onclick="history.back()"></tr>
	</table>

	</s:form>


	<script type= "text/javascript">
		$("#complete").click(function() {
			location.href= "login.jsp";
		});

		</script>

</body>
</html>