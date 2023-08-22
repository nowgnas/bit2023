<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script>
let cust_detail_form = {
	init:function(){
		 $('#cust_modify_btn').click(()=>{
			 $('#cust_detail_form').attr({
		            'action':'cust.bit?cmd=modifyimpl',
		            'method':'post'
		     });
		     $('#cust_detail_form').submit();
		 });
		 $('#cust_remove_btn').click(()=>{
			 var id = '${dcust.id}';
			 location.href='cust.bit?cmd=removeimpl&id='+id;
		 });
	}	
};



$(function(){
	cust_detail_form.init();
})
</script>

<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Cust Get</h2>
      	<form id="cust_detail_form">
		  <div class="form-group">
		    <label for="id">ID:</label>
		    <input type="text" class="form-control" placeholder="Enter id" name="id" id="id" value="${dcust.id}">
		  </div>
		  <div class="form-group">
		    <label for="pwd">Password:</label>
		    <input type="password" class="form-control" placeholder="Enter password" name="pwd"  id="pwd" value="${dcust.pwd}">
		  </div>
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" class="form-control" placeholder="Enter id" name="name" id="name" value="${dcust.name}">
		  </div>
		  <button type="button" id="cust_modify_btn" class="btn btn-primary">Modify</button>
		  <button type="button" id="cust_remove_btn" class="btn btn-primary">Remove</button>
		
		</form>
    </div>
   
  </div>
</div>



