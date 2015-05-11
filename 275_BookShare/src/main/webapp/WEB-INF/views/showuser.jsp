<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
	
	<script>
	
		function RedirectToEdit() {
			var x = document.getElementById('userId').value;
			if(document.getElementById('redirectTo').value == '')
							window.location = "../signup/" + x;
			else
				window.location = document.getElementById('redirectTo').value + "/" + x;
		}
	
		function RedirectToTransactions() {
			if(document.getElementById('redirectToTransac').value == '')
							window.location = "../transactions";
			else
				window.location = document.getElementById('redirectToTransac').value;
	
		}	
		
	</script>

</head>
<body>
	<div class="container-fluid">
		<div class="table-responsive col-md-offset-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">User Details</div>
				<table class="table table-striped">
            
		            <tr>
		                <td><label>Name</label></td>
		                <td><label>${userdetails.name}</label>
		                <input type="hidden" id="userId" value="${userdetails.userId}"></input>
		                <input type="hidden" id="redirectTo" value="${redirectTo}"></input>
		                <input type="hidden" id="redirectToTransac" value="${redirectToTransac}"></input></td>
		                <td></td>
		            </tr>
	           
		            <tr>
		                <td><label>Email Id</label></td>
		                <td><label >${userdetails.emailId}</label></td>
		                <td></td>
		                
		            </tr>
	            
					<tr>
		                <td><label>Address</label></td>
		                <td><label>${userdetails.address}</label></td>
		                <td></td>
					</tr>
					
					<tr>
					   <td><label>Phone Number</label></td>
					   <td><label>${userdetails.phone}</label></td>
					   <td></td>
					</tr>
	             
					<tr>
					   <td><label>Age</label></td>
					   <td><label>${userdetails.age}</label></td>
					    <td></td>
					</tr>
	            
		            <%-- <tr>
		                <td><label>Active</label></td>
		                <td><label>${userdetails.active}</label></td>
		                <td></td>
		            </tr> --%>
	             
		            <tr>
		                <td colspan="2" align="center"><input type="submit" class="btn btn-md btn-primary" value="View transactions" onClick="javascript: RedirectToTransactions();" />
						<input type="submit" class="btn btn-md btn-primary" value="Edit Profile" onClick="javascript: RedirectToEdit();" /></td>
		            </tr>
		            
		            <tr>
		                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
		            </tr>
	        	</table>
	        </div>
	    </div>
	</div>
</body>
</html>