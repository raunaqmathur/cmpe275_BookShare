<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <form:form id="login" action="login" method="post"
        commandName="logindetails">
        <table align="center">
            <tr>
                <td colspan="3"><h3>Please sign in</h3></td>
            </tr>
            
            <tr>
                <td><label>User Id</label></td>
                <td><form:input path="userId" ></form:input></td>
<<<<<<< HEAD

                <td><font color="red"><form:errors path="userId" required="true"></form:errors></font></td>

=======
                <td><font color="red"><form:errors path="userId"></form:errors></font></td>
>>>>>>> c115ba7b9356b000f56107d666ffbcdd24a5351b
            </tr>
            
            <tr>
                <td><label>Password </label></td>
<<<<<<< HEAD

                <td><form:input path="password" type="password" required="true"></form:input></td>

=======
                <td><form:input path="password" ></form:input></td>
>>>>>>> c115ba7b9356b000f56107d666ffbcdd24a5351b
                <td><font color="red"><form:errors path="password"></form:errors></font></td>
            </tr>
            
            <tr>
                <td colspan="3"><font color="red"><label>${msg}</label></font></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button></td>
                <td></td>
            </tr>

            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>