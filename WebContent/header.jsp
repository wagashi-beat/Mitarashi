<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type= "text/css" href= "./css/index.css">
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
				<s:select listKey = "categoryId" listValue = "categoryName" list="dropList">
					<option value="0" selected="selected">すべてのカテゴリ</option>
				</s:select>

				<input id="search_button" type="submit" name="submit" value="登録">
				</s:form>
			</div>
		</div>

		<div class="headerB">
		</div>
	</header>
</body>
</html>
