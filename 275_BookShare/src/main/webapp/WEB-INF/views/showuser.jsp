<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>

<script >


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
						window.location = "../userhome/" + x;
		else
			window.location = document.getElementById('redirectTo').value + "/" + x;

	}

	

	
</script>

</head>
<body>
    
        <table>
            <tr>
                <td colspan="3"><h3>User Details</h3></td>
            </tr>
            
            
            <tr>
                <td><label>Name</label></td>
                <td><label>${userdetails.name}</label>
                <input type="hidden" id="userId" value="${userdetails.userId}"></input>
                <input type="hidden" id="redirectTo" value="${redirectTo}"></input></td>
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
                    value="Edit" onClick="javascript: RedirectToEdit();" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    
</body>
</html>