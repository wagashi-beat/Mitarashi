<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags" %>
<!DOCTYPE>

<html>
<head>
	<meta charset= "UTF-8">
	<title>ユーザー新規登録</title>


<style type="text/css">
	p.error {
	color: red;
	}

</style>

</head>

<body>
	新規登録するよー（o・▽・o）

	<s:if test= "errorUserId">
		<s:iterator value= "errorUserIdList">
			<s:property value= "errorUserId" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserPass">
		<s:iterator value= "errorUserPassList">
			<s:property value= "errorUserPass" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserMail">
		<s:iterator value= "errorUserMailList">
			<s:property value= "errorUserMail" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserFam">
		<s:iterator value= "errorUserFamList">
			<s:property value= "errorUserFam" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserFir">
		<s:iterator value= "errorUserFirList">
			<s:property value= "errorUserFir" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserFamKana">
		<s:iterator value= "errorUserFamKanaList">
			<s:property value= "errorUserFamKana" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserFirKana">
		<s:iterator value= "errorUserFirKanaList">
			<s:property value= "errorUserFirKana" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserSex">
		<s:iterator value= "errorUserSexList">
			<s:property value= "errorUserSex" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserTel">
		<s:iterator value= "errorUserTelList">
			<s:property value= "errorUserTel" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserBirth">
		<s:iterator value= "errorUserBirthList">
			<s:property value= "errorUserBirth" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserPost">
		<s:iterator value= "errorUserPostList">
			<s:property value= "errorUserPost" />
		</s:iterator>
	</s:if>

		<s:if test= "errorUserAddress">
		<s:iterator value= "errorUserAddressList">
			<s:property value= "errorUserAddress" />
		</s:iterator>
	</s:if>

	<s:if test= "session.errorUser != null">
		<s:property value= "session.errorUser" />
		</s:if>


	<table>
	<s:form action= "UserCreateAction">
		<tr>
			<th>ユーザーID：</th>
			<td><input type= "text" name= "userId" <s:if test= "session != null">value= '<s:property value= "userId" />' </s:if> placeholder= "taro" /></td>
		</tr>

		<tr>
			<th>パスワード：</th>
			<td><input type= "password" name= "password" /></td>
		</tr>

		<tr>
			<th>メールアドレス：</th>
			<td><input type= "text" name= "email" <s:if test= "session != null">value= '<s:property value= "email" />' </s:if> placeholder= "taro@yahoo.co.jp" /></td>
		</tr>

		<tr>
			<th>姓：</th>
			<td><input type= "text" name= "familyName" <s:if test= "session != null">value= '<s:property value= "familyName" />'</s:if> placeholder= "山田" /></td>
		</tr>

		<tr>
			<th>名：</th>
			<td><input type= "text" name= "firstName" <s:if test= "session != null">value= '<s:property value= "firstName" />'</s:if> placeholder= "太郎" /></td>
		</tr>

		<tr>
			<th>せい：</th>
			<td><input type= "text" name= "familyNameKana" <s:if test= "session != null">value= '<s:property value= "familyNameKana" />'</s:if> placeholder= "やまだ" /></td>
		</tr>

		<tr>
			<th>めい：</th>
			<td><input type= "text" name= "firstNameKana" <s:if test= "session != null">value= '<s:property value= "firstNameKana" />'</s:if> placeholder= "たろう" /></td>
		</tr>

		<tr>
			<th>性別：</th>
			<td><s:if test= "session != null">
				<input type= "radio" name= "sex" value= "0" <s:if test= "sex == 0">checked= "checked"</s:if> />男性
				<input type= "radio" name= "sex" value= "1" <s:if test= "sex == 1">checked= "checked"</s:if> />女性</s:if>

				<s:if test= "session == null">
				<input type= "radio" name= "sex" value= "0" checked= "checked" />男性
				<input type= "radio" name= "sex" value= "1" />女性</s:if></td>
		</tr>

		<tr>
			<th>生年月日：</th>
			<td><input type= "text" name= "year" <s:if test= "session != null">value= '<s:property value= "year" />' </s:if> />年
				<input type= "text" name= "month" <s:if test= "session != null">value= '<s:property value= "month" />'</s:if> />月
				<input type= "text" name= "day" <s:if test= "session != null">value= '<s:property value= "day" />'</s:if> />日</td>
		</tr>

		<tr>
			<th>電話番号：</th>
			<td><input type= "text" name= "telNumber" <s:if test= "session != null">value= '<s:property value= "telNumber" />'</s:if> placeholder= "08000000000" /></td>
		</tr>

		<tr>
			<th>郵便番号：</th>
			<td><input type= "text" name= "postNumber" <s:if test= "session != null">value= '<s:property value= "postNumber" />'</s:if> placeholder= "1110000" /></td>
		</tr>

		<tr>
			<th>住所：</th>
			<td><input type= "text" name= "address" <s:if test= "session != null">value= '<s:property value= "address" />'</s:if> placeholder= "東京都品川区西五反田0-0-0" /></td>
		</tr>

		<tr>
			<th></th><td><s:submit value= "登録" /></td>
		</tr>

	</s:form>
	</table>



</body>
</html>