<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BookShare</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<!-- Custom styles for this template -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script>
	function checkCat()
	{
		if(document.getElementById("categoryX").value == '')
			document.getElementById("errorCat").value = "Category can't be left blank";
	}
	</script>
</head>

<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	  <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        <img style="max-width:50px; margin-top: -15px;" alt="Brand" src="http://blindlibrary.utah.gov/images/logoBook.gif">
	      </a>
	    </div>
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">BookShare</a>
	    </div>
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	      <li><a href="#">Advance Search</a></li>
	        <li><a href="#">Buy</a></li>
	        <li><a href="#">Sell</a></li>
	        <li><a href="userhome">Login/Register</a></li>
	      </ul>
	      
	      <form class="navbar-form navbar-right" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search by ISBN">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	      </form>
	      
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="container">
	<form class="form-horizontal" id="bookhome" action="${path}" method="post" commandName="bookdetails">
		<fieldset>
		
		<!-- Form Name -->
		<legend align="top">Enter Book Details</legend>
        
        <!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Title</label>  
		  <div class="col-md-4">
		  <input id="title" name="title" type="text" placeholder="Enter book title" class="form-control input-md">
		  <input id="bookId" name="bookId" type="hidden" value=0>
		  <input id="status" name="status" type="hidden">
		  <font color="red"><form:errors path="title"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Author</label>  
		  <div class="col-md-4">
		  <input id="author" name="author" type="text" placeholder="Enter book author" class="form-control input-md">
		  <font color="red"><form:errors path="author"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">ISBN</label>  
		  <div class="col-md-4">
		  <input id="isbn" name="isbn" type="text" placeholder="Enter book ISBN" class="form-control input-md">
		  <font color="red"><form:errors path="isbn"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Description</label>  
		  <div class="col-md-4">
		  <input id="description" name="description" type="text" placeholder="Enter book description" class="form-control input-md">
		  <font color="red"><form:errors path="description"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Picture</label>  
		  <div class="col-md-4">
		  <input id="pictureId" name="pictureId" type="text" placeholder="Enter book image url" class="form-control input-md">
		  <font color="red"><form:errors path="pictureId"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Price</label>  
		  <div class="col-md-4">
		  <input id="price" name="price" type="text" placeholder="Enter book price" class="form-control input-md">
		  <font color="red"><form:errors path="price"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Condition</label>  
		  <div class="col-md-4">
		  <input id="condition" name="condition" type="text" placeholder="Enter book condition" class="form-control input-md">
		  <font color="red"><form:errors path="condition"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Keywords</label>  
		  <div class="col-md-4">
		  <input id="keywords" name="keywords" type="text" placeholder="Enter book keywords" class="form-control input-md">
		  <font color="red"><form:errors path="keywords"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Category</label>  
		  <div class="col-md-4">
		  <input id="categoryX" name="categoryX" type="text" placeholder="Enter book category" value="${categ}" class="form-control input-md">
		  <font color="red"><label id="errorCat"></label></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Pickup Address</label>  
		  <div class="col-md-4">
		  <input id="pickupAddress" name="pickupAddress" type="text" placeholder="Enter pickup address" class="form-control input-md">
		  <font color="red"><form:errors path="pickupAddress"></form:errors></font>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit" value="${buttonX} onClick="javascript: checkCat();">Submit</button>
		  </div>
		</div>
		
		<div><font color="red"><form:errors /></font></div>
		</fieldset>
	</form>
</div>
</body>
</html>