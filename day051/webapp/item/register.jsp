<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script>
let item_register_form = {
	init:function(){
		 $('#item_register_btn').click(()=>{
			 this.send();
		 });
	},
	send:function(){
        $('#item_register_form').attr({
            'action':'item.bit?cmd=registerimpl',
            'method':'post',
            'enctype':'multipart/form-data'
        });
        $('#item_register_form').submit();
	},
	
		
};



$(function(){
	item_register_form.init();
})
</script>

<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Item Register</h2>
      	<form id="item_register_form">
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" class="form-control" placeholder="Enter name" name="name" id="name">
		  </div>
		  <div class="form-group">
		    <label for="price">Price:</label>
		    <input type="number" class="form-control" placeholder="Enter price" name="price"  id="price">
		  </div>
		  <div class="form-group">
		    <label for="img">Img:</label>
		    <input type="file" class="form-control" placeholder="Enter img" name="img" id="img">
		  </div>
		  <button type="submit" id="item_register_btn" class="btn btn-primary">Register</button>
		</form>
    </div>
   
  </div>
</div>




