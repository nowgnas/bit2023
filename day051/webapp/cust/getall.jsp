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
	cust_login_form.init();
})
</script>

<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Cust GetAll</h2>
      	<table class="table table-hover">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>PWD</th>
		        <th>NAME</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:forEach var="c" items="${clist}">
		      <tr>
		        <td><a href="cust.bit?cmd=get&id=${c.id }">${c.id }</a></td>
		        <td>${c.pwd }</td>
		        <td>${c.name }</td>
		      </tr>
		    </c:forEach>
		    </tbody>	
	    </table>										
    </div>
   
  </div>
</div>



