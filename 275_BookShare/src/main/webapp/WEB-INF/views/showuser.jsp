<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
<html>
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>

<script>


		/*$(document).ready(function(){
		    if(document.getElementById('active').value == 0)
				document.getElementById('activeX').checked = true;
		    else
		    	document.getElementById('activeX').checked = false;
			
			
		});*/



	function RedirectToEdit()
	{
		alert('' + document.getElementById('redirectTo').value);
		var x = document.getElementById('userId').value;
		if(document.getElementById('redirectTo').value == '')
						window.location = "../signup/" + x;
		else
			window.location = document.getElementById('redirectTo').value + "/" + x;

	}

		function RedirectToTransactions()
		{
			alert('' + document.getElementById('redirectToTransac').value);
			
			if(document.getElementById('redirectToTransac').value == '')
							window.location = "../transactions";
			else
				window.location = document.getElementById('redirectToTransac').value;

		}


	
</script>

</head>
<body>
	<div class="table-responsive col-md-6">
		<table class="table table-striped">
            <tr>
                <td colspan="3"><h3>User Details</h3></td>
            </tr>
            
            
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
            <tr>
                <td><label>Active</label></td>
                <td><label>${userdetails.active}</label></td>
                <td></td>
                
            </tr>
             
         
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="View transactions" onClick="javascript: RedirectToTransactions();" />     <input type="submit"
                    value="Edit Profile" onClick="javascript: RedirectToEdit();" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </div>
</body>
</html>