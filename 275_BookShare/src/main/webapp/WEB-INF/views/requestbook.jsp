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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
      <ul class="nav navbar-nav">
      </ul>
      
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
	<form class="form-horizontal" id="requestbook" action="requestbook" method="post" commandName="requestbookdetails">
		<fieldset>
		
		<!-- Form Name -->
		<legend align="top">Enter your request</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Request</label>  
		  <div class="col-md-4">
		  <input id="message" name="message" type="text" placeholder="type your message" class="form-control input-md">
		  <font color="red"><form:errors path="message"></form:errors></font> 
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
		  </div>
		</div>
		
		<div><font color="red"><form:errors /></font></div>
		
		</fieldset>
		
		</form>
   </div>
</body>
</html>