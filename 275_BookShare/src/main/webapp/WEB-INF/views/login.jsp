<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>

<body>

<div class="container-fluid">
	<form class="form-horizontal col-md-offset-4 col-md-4" id="login" action="login" method="post" commandName="logindetails">		
		<div class="panel panel-primary">
			<div class="panel-heading">Log In</div>
			
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px" action="login" method="post" commandName="logindetails">
			  <label class="col-md-3 control-label" for="textinput">User Email</label>  
			  <div class="col-md-8">
				  <input id="userEmail" name="userEmail" type="text" placeholder="Enter your User Email" class="form-control input-md" required=true>
				  <font color="red"><form:errors path="userEmail" required="true"></form:errors></font> 
				  <font color="red"><form:errors path="userEmail"></form:errors></font>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-3 control-label" for="textinput">Password</label>  
			  <div class="col-md-8">
				  <input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md" required=true>
				  <font color="red"><form:errors path="password"></form:errors></font>
				  <font color="red"><label>${msg}</label></font>
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-3 control-label" for="singlebutton"></label>
			  <div class="col-md-8">
			    <button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Sign In</button>
			  </div>
			  <div><font color="red"><form:errors /></font></div>
			</div>
				
			<div class="form-group">
			  <label class="col-md-offset-3 col-md-5" for="singlebutton">New to BookShare?</label>
			  
			  <div class="col-md-offset-3 col-md-8">
			    <a href="${pageContext.request.contextPath}/signup" id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Register</a>
			  </div>
			</div>
			
		</div>
	</div>
	</form>
</div>
</body>
</html>