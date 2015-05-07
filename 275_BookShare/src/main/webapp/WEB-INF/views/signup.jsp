<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>

<body>

<div class="container">

	<form class="form-horizontal" id="userhome" action="signup" method="post" commandName="userdetails">
	
        <fieldset>
        <!-- Form Name -->
		<legend align="top">Register</legend>
			
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Name</label> 
			<div class="col-md-4">
				<input id="name" name="name" type="text" placeholder="Enter your name" class="form-control input-md">
				<font color="red"><form:errors path="name" required="true"></form:errors></font> 
				<font color="red"><form:errors path="name"></form:errors></font>
			</div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Age</label> 
			<div class="col-md-4">
				<input id="age" name="age" type="number" placeholder="Enter your age" class="form-control input-md">
				<font color="red"><form:errors path="age" ></form:errors></font> 
			</div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Email</label> 
			<div class="col-md-4">
				<input id="emailId" name="emailId" type="email" placeholder="Enter your email" class="form-control input-md">
				<font color="red"><form:errors path="emailId" required="true"></form:errors></font> 
				<font color="red"><label>${msg}</label></font>
			</div>
		</div>
		
		<!-- Text input-->
		<div class="form-group control-label">
			<label class="col-md-4 control-label" for="textinput">Phone</label> 
			<div class="col-md-4">
				<input id="phone" name="phone" type="number" placeholder="Enter your phone" class="form-control input-md">
				<font color="red"><form:errors path="phone" ></form:errors></font> 
			</div>
		</div>
		
		<!-- Text input-->
		<div class="form-group control-label">
			<label class="col-md-4 control-label" for="textinput">Address</label> 
			<div class="col-md-4">
				<input id="address" name="address" type="text" placeholder="Enter your address" class="form-control input-md">
				<font color="red"><form:errors path="address" ></form:errors></font> 
			</div>
		</div>
            
        <!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Password</label> 
			<div class="col-md-4">
				<input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md">
				<font color="red"><form:errors path="password" ></form:errors></font> 
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Register</button>
				<div><font color="red"><form:errors /></font></div>
			</div>
		</div>
		
	</fieldset>
</form>
</div>
</body>
</html>
	