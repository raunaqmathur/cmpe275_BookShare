<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form class="form-horizontal" id="login" action="login" method="post" commandName="logindetails">		
		<fieldset>
		
		<!-- Form Name -->
		<legend align="top">Sign In</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">User ID</label>  
		  <div class="col-md-4">
		  <input id="userId" name="userId" type="text" placeholder="Enter your User ID" class="form-control input-md">
		  <font color="red"><form:errors path="userId" required="true"></form:errors></font> 
		  <font color="red"><form:errors path="userId"></form:errors></font>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Password</label>  
		  <div class="col-md-4">
		  <input id="password" name="password" type="password" placeholder="type your password" class="form-control input-md">
		  <font color="red"><form:errors path="password"></form:errors></font>
		  <font color="red"><label>${msg}</label></font>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Sign In</button>
		  </div>
		</div>
		
		<div><font color="red"><form:errors /></font></div>
		
		</fieldset>
	</form>
</div>
</body>
</html>