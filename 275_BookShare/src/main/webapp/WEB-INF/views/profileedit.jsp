<<<<<<< Updated upstream
<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
=======
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp" />
>>>>>>> Stashed changes
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>BookShare</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
  </head>
<body>
    <form:form id="userhome" action="${path}" method="post" commandName="userdetails">
        <table align="center">
            <tr>
                <td colspan="3"><h3>Please enter your details</h3></td>
            </tr>
            
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name" type="text"></form:input>
                <form:input path="userId" type="hidden" name="userId"></form:input></td>
                <td><font color="red"><form:errors path="name" required="true"></form:errors></font></td>
            </tr>
            
            <tr>
                <td><label>Age</label></td>
                <td><form:input path="age" type="number" required="true"></form:input></td>
               
            </tr>
           
            <tr>
                <td><label>Email</label></td>
                <td><form:input type="email" path="emailId" ></form:input></td>
                <td><font color="red"><form:errors path="emailId" required="true" disabled="disabled"></form:errors></font></td>
                <td><label>${msg}</label></td>
                
            </tr>
             <tr>
                <td><label>Phone Number</label></td>
                <td><form:input type="number" path="phone" required="true"></form:input></td>
                
            </tr>
            <tr>
                <td><label>Address</label></td>
                <td><form:input path="address" required="true"></form:input></td>
                
            </tr>
            
           <tr>
                <td><label>Password</label></td>

                <td><form:input type="password" path="password" required="true" ></form:input></td>

            <tr>
                <td colspan="2" align="center"><button class="btn btn-sm btn-primary btn-block" type="submit">Update</button></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
