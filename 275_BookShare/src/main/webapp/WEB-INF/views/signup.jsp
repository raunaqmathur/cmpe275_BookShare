<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>

<body>

<div class="container-fluid">

	<form class="form-horizontal col-md-offset-4 col-md-4" id="userhome" action="signup" method="post" commandName="userdetails">
		<div class="panel panel-primary">
			<div class="panel-heading">Register</div>
			
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-3 control-label" for="textinput">Name</label> 
				<div class="col-md-8">
					<input id="name" name="name" type="text" placeholder="Enter your name" class="form-control input-md">
					<font color="red"><form:errors path="name" required="true"></form:errors></font> 
					<font color="red"><form:errors path="name"></form:errors></font>
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Age</label> 
				<div class="col-md-8">
					<input id="age" name="age" type="number" placeholder="Enter your age" class="form-control input-md">
					<font color="red"><form:errors path="age" ></form:errors></font> 
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Email</label> 
				<div class="col-md-8">
					<input id="emailId" name="emailId" type="email" placeholder="Enter your email" class="form-control input-md">
					<font color="red"><form:errors path="emailId" required="true"></form:errors></font> 
					<font color="red"><label>${msg}</label></font>
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-3 control-label" for="textinput">Phone</label> 
				<div class="col-md-8">
					<input id="phone" name="phone" type="number" placeholder="Enter your phone" class="form-control input-md">
					<font color="red"><form:errors path="phone" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-3 control-label" for="textinput">Address</label> 
				<div class="col-md-8">
					<input id="address" name="address" type="text" placeholder="Enter your address" class="form-control input-md">
					<font color="red"><form:errors path="address" ></form:errors></font> 
				</div>
			</div>
            
	        <!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Password</label> 
				<div class="col-md-8">
					<input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md">
					<font color="red"><form:errors path="password" ></form:errors></font> 
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label" for="singlebutton"></label>
				<div class="col-md-8">
					<button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Register</button>
					<div><font color="red"><form:errors /></font></div>
				</div>
			</div>
		</div>
</form>
</div>
</body>
</html>
	