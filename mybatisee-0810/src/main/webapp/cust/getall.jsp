<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="main_center">
<h1>Cust Select</h1>

<table id="tab_1">
<thead><tr><th>ID</th><th>NAME</th></tr></thead>
<tbody>
<c:forEach var="c" items="${clist }">
	<tr>
		<td><a href="cust.bit?view=get&id=${c.id }">${c.id }</a></td>  
		<td>${c.name }</td>
	</tr>
</c:forEach>
</tbody>
</table>

</div>




