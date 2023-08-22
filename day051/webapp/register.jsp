<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
let login_form = {
	init:function(){
		 $('#register_btn').click(()=>{
			 this.send();
		 });
		 $('#id').keyup(function(){
			 var txt_id = $(this).val();
			 if(txt_id.length <= 3){
				 $('#check_id').text('사용불가능합니다.');
                 return;
             }
			 
			 $.ajax({
                 url:'rest.bit?cmd=checkid',
                 data:{'id':txt_id},
                 success:function(result){
                     if(result == 0){
                         $('#check_id').text('사용가능합니다.');
                         $('#pwd').focus();
                     }else{
                         $('#check_id').text('사용불가능합니다.');
                     }
                 }
             });
		 });

	},
	send:function(){
		var id = $('#id').val();
        var pwd = $('#pwd').val();
        var name = $('#name').val();
        if(id.length <= 3){
            $('#check_id').text('4자리 이상이어야 합니다.');
            $('#id').focus();
            return;
        }

        if(pwd == ''){
            $('#pwd').focus();
            return;
        }
        if(name == ''){
            $('#name').focus();
            return;
        }

        $('#register_form').attr({
            'action':'main.bit?cmd=loginimpl',
            'method':'post'
        });
        $('#register_form').submit();
	},
	
		
};



$(function(){
	login_form.init();
})
</script>

<div class="container" style="margin-top:30px">
  <div class="row">
   
    <div class="col-sm-12">
      <h2>Register</h2>
      	<form id="register_form">
		  <div class="form-group">
		    <label for="id">ID:</label>
		    <input type="text" class="form-control" placeholder="Enter id" name="id" id="id">
		    <span id="check_id"></span>
		  </div>
		  <div class="form-group">
		    <label for="pwd">Password:</label>
		    <input type="password" class="form-control" placeholder="Enter password" name="pwd"  id="pwd">
		  </div>
		  <div class="form-group">
		    <label for="name">Name:</label>
		    <input type="text" class="form-control" placeholder="Enter id" name="name" id="name">
		  </div>
		  <button type="button" id="register_btn" class="btn btn-primary">Submit</button>
		</form>
    </div>
   
  </div>
</div>