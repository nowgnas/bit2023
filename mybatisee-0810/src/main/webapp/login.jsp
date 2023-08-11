<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$('#login_form > input[type="button"]').click(function(){
		var id = $('input[name="id"]').val();
		var pwd = $('input[name="pwd"]').val();
		if(id == null || id == ''){
			alert('Madatory Filed !');
			$('input[name="id"]').focus();
			return;
		}
		if(pwd == null || pwd == ''){
			alert('Madatory Filed !');
			$('input[name="pwd"]').focus();
			return;
		}
		$('#login_form').attr('method','post');
		$('#login_form').attr('action','login.mc');
		$('#login_form').submit();		
	
	});
});
</script>

<div id="main_center">
<h1>Login Page</h1>
<form id="login_form">
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<input type="button" value="LOGIN">
</form>
</div>





