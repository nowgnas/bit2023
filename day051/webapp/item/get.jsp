<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#detail_item_img{
	width:300px;
}
</style>
<script>
let item_detail_form = {
	init:function(){
		$('#item_modify_btn').click(()=>{
			 $('#item_detail_form').attr({
		            'action':'item.bit?cmd=modifyimpl',
		            'method':'post',
		            'enctype':'multipart/form-data'
		     });
		     $('#item_detail_form').submit();
		});
		$('#item_remove_btn').click(()=>{
		     var id = '${ditem.id}';
			 location.href='item.bit?cmd=removeimpl&id='+id;
		});
	}
		
};



$(function(){
	item_detail_form.init();
})
</script>

<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Item Get</h2>
      	<img id="detail_item_img" src="img/${ditem.imgname}">
      	<form id="item_detail_form">
      	  <div class="form-group">
		    <label for="id">Id:</label>
		    <input type="number" class="form-control" name="id" id="id" value="${ditem.id}" readonly="readonly">
		  </div>
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" class="form-control" name="name" id="name" value="${ditem.name}">
		  </div>
		  <div class="form-group">
		    <label for="price">Price:</label>
		    <input type="number" class="form-control" name="price"  id="price" value="${ditem.price}">
		  </div>
		  <div class="form-group">
		    <label for="regdate">RegDate:</label>
		    <input type="text" class="form-control" name="regdate"  id="regdate" readonly="readonly" value="<fmt:formatDate  value="${ditem.regdate}" pattern="yyyy-MM-dd" />" >
		  </div>
		  <div class="form-group">
		    <label for="img">Img:</label>
		    <input type="hidden"  name="imgname" value="${ditem.imgname}" >
		    <input type="file" class="form-control" placeholder="Enter img" name="img" id="img">
		  </div>
		  <button type="button" id="item_modify_btn" class="btn btn-primary">Modify</button>
		  <button type="button" id="item_remove_btn" class="btn btn-primary">Remove</button>
		
		</form>
    </div>
   
  </div>
</div>




