<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type= "text/css" href= "./css/index.css">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<title>header</title>
</head>
<body>
	<header>
		<div class="headerA">
			<div class="logo">
				<a href='<s:url action="GoHomeAction"/>'><img src="./img/logo.png" height="200px"></a>
			</div>
			<div class="searchBox">
				<s:form method="post" action="ItemSearchAction" class="search">
				<select name="category" id="select1">
									<option value="0" selected="selected">すべての和菓子</option>
									<option value="1">団子</option>
									<option value="2">餅</option>
									<option value="3">練りもの</option>
								</select>

								<input type="text" name="searchWord" placeholder="検索" maxlength="16" class="searchBox" />

								<input type="submit" alt="検索" value="検索" id="searchButton" >


				</s:form>
			</div>
		</div>

		<div class="headerB">
		</div>
	</header>
</body>
</html>
