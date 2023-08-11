<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
*{
	margin:0; 
	padding:0;
}
a{
	text-decoration: none;
	color:black;
}
ul,li{
	list-style: none;
}

header{
	width:800px;
	height:150px;
	background:cyan;
	margin:0 auto;
}
#navi{
	width:800px;
	height:30px;
	background:yellow;
	margin:0 auto;
}
section{
	width:800px;
	height:400px;
	background:gray;
	margin:0 auto;
}
footer{
	width:800px;
	height:30px;
	background:black;
	margin:0 auto;
}

ul > li {
	float:left;
	padding:0 10px;
}
#bottom_nav{
	padding:100px 0;
}
#bottom_nav  a{
	font-size: 1.5em;
	font-weight: bold;
}
#main_center{
	width:760px;
	height:360px;
	background:white;
	margin:0 auto;
}
</style>
<script>

</script>
</head>
<body>
<header>
	<nav id="top_nav">
	
		<c:choose>
			<c:when test="${login_cust == null }">
				<ul>
				<li><a href="main.bit?view=login">LOGIN</a></li>
				<li><a href="main.bit?view=register">REGISTER</a></li>
				<li><a href="">ABOUT US</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
				<li>${login_cust.id }</li>
				<li><a href="login.bit">LOGOUT</a></li>
				<li><a href="">ABOUT US</a></li>
				</ul>			
			</c:otherwise>
		</c:choose>
	
		
	</nav>
	<nav id="bottom_nav">
		<ul>
			<li><a href="cust.bit?view=register">CUST ADD</a></li>
			<li><a href="cust.bit?view=getall">CUST LIST</a></li>
			<li><a href="main.bit?view=register">PRODUCT ADD</a></li>
			<li><a href="product.bit?cmd=getall">PRODUCT LIST</a></li>
		</ul>
	</nav>
</header>
<nav id="navi">
	<c:choose>
		<c:when test="${navi != null }">
			${navi }
		</c:when>
		<c:otherwise>
			<a href="main.bit">HOME</a>
		</c:otherwise>
	</c:choose>
</nav>
<section>
	<c:choose>
		<c:when test="${center != null }">
			<jsp:include page="${center }.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="center.jsp"/>
		</c:otherwise>
	</c:choose>
</section>
<footer></footer>
</body>
</html>






