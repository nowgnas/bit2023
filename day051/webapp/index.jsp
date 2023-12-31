<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap 4 Website Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  
  
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cb8fe6776643b3a6ad18f3e2f14a93c2"></script>
  <script src="https://code.highcharts.com/highcharts.js"></script>
  <script src="https://code.highcharts.com/modules/exporting.js"></script>
  <script src="https://code.highcharts.com/modules/export-data.js"></script>
  <script src="https://code.highcharts.com/modules/accessibility.js"></script>
  
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
  <script>
  let index = {
    id:'',
    init:function(){
    	$('#send_btn').click(()=>{
    		location.href='item.bit?cmd=del&id='+this.id;
		});

    },
    mymodal:function(num){
  		this.id = num;
  		$('#myModal').modal();
		$('#modal_content').text(num);
  	}	
  };
  $(function(){
	  index.init();
  });
  </script>
</head>
<body>

 
<ul class="nav justify-content-end">

	<c:choose>
		<c:when test="${logincust == null }">
		    <li class="nav-item">
		      <a class="nav-link text-body" href="main.bit?cmd=login"  >LOGIN</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link text-body" href="main.bit?cmd=register">REGISTER</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link text-body" id="about"  href="javascript:index.mymodal(1);" >ABOUT US</a>
		      
		    </li>
		</c:when>
		<c:otherwise>
			<li class="nav-item text-body">
				<a class="nav-link text-body" href="#">${logincust.id }</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-body" href="main.bit?cmd=logout">LOGOUT</a>
			</li>
		</c:otherwise>
	</c:choose>
    
</ul>


<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>HTML5 & JSP</h1>
  
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="main.bit">HOME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="cust.bit?cmd=register">Add Cust</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cust.bit?cmd=getall">Get Cust</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="item.bit?cmd=register">Add Item</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="item.bit?cmd=getall">Get Item</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="main.bit?cmd=map">Map</a>
      </li>   
      <li class="nav-item ">
        <a class="nav-link" href="main.bit?cmd=chart">Chart</a>
      </li>     
      <li class="nav-item ">
        <a class="nav-link" href="item.bit?cmd=register">Upload</a>
      </li>     
    </ul>
  </div>  
</nav>

<c:choose>
		<c:when test="${center != null }">
			<jsp:include page="${center }.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="center.jsp"/>
		</c:otherwise>
</c:choose>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>



 <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <h3 id="modal_content">Modal body..</h3>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-danger" id="send_btn">Send</button>
        </div>
        
      </div>
    </div>
  </div>
  
</body>
</html>
    
    
    
