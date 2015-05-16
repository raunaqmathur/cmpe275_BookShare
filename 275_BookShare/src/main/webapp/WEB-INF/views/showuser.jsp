<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<%@ page import="edu.sjsu.cmpe275.prj.models.user" %>
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
				<table class="table">
            
		            <tr class="info">
		                <td><label>Name</label></td>
		                <td><label>${userdetails.name}</label>
		                <input type="hidden" id="userId" value="${userdetails.userId}"></input>
		                <input type="hidden" id="redirectTo" value="${redirectTo}"></input>
		                <input type="hidden" id="redirectToTransac" value="${redirectToTransac}"></input></td>
		            </tr>
	           
		            <tr class="info">
		                <td><label>Email Id</label></td>
		                <td><label>${userdetails.emailId}</label></td>
		            </tr>
	            
					<tr class="info">
		                <td><label>Address</label></td>
		                <td><label>${userdetails.address}</label></td>
					</tr>
					
					<tr class="info">
					   <td><label>Phone Number</label></td>
					   <td><label>${userdetails.phone}</label></td>
					</tr>
	             
					<tr class="info">
					   <td><label>Age</label></td>
					   <td><label>${userdetails.age}</label></td>
					</tr>
	            
		            <% user User = (user)request.getAttribute("userdetails"); 
					   int ownerId = User.getUserId(); %>
	             	
	             	<tr class="info">
             		<% if(ownerId == Integer.parseInt(session.getAttribute("USERID").toString())){ %>
		                <td colspan="2" align="center">
			                <input type="submit" class="btn btn-md btn-primary" value="View transactions" onClick="javascript: RedirectToTransactions();"></input>
							<input type="submit" class="btn btn-md btn-primary" value="Edit Profile" onClick="javascript: RedirectToEdit();"></input>
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/buyer/${result.transactionId}" role="button">Feedbacks</a>
						</td>
		        	<% } else {%>
		        		<td colspan="2" align="center">
			                <a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/buyer/${result.transactionId}" role="button">Feedbacks</a>
						</td>
					<% } %> 
					</tr>
					
		            <tr class="info">
		                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
		            </tr>
	        	</table>
	        </div>
	    </div>
	</div>
</body>
</html>