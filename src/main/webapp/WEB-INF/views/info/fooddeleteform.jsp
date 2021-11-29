<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<s:authentication property="principal" var="user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<%@ include file="/resources/include/headTag.jsp"%>
<link defer rel='stylesheet' media='screen' href='/css/info/fooddelete.css'>
</head>
<body>
<!-- navbar -->
<%@ include file="/resources/include/navbar.jsp"%>

<!-- center -->
<div class="fooddelete_center">

    <div class="side"> 
			<table id="side_menu" class="table table-hover">
		 <thead>
		   <tr><th>여행정보</th></tr>
		 </thead>
		 <tbody>
		   <tr><td><a href="#">숙소</a></td></tr>
		   <tr><td><a href="/foodlist.do">맛집</a></td></tr>
		   <tr><td><a href="#">여행지</a></td></tr>
		 </tbody>
	 </table>
	</div>
	

<form method=post action="fooddelete.do">
	<input type="hidden" name="food_no" value="${param.food_no}">
	<input type="hidden" name="pageNum" value="${param.pageNum}">
	
	<table id="f_del_table" class="table table-striped" width=400 align=center>
	<h2>맛집 글삭제</h2>
	<p>The .table-hover class enables a hover state (grey background on mouse over) on table rows:</p>
	<thead>
	<tr><th>글을 삭제하시겠습니까?</th></tr>
	</thead>
	<tr><td colspan=2 align=center>
			<input type=submit value="삭제">
		</td>
	</tr>
</table>
</form>

</div>

<!-- footer -->
<%@ include file="/resources/include/footerbar.jsp"%>

</body>
</html>