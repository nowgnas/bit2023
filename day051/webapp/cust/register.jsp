<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script>
let cust_register_form = {
	init:function(){
		 $('#cust_register_btn').click(()=>{
			 this.send();
		 });
	},
	send:function(){
        $('#cust_register_form').attr({
            'action':'cust.bit?cmd=registerimpl',
            'method':'post'
        });
        $('#cust_register_form').submit();
	},
	
		
};



$(function(){
	cust_register_form.init();
})
</script>

<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Cust Register</h2>
      	<form id="cust_register_form">
		  <div class="form-group">
		    <label for="id">ID:</label>
		    <input type="text" class="form-control" placeholder="Enter id" name="id" id="id">
		  </div>
		  <div class="form-group">
		    <label for="pwd">Password:</label>
		    <input type="password" class="form-control" placeholder="Enter password" name="pwd"  id="pwd">
		  </div>
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" class="form-control" placeholder="Enter id" name="name" id="name">
		  </div>
		  <button type="submit" id="cust_register_btn" class="btn btn-primary">Register</button>
		</form>
    </div>
   
  </div>
</div>



