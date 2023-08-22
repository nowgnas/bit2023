<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#item_img{
	width:150px;
}
</style>
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
      <h2>Item GetAll</h2>
      	<table class="table table-hover">
		    <thead>
		      <tr>
		        <th>IMG</th>
		        <th>ID</th>
		        <th>NAME</th>
		        <th>PRICE</th>
		        <th>REGDATE</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="i" items="${ilist}">
			      <tr>
			        <td><img id="item_img" src="img/${i.imgname}"></td>
			        <td><a href="item.bit?cmd=get&id=${i.id}">${i.id}</a></td>
			        <td>${i.name}</td>
			        <td><fmt:formatNumber value="${i.price}" type="currency" /> </td>
        		    <td><fmt:formatDate  value="${i.regdate}" pattern="yyyy-MM-dd" /></td>
			      </tr>
		      </c:forEach>
		    </tbody>	
	    </table>										
    </div>
   
  </div>
</div>



