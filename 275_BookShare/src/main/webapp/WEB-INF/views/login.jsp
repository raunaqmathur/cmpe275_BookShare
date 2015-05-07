<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>

<body>

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
		  	<li><a href="${pageContext.request.contextPath}/signup">Register</a></li>
		</div>
		
		<div><font color="red"><form:errors /></font></div>
		
		</fieldset>
	</form>
</div>
</body>
</html>